using Antlr4.Runtime.Misc;
using System.Collections.Generic;
using System.Linq;

namespace MiniLanguageCompiler
{
    internal class StatementVisitor : MiniLanguageBaseVisitor<object>
    {
        private SemanticChecker semanticChecker;
        private string currentFunctionName;
        private List<Variable> localVariables;
        private ExpressionTypeVisitor expressionTypeVisitor;
        public StatementVisitor(SemanticChecker semanticChecker, string currentFunctionName, List<Variable> localVariables, ExpressionTypeVisitor expressionTypeVisitor)
        {
            this.semanticChecker = semanticChecker;
            this.currentFunctionName = currentFunctionName;
            this.localVariables = localVariables;
            this.expressionTypeVisitor = expressionTypeVisitor;
        }
        public override object VisitStatement([NotNull] MiniLanguageParser.StatementContext context)
        {
            if (context.expression() != null)
                expressionTypeVisitor.Visit(context.expression());
            return base.VisitStatement(context);
        }
        public override object VisitIfStatement([NotNull] MiniLanguageParser.IfStatementContext context)
        {
            semanticChecker.controlStructures.Add((currentFunctionName, "if", context.Start.Line));

            if (context.expression() != null)
            {
                var expressionType = expressionTypeVisitor.Visit(context.expression());
                if (expressionType != "bool")
                    semanticChecker.errors.Add($"Error: The condition in if must be boolean at line {context.Start.Line}.");
            }
            Visit(context.statement(0));
            if (context.statement().Length > 1 && context.statement(1) != null)
            {
                semanticChecker.controlStructures.Add((currentFunctionName, "else", context.statement(1).Start.Line));
                Visit(context.statement(1));
            }
            return null;
        }

        public override object VisitForStatement([NotNull] MiniLanguageParser.ForStatementContext context)
        {
            semanticChecker.controlStructures.Add((currentFunctionName, "for", context.Start.Line));

            var forVariables = new List<Variable>(localVariables);
            var forExpressionVisitor = new ExpressionTypeVisitor(semanticChecker, forVariables);

            if (context.forInitialization() != null)
            {
                var initialization = context.forInitialization();

                if (initialization.type() != null)
                {
                    var variableName = initialization.ID().GetText();
                    var variableType = initialization.type().GetText();

                    if (forVariables.Any(variable => variable.name == variableName))
                        semanticChecker.errors.Add(
                            $"Error: Variable {variableName} is already declared in the for statement at line {context.Start.Line}."
                        );
                    else
                    {
                        var variable = new Variable
                        {
                            name = variableName,
                            type = variableType,
                            IsConst = false,
                            IsParameter = false
                        };

                        if (initialization.expression() != null)
                        {
                            var expressionType = forExpressionVisitor.Visit(initialization.expression());

                            if (!semanticChecker.IsTypeCompatible(variableType, expressionType))
                                semanticChecker.errors.Add(
                                    $"Error: Variable {variableName} of type {variableType} cannot be initialized with a value of type {expressionType} at line {context.Start.Line}."
                                );
                        }

                        forVariables.Add(variable);
                    }
                }
                else
                {
                    forExpressionVisitor.Visit(initialization.assignment());
                }
            }

            if (context.expression(0) != null)
            {
                var conditionType = forExpressionVisitor.Visit(context.expression(0));
                if (conditionType != "bool")
                    semanticChecker.errors.Add($"Error: The condition in for must be boolean at line {context.Start.Line}.");
            }
            if (context.expression(1) != null)
                forExpressionVisitor.Visit(context.expression(1));

            var innerVisitor = new StatementVisitor(semanticChecker, currentFunctionName, forVariables, forExpressionVisitor);
            innerVisitor.Visit(context.statement());
            return null;
        }

        public override object VisitWhileStatement([NotNull] MiniLanguageParser.WhileStatementContext context)
        {
            semanticChecker.controlStructures.Add((currentFunctionName, "while", context.Start.Line));
            if (context.expression() != null)
            {
                var expressionType = expressionTypeVisitor.Visit(context.expression());
                if (expressionType != "bool")
                    semanticChecker.errors.Add($"Error: The condition in while must be boolean at line {context.Start.Line}.");
            }
            Visit(context.statement());
            return null;
        }

        public override object VisitReturnStatement([NotNull] MiniLanguageParser.ReturnStatementContext context)
        {
            semanticChecker.controlStructures.Add((currentFunctionName, "return", context.Start.Line));
            if (!semanticChecker.functionReturnTypes.TryGetValue(currentFunctionName, out var listReturnTypes))
            {
                listReturnTypes = new List<string>();
                semanticChecker.functionReturnTypes[currentFunctionName] = listReturnTypes;
            }
            if (context.expression() != null)
            {
                var expressionType = expressionTypeVisitor.Visit(context.expression());
                listReturnTypes.Add(expressionType);
            }
            else listReturnTypes.Add("void");
            return null;
        }

        public override object VisitBlockStatement([NotNull] MiniLanguageParser.BlockStatementContext context)
        {
            semanticChecker.controlStructures.Add((currentFunctionName, "{ }", context.Start.Line));
            var innerVariables = new List<Variable>(localVariables);
            var innerVisitor = new StatementVisitor(semanticChecker, currentFunctionName, innerVariables, expressionTypeVisitor);
            foreach (var statement in context.statement())
                innerVisitor.Visit(statement);
            return null;
        }
    }
}