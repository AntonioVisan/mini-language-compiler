using Antlr4.Runtime.Misc;
using System.Collections.Generic;
using System.Linq;

namespace MiniLanguageCompiler
{
    internal class ExpressionTypeVisitor : MiniLanguageBaseVisitor<string>
    {
        private readonly SemanticChecker semanticChecker;
        private readonly List<Variable> localVariables;
        private readonly List<string> argumentTypes = new List<string>();
        
        public ExpressionTypeVisitor(SemanticChecker semanticChecker, List<Variable> localVariables)
        {
            this.semanticChecker = semanticChecker;
            this.localVariables = localVariables;
        }

        private bool IsNumeric(string type) => type == "int" || type == "float" || type == "double";

        private string PromoteNumeric(string type1, string type2)
        {
            if (type1 == "double" || type2 == "double")
                return "double";
            if (type1 == "float" || type2 == "float")
                return "float";
            return "int";
        }

        public override string VisitType([NotNull] MiniLanguageParser.TypeContext context)
        {
            if (context.INT() != null) return "int";
            if (context.FLOAT() != null) return "float";
            if (context.DOUBLE() != null) return "double";
            if (context.STRING() != null) return "string";
            if (context.BOOL() != null) return "bool";
            if (context.VOID() != null) return "void";
            semanticChecker.errors.Add($"Error: Type {context.GetText()} is not recognized at line {context.Start.Line}.");
            return "error";
        }

        public override string VisitExpression([NotNull] MiniLanguageParser.ExpressionContext context)
        {
            return Visit(context.assignment());
        }

        public override string VisitAssign([NotNull] MiniLanguageParser.AssignContext context)
        {
            var nameVariable = context.ID().GetText();
            var valueType = Visit(context.assignment());
            var variable = localVariables.FirstOrDefault(var => var.name == nameVariable)
                ?? semanticChecker.globalVariables.FirstOrDefault(var => var.name == nameVariable);

            if (variable != null)
            {
                if (variable.IsConst)
                {
                    semanticChecker.errors.Add($"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}.");
                    return "error";
                }
                if (variable.type != valueType)
                {
                    semanticChecker.errors.Add($"Error: Variable {nameVariable} has type {variable.type}, which is incompatible with the value type {valueType}, at line {context.Start.Line}.");
                    return "error";
                }
            }
            
            else
            {
                semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist at line {context.Start.Line}.");
                return "error";
            }

            return valueType;
        }

        public override string VisitPlusAssign([NotNull] MiniLanguageParser.PlusAssignContext context)
        {
            var nameVariable = context.ID().GetText();
            var valueType = Visit(context.assignment());
            
            var variable = localVariables.FirstOrDefault(v => v.name == nameVariable)
                ?? semanticChecker.globalVariables.FirstOrDefault(v => v.name == nameVariable);

            if (variable == null)
            {
                semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist at line {context.Start.Line}.");
                return "error";
            }

            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}.");
                return "error";
            }

