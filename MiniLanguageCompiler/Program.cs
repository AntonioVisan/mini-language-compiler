using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;
namespace MiniLanguageCompiler
{
    internal class Program
    {
        static void SaveTokens(CommonTokenStream tokens)
        {
            StreamWriter writer = new StreamWriter("tokens.txt");
            foreach(var token in tokens.GetTokens())
            {
                if (token.Type == TokenConstants.EOF) continue;
                writer.WriteLine($"<{MiniLanguageLexer.DefaultVocabulary.GetSymbolicName(token.Type)} , {token.Text} , {token.Line}>");
            }
            writer.Close();
        }
        static string GetMainType(FunctionVisitor function)
        {
            if (function.name == "main")
                return "main";
            else return "non-main";
        }
        static string GetRecursionType(FunctionVisitor function, List<FunctionCallInfo> calls)
        {
            if (calls.Any(c => c.name == function.name && c.callerFunction==function.name))
                return "recursiva";
            else return "iterativa";
        }
        static void SaveFunctions(List<FunctionVisitor> functions, SemanticChecker checker)
        {
            StreamWriter writer = new StreamWriter("functions.txt");
            foreach(var function in functions)
            {
                string functionType = GetMainType(function);
                string recursionType = GetRecursionType(function, checker.functionCalls);
                if (functionType == "main")
                    writer.WriteLine($"Functia {function.name} este {recursionType}.");
                else writer.WriteLine($"Functia {function.name} este {recursionType} si {functionType}.");
                writer.WriteLine($"Are tipul returnat: {function.returnType}.");
                if (function.parameters.Count == 0)
                    writer.WriteLine("Functia nu are parametri.");
                else
                {
                    writer.WriteLine("Parametrii functiei sunt: ");
                    foreach (var parameter in function.parameters)
                        writer.WriteLine($"{parameter.type} {parameter.name};");
                }
                if (function.localVariables.Any(variable => !variable.IsParameter)==false)
                    writer.WriteLine("Functia nu are variabile locale.");
                else
                {
                    writer.WriteLine("Variabilele locale ale functiei sunt: ");
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
                    writer.WriteLine("Aceasta functie nu are structuri de control.");
                else
                {
                    writer.WriteLine("Lista structurilor de control folosite: ");
                    foreach (var structure in controlStructures)
                        writer.WriteLine($"<{structure.structureType}, {structure.line}>");
                }
            }
            writer.Close();
        }
        static void SaveErrors(List<string> errors)
        {
            StreamWriter writer = new StreamWriter("errors.txt");
            foreach (var error in errors)
                writer.WriteLine(error);
            writer.Close();
        }
        static void SaveGlobalVariables(List<Variable> globalVariables)
        {
            StreamWriter writer = new StreamWriter("global_variables.txt");
            if(globalVariables.Count==0)
            {
                writer.WriteLine("Nu exista variabile globale.");
                writer.Close();
                return;
            }
            writer.WriteLine("Variabilele globale sunt: ");
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
            writer.Close();
        }
        static void Main(string[] args)
        {
            StreamReader reader = new StreamReader("input.txt");

            string program = reader.ReadToEnd();
            if (program == null)
            {
                Console.Error.WriteLine("Programul nu a fost citit.");
                return;
            }
            reader.Close();

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
                        semanticChecker.errors.Add($"Eroare semantica: Nu se poate initializa variabila globala {globalDeclaration.ID().GetText()} de tip {globalVariableType} cu o valoare de tip {expressionType}, la linia {globalDeclaration.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare semantica: Variabila globala {globalVariable.name} este deja declarata la linia {globalDeclaration.Start.Line}.");
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

            Console.WriteLine("Analiza finalizata.");
            Console.WriteLine("Poti vedea rezultatele urmatoare:");
            Console.WriteLine("Pentru lista de unitati lexicale in fisierul tokens.txt");
            Console.WriteLine("Pentru lista de functii in fisierul functions.txt");
            Console.WriteLine("Pentru lista de variabile globale in fisierul global_variables.txt");
            Console.WriteLine("Pentru semnalarea erorilor lexicale,sintactice si semantice in fisierul errors.txt");
        }
    }
}
