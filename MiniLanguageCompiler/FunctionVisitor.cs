using Antlr4.Runtime.Misc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace MiniLanguageCompiler
{
    internal class FunctionVisitor : MiniLanguageBaseVisitor<object>
    {
        private SemanticChecker semanticChecker;
        public string name { get; set; }
        public string returnType { get; set; }
        public List<Parameter> parameters { get; set; } = new List<Parameter>();
        public List<Variable> localVariables { get; set; } = new List<Variable>();

        private HashSet<Variable> constVariables = new HashSet<Variable>();
        public FunctionVisitor(SemanticChecker semanticChecker)
        {
            this.semanticChecker = semanticChecker;
        }
        public bool IsMain() => name == "main";

        private bool IsTypeCompatible(string variableType, string expressionType)
        {
            if (variableType == expressionType)
                return true;

            if (variableType == "double" && (expressionType == "float" || expressionType == "int"))
                return true;

            if (variableType == "float" && expressionType == "int")
                return true;

            return false;
        }


        public override object VisitFunctionDeclaration([NotNull] MiniLanguageParser.FunctionDeclarationContext context)
        {
            name = context.ID().GetText();
            semanticChecker.currentFunction = name;
            returnType = context.type().GetText();

            if (context.parametersList() != null)
                Visit(context.parametersList());

            foreach (var param in parameters)
            {
                localVariables.Add(new Variable
                {
                    name = param.name,
                    type = param.type,
                    IsConst = false,
                    IsParameter = true
                });
            }

            var expressionVisitor = new ExpressionTypeVisitor(semanticChecker, localVariables);

            var statementVisitor = new StatementVisitor(semanticChecker, name, localVariables, expressionVisitor);
            foreach (var statement in context.statement())
            {
                if (statement.variableDeclaration() != null)
                    VisitVariableDeclaration(statement.variableDeclaration());
                else
                    statementVisitor.Visit(statement);
            }
            return null;
        }
        public override object VisitVariableDeclaration([NotNull] MiniLanguageParser.VariableDeclarationContext context)
        {
            var expressionVisitor = new ExpressionTypeVisitor(semanticChecker, localVariables);
            HandleVariableDeclaration(context, expressionVisitor);
            return null;
        }
        public override object VisitParameter([NotNull] MiniLanguageParser.ParameterContext context)
        {
            parameters.Add(new Parameter
            {
                name = context.ID().GetText(),
                type = context.type().GetText()
            });
            return null;
        }

        private void HandleVariableDeclaration([NotNull] MiniLanguageParser.VariableDeclarationContext context, ExpressionTypeVisitor expressionVisitor)
        {
            var localVariable = new Variable
            {
                name = context.ID().GetText(),
                type = context.type().GetText(),
                value = null,
                IsConst = context.CONST() != null,
                IsParameter = false
            };

            if (localVariables.Any(variable => variable.name == localVariable.name))
            {
                semanticChecker.errors.Add($"Eroare semantica: Variabila locala {localVariable.name} este deja declarata la linia {context.Start.Line}.");
                return;
            }
            if (parameters.Any(parameter => parameter.name == localVariable.name))
            {
                semanticChecker.errors.Add($"Eroare semantica: Variabila locala {localVariable.name} coincide cu parametrul din functia {name}, la linia {context.Start.Line}.");
                return;
            }

            localVariables.Add(localVariable);

            if (localVariable.IsConst && context.expression() == null)
            {
                semanticChecker.errors.Add($"Eroare semantica: Variabila const {localVariable.name} trebuie initializata la declarare, la linia {context.Start.Line}.");
                return;
            }
            if (context.expression() != null)
            {
                var expressionType = expressionVisitor.Visit(context.expression());

                if (expressionType == "unknown" || expressionType == "error")
                    return;

                localVariable.value = context.expression().GetText();
                if (expressionType != null && !IsTypeCompatible(localVariable.type, expressionType))
                {
                    semanticChecker.errors.Add($"Eroare semantica: Nu se poate initializa variabila {localVariable.name} de tip {localVariable.type} cu o valoare de tip {expressionType}, la linia {context.Start.Line}.");
                    return;
                }
            }
            if (localVariable.IsConst)
                constVariables.Add(localVariable);
        }
    }
}