            if (variable.type == "string" && valueType == "string")
                return "string";

            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);

            semanticChecker.errors.Add($"Error: The += assignment operator cannot be applied between {variable.type} and {valueType} at line {context.Start.Line}.");
            return "error";
        }

        public override string VisitMinusAssign([NotNull] MiniLanguageParser.MinusAssignContext context)
        {
            var nameVariable = context.ID().GetText();
            var valueType = Visit(context.assignment());
            var variable = localVariables.FirstOrDefault(v => v.name == nameVariable)
                ?? semanticChecker.globalVariables.FirstOrDefault(v => v.name == nameVariable);

            if (variable == null)
            {
                semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist at line {context.Start.Line}.");
                return "error";
            }

            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}.");
                return "error";
            }

            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add(
                    $"Error: Operator -= is not allowed on strings at line {context.Start.Line}."
                );
                return "error";
            }

            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);

            semanticChecker.errors.Add(
                $"Error: The -= assignment operator cannot be applied between {variable.type} and {valueType} at line {context.Start.Line}."
            );
            
            return "error";
        }

        public override string VisitMultiplyAssign([NotNull] MiniLanguageParser.MultiplyAssignContext context)
        {
            var nameVariable = context.ID().GetText();
            var valueType = Visit(context.assignment());
            var variable = localVariables.FirstOrDefault(v => v.name == nameVariable)
                ?? semanticChecker.globalVariables.FirstOrDefault(v => v.name == nameVariable);

            if (variable == null)
            {
                semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist at line {context.Start.Line}.");
                return "error";
            }

            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}.");
                return "error";
            }

            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add(
                    $"Error: Operator *= is not allowed on strings at line {context.Start.Line}."
                );
                return "error";
            }

            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);

            semanticChecker.errors.Add($"Error: The *= assignment operator cannot be applied between {variable.type} and {valueType} at line {context.Start.Line}.");
            return "error";
        }

        public override string VisitDivideAssign([NotNull] MiniLanguageParser.DivideAssignContext context)
        {
            var nameVariable = context.ID().GetText();
            var valueType = Visit(context.assignment());
            var variable = localVariables.FirstOrDefault(v => v.name == nameVariable)
                ?? semanticChecker.globalVariables.FirstOrDefault(v => v.name == nameVariable);

            if (variable == null)
            {
                semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist at line {context.Start.Line}.");
                return "error";
            }

            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}.");
                return "error";
            }

            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add(
                    $"Error: Operator /= is not allowed on strings at line {context.Start.Line}."
                );
                return "error";
            }

            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);

            semanticChecker.errors.Add($"Error: The /= assignment operator cannot be applied between {variable.type} and {valueType} at line {context.Start.Line}.");
            return "error";
        }

        public override string VisitModuloAssign([NotNull] MiniLanguageParser.ModuloAssignContext context)
        {
            var nameVariable = context.ID().GetText();
            var valueType = Visit(context.assignment());
            var variable = localVariables.FirstOrDefault(v => v.name == nameVariable)
                ?? semanticChecker.globalVariables.FirstOrDefault(v => v.name == nameVariable);

            if (variable == null)
            {
                semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist at line {context.Start.Line}.");
                return "error";
            }

            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}.");
                return "error";
            }

            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add(
                    $"Error: Operator %= is not allowed on strings at line {context.Start.Line}."
                );
                return "error";
            }

            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);

            semanticChecker.errors.Add($"Error: The %= assignment operator cannot be applied between {variable.type} and {valueType} at line {context.Start.Line}.");
            return "error";
        }

        public override string VisitAssignExpression([NotNull] MiniLanguageParser.AssignExpressionContext context)
        {
            return Visit(context.logicalOr());
        }

        public override string VisitLogicalOr([NotNull] MiniLanguageParser.LogicalOrContext context)
        {
            var leftType = Visit(context.logicalAnd(0));

            for (int i = 1; i < context.logicalAnd().Length; i++)
            {
                var rightType = Visit(context.logicalAnd(i));
                    
                if (leftType != "bool" || rightType != "bool")
                {
                    semanticChecker.errors.Add($"Error: The || operator requires boolean operands, but the types are {leftType} and {rightType} at line {context.Start.Line}.");
                    leftType = "error";
                    break;
                }
            }

            return leftType;
        }

        public override string VisitLogicalAnd([NotNull] MiniLanguageParser.LogicalAndContext context)
        {
            var leftType = Visit(context.equality(0));

            for (int i = 1; i < context.equality().Length; i++)
            {
                var rightType = Visit(context.equality(i));

                if (leftType != "bool" || rightType != "bool")
                {
                    semanticChecker.errors.Add($"Error: The && operator requires boolean operands, but the types are {leftType} and {rightType} at line {context.Start.Line}.");
                    leftType = "error";
                    break;
                }
            }

            return leftType;
        }

        public override string VisitEquality([NotNull] MiniLanguageParser.EqualityContext context)
        {
            var leftType = Visit(context.relational(0));

            if (context.relational().Length == 1)
                return leftType;

            for (int i = 1; i < context.relational().Length; i++)
            {
                var rightType = Visit(context.relational(i));

                if (leftType == "error" || rightType == "error")
                    return "error";

                if (IsNumeric(leftType) && IsNumeric(rightType))
                {
                    leftType = PromoteNumeric(leftType, rightType);
                }

                else if (leftType != rightType)
                {
                    semanticChecker.errors.Add(
                        $"Error: Invalid comparison between {leftType} and {rightType} at line {context.Start.Line}."
                    );
                    return "error";
                }
            }

            return "bool";
        }

        public override string VisitRelational([NotNull] MiniLanguageParser.RelationalContext context)
        {
            var leftType = Visit(context.additive(0));

            if (context.additive().Length == 1)
                return leftType;

            for (int i = 1; i < context.additive().Length; i++)
            {
                var rightType = Visit(context.additive(i));
                var operation = context.GetChild(2 * i - 1).GetText();

                if (!IsNumeric(leftType) || !IsNumeric(rightType))
                {
                    semanticChecker.errors.Add($"Error: Operator {operation} requires numeric types, but the types are {leftType} and {rightType} at line {context.Start.Line}.");
                    return "error";
                }
            }

            return "bool";
        }

        public override string VisitAdditive([NotNull] MiniLanguageParser.AdditiveContext context)
        {
            var leftType = Visit(context.multiplicative(0));

            for (int i = 1; i < context.multiplicative().Length; i++)
            {
                var rightType = Visit(context.multiplicative(i));
                var operation = context.GetChild(2 * i - 1).GetText();
                 
                if (leftType == "error" || rightType == "error")
                    return "error";

                if (leftType == "string" || rightType == "string")
                {
                    if (operation == "+")
                        leftType = "string";
                    else
                    {
                        semanticChecker.errors.Add(
                            $"Error: Operator {operation} cannot be applied between {leftType} and {rightType} at line {context.Start.Line}."
                        );
                        leftType = "error";
                        break;
                    }
                }

                else if (IsNumeric(leftType) && IsNumeric(rightType))
                    leftType = PromoteNumeric(leftType, rightType);

                else
                {
                    semanticChecker.errors.Add($"Error: Operator {operation} cannot be applied between {leftType} and {rightType} at line {context.Start.Line}.");
                    leftType = "error";
                    break;
                }
            }

            return leftType;
        }

        public override string VisitMultiplicative([NotNull] MiniLanguageParser.MultiplicativeContext context)
        {
            var leftType = Visit(context.unary(0));

            for (int i = 1; i < context.unary().Length; i++)
            {
                var rightType = Visit(context.unary(i));
                var operation = context.GetChild(2 * i - 1).GetText();
                
                if (leftType == "error" || rightType == "error")
                    return "error";

                else if (IsNumeric(leftType) && IsNumeric(rightType))
                    leftType = PromoteNumeric(leftType, rightType);

                else
                {
                    semanticChecker.errors.Add(
                        $"Error: Operator {operation} cannot be applied between {leftType} and {rightType} at line {context.Start.Line}."
                    );
                    leftType = "error";
                    break;
                }
            }

            return leftType;
        }

        public override string VisitUnary([NotNull] MiniLanguageParser.UnaryContext context)
        {
            if (context.NOT() != null)
            {
                var type = Visit(context.unary());

                if (type != "bool")
                {
                    semanticChecker.errors.Add($"Error: The ! operator cannot be applied to type {type} at line {context.Start.Line}.");
                    return "error";
                }

                return "bool";
            }
            else return Visit(context.postfix());
        }

        public override string VisitPostfix([NotNull] MiniLanguageParser.PostfixContext context)
        {
            var typeValue = Visit(context.primary());

            if (context.INCREMENT() != null || context.DECREMENT() != null)
            {
                var operatorPostFix = context.INCREMENT() != null ? "++" : "--";

                if (context.primary().ID() != null)
                {
                    var nameVariable = context.primary().ID().GetText();

                    var variable = localVariables.FirstOrDefault(v => v.name == nameVariable)
                        ?? semanticChecker.globalVariables.FirstOrDefault(v => v.name == nameVariable);

                    if (variable != null && variable.IsConst)
                    {
                        semanticChecker.errors.Add(
                            $"Error: Const variable {nameVariable} cannot be modified at line {context.Start.Line}."
                        );
                        return "error";
                    }
                }

                if (!IsNumeric(typeValue))
                {
                    semanticChecker.errors.Add(
                        $"Error: Operator {operatorPostFix} can only be applied to numeric types, but the type is {typeValue} at line {context.Start.Line}."
                    );
                    return "error";
                }
            }

            return typeValue;
        }

        public override string VisitPrimary([NotNull] MiniLanguageParser.PrimaryContext context)
        {
            if (context.ID() != null)
            {
                var nameVariable = context.ID().GetText();

                var variableFound = localVariables.FirstOrDefault(variable => variable.name == nameVariable)
                    ?? semanticChecker.globalVariables.FirstOrDefault(variable => variable.name == nameVariable);

                if (variableFound == null)
                {
                    semanticChecker.errors.Add($"Error: Variable {nameVariable} does not exist in the current scope at line {context.Start.Line}.");
                    return "error";
                }

                return variableFound.type;
            }
            else if (context.literal() != null)
                return Visit(context.literal());
            else if (context.functionCall() != null)
                return Visit(context.functionCall());
            else if (context.expression() != null)
                return Visit(context.expression());
            else
            {
                semanticChecker.errors.Add($"Error: Unknown primary expression at line {context.Start.Line}.");
                return "error";
            }
        }
        public override string VisitFunctionCall([NotNull] MiniLanguageParser.FunctionCallContext context)
        {
            var nameFunction = context.ID().GetText();
            var functionCallInfo = new FunctionCallInfo
            {  
                name = nameFunction,
                callerFunction = semanticChecker.currentFunction,
                line = context.Start.Line
            };

            if (context.argumentList() != null)
                Visit(context.argumentList());

            functionCallInfo.arguments.AddRange(argumentTypes);
            semanticChecker.functionCalls.Add(functionCallInfo);

            if (semanticChecker.functionReturnTypeByName.TryGetValue(nameFunction, out var returnType))
                return returnType;

            return "unknown";
        }

        public override string VisitArgumentList([NotNull] MiniLanguageParser.ArgumentListContext context)
        {
            argumentTypes.Clear();

            foreach (var expression in context.expression())
            {
                var typeExpression = Visit(expression);
                argumentTypes.Add(typeExpression);
            }

            return null;
        }

        public override string VisitLiteral([NotNull] MiniLanguageParser.LiteralContext context)
        {
            if (context.POSITIVE_LITERAL() != null) return "int";
            if (context.FLOAT_LITERAL() != null) return "float";
            if (context.STRING_LITERAL() != null) return "string";
            if (context.TRUE() != null || context.FALSE() != null) return "bool";

            semanticChecker.errors.Add($"Error: Unknown literal: {context.GetText()} at line {context.Start.Line}.");
            return "error";
        }
    }
}