using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace MiniLanguageCompiler
{
    internal class Program
    {
        static void SaveTokens(CommonTokenStream tokens)
        {
            using (StreamWriter writer = new StreamWriter("tokens.txt"))
            {
                foreach (var token in tokens.GetTokens())
                {
                    if (token.Type == TokenConstants.EOF) continue;
                    writer.WriteLine($"<{MiniLanguageLexer.DefaultVocabulary.GetSymbolicName(token.Type)} , {token.Text} , {token.Line}>");
                }
            } 
        }
        static string GetMainType(FunctionVisitor function)
        {
            if (function.name == "main")
                return "main";
            
            return "non-main";
        }
        static string GetRecursionType(FunctionVisitor function, List<FunctionCallInfo> calls)
        {
            if (calls.Any(c => c.name == function.name && c.callerFunction==function.name))
                return "recursive";
            
            return "iterative";
        }
        static void SaveFunctions(List<FunctionVisitor> functions, SemanticChecker checker)
        {
            using (StreamWriter writer = new StreamWriter("functions.txt"))
            {
                foreach (var function in functions)
                {
                    string functionType = GetMainType(function);
                    string recursionType = GetRecursionType(function, checker.functionCalls);
                    if (functionType == "main")
                        writer.WriteLine($"Function {function.name} is {recursionType}.");
                    else writer.WriteLine($"Function {function.name} is {recursionType} and {functionType}.");
                    writer.WriteLine($"Return type: {function.returnType}.");
                    if (function.parameters.Count == 0)
                        writer.WriteLine("The function has no parameters.");
                    else
                    {
                        writer.WriteLine("Function parameters:");
                        foreach (var parameter in function.parameters)
                            writer.WriteLine($"{parameter.type} {parameter.name};");
                    }
                    if (!function.localVariables.Any(variable => !variable.IsParameter))
                        writer.WriteLine("The function has no local variables.");
                    else
                    {
                        writer.WriteLine("Local variables:");
                        foreach (var localVariable in function.localVariables)
                        {
                            if (localVariable.IsParameter) continue;

                            if (localVariable.IsConst)
                                writer.Write("const ");
                            writer.Write($"{localVariable.type} {localVariable.name}");
                            if (localVariable.value != null)
                                writer.Write($" = {localVariable.value};");
                            else writer.Write(";");
                            writer.WriteLine();
                        }
                    }
                    var controlStructures = checker.controlStructures.Where(cs => cs.nameFunction == function.name).ToList();
                    if (controlStructures.Count == 0)
                        writer.WriteLine("The function has no control structures.");
                    else
                    {
                        writer.WriteLine("Control structures used:");
                        foreach (var structure in controlStructures)
                            writer.WriteLine($"<{structure.structureType}, {structure.line}>");
                    }
                }
            }
        }
        static void SaveErrors(List<string> errors)
        {
            using (StreamWriter writer = new StreamWriter("errors.txt"))
            {
                foreach (var error in errors)
                    writer.WriteLine(error);
            }
        }
        static void SaveGlobalVariables(List<Variable> globalVariables)
        {
            using (StreamWriter writer = new StreamWriter("global_variables.txt"))
            {
                if (globalVariables.Count == 0)
                {
                    writer.WriteLine("There are no global variables.");
                    return;
                }
                writer.WriteLine("Global variables:");
                foreach (var variable in globalVariables)
                {
                    if (variable.IsConst)
                        writer.Write("const ");
                    writer.Write($"{variable.type} {variable.name}");
                    if (variable.value != null)
                        writer.Write($" = {variable.value};");
                    else writer.Write(";");
                    writer.WriteLine();
                }
            }
        }

        static void Main(string[] args)
        {
            using (StreamReader reader = new StreamReader("input.txt"))
            {
                string program = reader.ReadToEnd();
                if (string.IsNullOrWhiteSpace(program))
                {
                    Console.Error.WriteLine("Input file is empty.");
                    return;
                }

                var lexer = new MiniLanguageLexer(new AntlrInputStream(program));
                var lexerErrorListener = new LexerErrorListener();
                lexer.RemoveErrorListeners();
                lexer.AddErrorListener(lexerErrorListener);

                var tokens = new CommonTokenStream(lexer);
                var parser = new MiniLanguageParser(tokens);
                var parserErrorListener = new ParserErrorListener();
                parser.RemoveErrorListeners();
                parser.AddErrorListener(parserErrorListener);

                var tree = parser.program();

                SaveTokens(tokens);

                var semanticChecker = new SemanticChecker();
                semanticChecker.errors.AddRange(lexerErrorListener.errors);
                semanticChecker.errors.AddRange(parserErrorListener.errors);
                foreach (var globalDeclaration in tree.variableDeclaration())
                {
                    string globalVariableType = globalDeclaration.type().GetText();
                    bool isValid = true;
                    if (globalDeclaration.expression() != null)
                    {
                        var expressionVisitor = new ExpressionTypeVisitor(semanticChecker, new List<Variable>());
                        var expressionType = expressionVisitor.Visit(globalDeclaration.expression());

                        if (!semanticChecker.IsTypeCompatible(globalVariableType, expressionType))
                        {
                            semanticChecker.errors.Add(
                                $"Semantic error: Global variable {globalDeclaration.ID().GetText()} of type {globalVariableType} cannot be initialized with a value of type {expressionType} at line {globalDeclaration.Start.Line}."
                            );
                            isValid = false;
                        }
                    }
                    if (!isValid) continue;
                    var globalVariable = new Variable
                    {
                        name = globalDeclaration.ID().GetText(),
                        type = globalDeclaration.type().GetText(),
                        IsConst = globalDeclaration.CONST() != null,
                        value = globalDeclaration.expression() != null ? globalDeclaration.expression().GetText() : null
                    };
                    if (semanticChecker.globalVariables.Any(var => var.name == globalVariable.name))
                        semanticChecker.errors.Add(
                            $"Semantic error: Global variable {globalVariable.name} is already declared at line {globalDeclaration.Start.Line}."
                        );
                    else semanticChecker.globalVariables.Add(globalVariable);
                }

                var functions = new List<FunctionVisitor>();

                foreach (var function in tree.functionDeclaration())
                {
                    var functionVisitor = new FunctionVisitor(semanticChecker);
                    functionVisitor.Visit(function);
                    functions.Add(functionVisitor);
                    semanticChecker.functionReturnTypeByName[functionVisitor.name] = functionVisitor.returnType;
                }

                semanticChecker.CheckFunctions(functions);
                semanticChecker.CheckFunctionCalls(semanticChecker.functionCalls, functions);
                semanticChecker.CheckMainRecursion();
                semanticChecker.CheckLocalVariables(functions);
                semanticChecker.CheckParameterLocalConflicts(functions);
                semanticChecker.CheckFunctionReturns(functions);

                SaveFunctions(functions, semanticChecker);
                SaveErrors(semanticChecker.errors);
                SaveGlobalVariables(semanticChecker.globalVariables);

                Console.WriteLine("Analysis completed.");
                Console.WriteLine("You can find the following results:");
                Console.WriteLine("Lexical units: tokens.txt");
                Console.WriteLine("Functions: functions.txt");
                Console.WriteLine("Global variables: global_variables.txt");
                Console.WriteLine("Lexical, syntax, and semantic errors: errors.txt");
            }
        }
    }
}
