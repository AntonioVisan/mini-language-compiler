// Generated from d:/SmartGit/mini-language-compiler/MiniLanguageCompiler/MiniLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLanguageParser}.
 */
public interface MiniLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniLanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniLanguageParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MiniLanguageParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MiniLanguageParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterPlusAssign(MiniLanguageParser.PlusAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitPlusAssign(MiniLanguageParser.PlusAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code minusAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterMinusAssign(MiniLanguageParser.MinusAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code minusAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitMinusAssign(MiniLanguageParser.MinusAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplyAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyAssign(MiniLanguageParser.MultiplyAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplyAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyAssign(MiniLanguageParser.MultiplyAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divideAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterDivideAssign(MiniLanguageParser.DivideAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divideAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitDivideAssign(MiniLanguageParser.DivideAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moduloAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterModuloAssign(MiniLanguageParser.ModuloAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moduloAssign}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitModuloAssign(MiniLanguageParser.ModuloAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(MiniLanguageParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MiniLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(MiniLanguageParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#logicalOr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(MiniLanguageParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#logicalOr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(MiniLanguageParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#logicalAnd}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(MiniLanguageParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#logicalAnd}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(MiniLanguageParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(MiniLanguageParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(MiniLanguageParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(MiniLanguageParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(MiniLanguageParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(MiniLanguageParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(MiniLanguageParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(MiniLanguageParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(MiniLanguageParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(MiniLanguageParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(MiniLanguageParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(MiniLanguageParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(MiniLanguageParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MiniLanguageParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MiniLanguageParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MiniLanguageParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MiniLanguageParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniLanguageParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniLanguageParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MiniLanguageParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MiniLanguageParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MiniLanguageParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MiniLanguageParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniLanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniLanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#forInitialization}.
	 * @param ctx the parse tree
	 */
	void enterForInitialization(MiniLanguageParser.ForInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#forInitialization}.
	 * @param ctx the parse tree
	 */
	void exitForInitialization(MiniLanguageParser.ForInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MiniLanguageParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MiniLanguageParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniLanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniLanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MiniLanguageParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MiniLanguageParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MiniLanguageParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MiniLanguageParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MiniLanguageParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MiniLanguageParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void enterParametersList(MiniLanguageParser.ParametersListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#parametersList}.
	 * @param ctx the parse tree
	 */
	void exitParametersList(MiniLanguageParser.ParametersListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLanguageParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MiniLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLanguageParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MiniLanguageParser.FunctionDeclarationContext ctx);
}