using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Tema_2_LFC
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
                        errors.Add($"Eroare: Functia {nameFunction} cu aceleasi tipuri de parametri exista deja.");
                }
                else functionsSignatures[nameFunction] = parametersTypes;
            }
            if (mainFunctionCount == 0)
                errors.Add("Eroare: Nu exista functia main.");
            else if (mainFunctionCount > 1)
                errors.Add("Eroare: Exista mai multe functii main.");
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
                    errors.Add($"Eroare: Functia {call.name} apelata la linia {call.line} nu este definita.");
                    continue;
                }

                var parametersTypes = functionsSignatures[call.name];
                if (parametersTypes.Count != call.arguments.Count)
                {
                    errors.Add($"Eroare: Functia {call.name} apelata la linia {call.line} are {call.arguments.Count} parametri, dar se asteapta {parametersTypes.Count}.");
                    continue;
                }

                for (int i = 0; i < parametersTypes.Count; i++)
                {
                    if (!IsTypeCompatible(parametersTypes[i], call.arguments[i]))
                        errors.Add($"Eroare: Argumentul {i + 1} al functiei {call.name} la linia {call.line} are tip {call.arguments[i]}, dar se asteapta {parametersTypes[i]}.");
                }
            }
        }
        public void CheckMainRecursion()
        {
            foreach (var call in functionCalls)
            {
                if (call.name == "main")
                    errors.Add($"Eroare: Functia main nu poate fi apelata la linia {call.line}");
            }
        }

        public void CheckLocalVariables(List<FunctionVisitor> functions)
        {
            foreach (var function in functions)
            {
                var nameVariables = new HashSet<string>();
                foreach (var localVariable in function.localVariables)
                    if (!nameVariables.Add(localVariable.name))
                        errors.Add($"Eroare: Variabila locala {localVariable.name} este declarata de mai multe ori in functia {function.name}.");
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
                        errors.Add($"Eroare: Variabila locala {localVariable.name} coincide cu parametrul din functia {function.name}.");
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
                        errors.Add($"Eroare: Functia {function.name} trebuie sa returneze {function.returnType}, dar nu are niciun return.");
                    continue;
                }
                foreach (var currentReturnType in returnTypes)
                {
                    if (currentReturnType == "error") continue;
                    if (currentReturnType != function.returnType)
                        errors.Add($"Eroare: Functia {function.name} trebuie sa returneze {function.returnType}, dar pe una din ramuri returneaza {currentReturnType}.");
                }
            }
        }
    }
}