using Antlr4.Runtime.Misc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace MiniLanguageCompiler
{
    internal class ExpressionTypeVisitor : MiniLanguageBaseVisitor<string>
    {
        private SemanticChecker semanticChecker;
        private List<Variable> localVariables;
        private List<string> argumentTypes = new List<string>();
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
            semanticChecker.errors.Add($"Eroare: Tipul {context.GetText()} nu este recunoscut la linia {context.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare: Variabila const {nameVariable} nu poate fi modificata la linia {context.Start.Line}.");
                    return "error";
                }
                if (variable.type != valueType)
                {
                    semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} are tipul {variable.type} care este incompatibil cu tipul valorii {valueType}, la linia {context.Start.Line}.");
                    return "error";
                }
            }
            else
            {
                semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} nu exista la linia {context.Start.Line}.");
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
                semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} nu exista la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Eroare: Variabila const {nameVariable} nu poate fi modificata la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.type == "string" || valueType == "string")
                return "string";

            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);
            semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul de asignare += intre {variable.type} si {valueType} la linia {context.Start.Line}.");
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
                semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} nu exista la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Eroare: Variabila const {nameVariable} nu poate fi modificata la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add($"Eroare: Operatorul {context.GetText()} nu este permis pe string la linia {context.Start.Line}.");
                return "error";
            }
            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);
            semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul de asignare -= intre {variable.type} si {valueType} la linia {context.Start.Line}.");
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
                semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} nu exista la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Eroare: Variabila const {nameVariable} nu poate fi modificata la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add($"Eroare: Operatorul {context.GetText()} nu este permis pe string la linia {context.Start.Line}.");
                return "error";
            }
            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);
            semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul de asignare *= intre {variable.type} si {valueType} la linia {context.Start.Line}.");
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
                semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} nu exista la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Eroare: Variabila const {nameVariable} nu poate fi modificata la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add($"Eroare: Operatorul {context.GetText()} nu este permis pe string la linia {context.Start.Line}.");
                return "error";
            }
            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);
            semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul de asignare /= intre {variable.type} si {valueType} la linia {context.Start.Line}.");
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
                semanticChecker.errors.Add($"Eroare: Variabila {nameVariable} nu exista la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.IsConst)
            {
                semanticChecker.errors.Add($"Eroare: Variabila const {nameVariable} nu poate fi modificata la linia {context.Start.Line}.");
                return "error";
            }
            if (variable.type == "string" || valueType == "string")
            {
                semanticChecker.errors.Add($"Eroare: Operatorul {context.GetText()} nu este permis pe string la linia {context.Start.Line}.");
                return "error";
            }
            if (IsNumeric(variable.type) && IsNumeric(valueType))
                return PromoteNumeric(variable.type, valueType);
            semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul de asignare %= intre {variable.type} si {valueType} la linia {context.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare: Operatorul || necesita boolean, dar avem tipurile {leftType} si {rightType} la linia {context.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare: Operatorul && necesita boolean, dar avem tipurile {leftType} si {rightType} la linia {context.Start.Line}.");
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
                if (leftType != rightType)
                {
                    semanticChecker.errors.Add($"Eroare: Comparatie invalida intre {leftType} si {rightType} la linia {context.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare: Operatorul {operation} necesita tip numeric, dar avem tipurile {leftType} si {rightType} la linia {context.Start.Line}.");
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
                    leftType = "string";
                else if (IsNumeric(leftType) && IsNumeric(rightType))
                    leftType = PromoteNumeric(leftType, rightType);
                else
                {
                    semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul {operation} intre {leftType} si {rightType} la linia {context.Start.Line}.");
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
                if (leftType == "string" || rightType == "string")
                    leftType = "string";
                else if (IsNumeric(leftType) && IsNumeric(rightType))
                    leftType = PromoteNumeric(leftType, rightType);
                else
                {
                    semanticChecker.errors.Add($"Eroare: Nu se poate aplica operatorul {operation} intre {leftType} si {rightType} la linia {context.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare: operatorul ! nu poate fi aplicat pe tipul {type} la linia {context.Start.Line}.");
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
                if (!IsNumeric(typeValue))
                {
                    var operatorPostFix = context.INCREMENT() != null ? "++" : "--";
                    semanticChecker.errors.Add($"Eroare: Operatorul {operatorPostFix} poate fi aplicat doar pe tip numeric, dar avem tipul {typeValue} la linia {context.Start.Line}.");
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
                    semanticChecker.errors.Add($"Eroare: Nu exista variabila {nameVariable} in scope-ul curent, la linia {context.Start.Line}.");
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
                semanticChecker.errors.Add($"Eroare: Primary necunoscut la linia {context.Start.Line}.");
                return "error";
            }
        }
        public override string VisitFunctionCall([NotNull] MiniLanguageParser.FunctionCallContext context)
        {
            var nameFunction = context.ID().GetText();
            var functionCallInfo = new FunctionCallInfo { name = nameFunction, callerFunction = semanticChecker.currentFunction, line = context.Start.Line };

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

            semanticChecker.errors.Add($"Eroare: Literal necunoscut: {context.GetText()} la linia {context.Start.Line}.");
            return "error";
        }
    }
}