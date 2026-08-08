using System.Collections.Generic;
using System.Linq;

namespace MiniLanguageCompiler
{
    internal class SemanticChecker
    {
        public List<string> errors { get; } = new List<string>();
        public List<(string nameFunction, string structureType, int line)> controlStructures { get; } = new List<(string, string, int)>();
        public List<FunctionCallInfo> functionCalls { get; } = new List<FunctionCallInfo>();
        public Dictionary<string, List<string>> functionReturnTypes { get; } = new Dictionary<string, List<string>>();
        public Dictionary<string, string> functionReturnTypeByName = new Dictionary<string, string>();

        public List<Variable> globalVariables { get; } = new List<Variable>();
        public string currentFunction { get; set; }
        public bool IsTypeCompatible(string variableType, string expressionType)
        {
            if (variableType == expressionType)
                return true;

            if (variableType == "double" && (expressionType == "float" || expressionType == "int"))
                return true;

            if (variableType == "float" && expressionType == "int")
                return true;

            return false;
        }
        public void CheckFunctions(List<FunctionVisitor> functions)
        {
            int mainFunctionCount = 0;
            var functionsSignatures = new Dictionary<string, List<string>>();
            foreach (var function in functions)
            {
                if (function.IsMain()) mainFunctionCount++;
                var parametersTypes = function.parameters.Select(p => p.type).ToList();
                string nameFunction = function.name;
                if (functionsSignatures.TryGetValue(nameFunction, out var existingParameters))
                {
                    if (existingParameters.SequenceEqual(parametersTypes))
                        errors.Add($"Error: Function {nameFunction} with the same parameter types already exists.");
                }
                else functionsSignatures[nameFunction] = parametersTypes;
            }
            if (mainFunctionCount == 0)
                errors.Add("Error: The main function does not exist.");
            else if (mainFunctionCount > 1)
                errors.Add("Error: Multiple main functions exist.");
        }
        public void CheckFunctionCalls(List<FunctionCallInfo> functionsCalls, List<FunctionVisitor> functions)
        {
            var functionsSignatures = new Dictionary<string, List<string>>();
            foreach (var function in functions)
            {
                if (!functionsSignatures.ContainsKey(function.name))
                    functionsSignatures[function.name] = function.parameters.Select(parameter => parameter.type).ToList();
            }
            foreach (var call in functionsCalls)
            {
                if (!functionsSignatures.ContainsKey(call.name))
                {
                    errors.Add($"Error: Function {call.name} called at line {call.line} is not defined.");
                    continue;
                }

                var parametersTypes = functionsSignatures[call.name];
                if (parametersTypes.Count != call.arguments.Count)
                {
                    errors.Add($"Error: Function {call.name} called at line {call.line} has {call.arguments.Count} arguments, but {parametersTypes.Count} are expected.");
                    continue;
                }

                for (int i = 0; i < parametersTypes.Count; i++)
                {
                    if (!IsTypeCompatible(parametersTypes[i], call.arguments[i]))
                        errors.Add($"Error: Argument {i + 1} of function {call.name} at line {call.line} has type {call.arguments[i]}, but type {parametersTypes[i]} is expected.");
                }
            }
        }
        public void CheckMainRecursion()
        {
            foreach (var call in functionCalls)
            {
                if (call.name == "main")
                    errors.Add($"Error: The main function cannot be called at line {call.line}.");
            }
        }

        public void CheckLocalVariables(List<FunctionVisitor> functions)
        {
            foreach (var function in functions)
            {
                var nameVariables = new HashSet<string>();
                foreach (var localVariable in function.localVariables)
                    if (!nameVariables.Add(localVariable.name))
                        errors.Add($"Error: Local variable {localVariable.name} is declared multiple times in function {function.name}.");
            }
        }

        public void CheckParameterLocalConflicts(List<FunctionVisitor> functions)
        {
            foreach (var function in functions)
            {
                var parameterNames = function.parameters.Select(p => p.name).ToHashSet();
                foreach (var localVariable in function.localVariables)
                {
                    if (!localVariable.IsParameter && parameterNames.Contains(localVariable.name))
                        errors.Add($"Error: Local variable {localVariable.name} conflicts with a parameter in function {function.name}.");
                }
            }
        }

        public void CheckFunctionReturns(List<FunctionVisitor> functions)
        {

            foreach (var function in functions)
            {
                if (!functionReturnTypes.TryGetValue(function.name, out var returnTypes))
                {
                    if (function.returnType != "void")
                        errors.Add($"Error: Function {function.name} must return {function.returnType}, but it has no return statement.");
                    continue;
                }
                foreach (var currentReturnType in returnTypes)
                {
                    if (currentReturnType == "error") continue;

                    if (currentReturnType != function.returnType)
                        errors.Add($"Error: Function {function.name} must return {function.returnType}, but one of its branches returns {currentReturnType}.");
                }
            }
        }
    }
}