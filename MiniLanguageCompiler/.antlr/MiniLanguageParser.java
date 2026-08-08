// Generated from d:/SmartGit/mini-language-compiler/MiniLanguageCompiler/MiniLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, FLOAT=2, DOUBLE=3, STRING=4, CONST=5, VOID=6, BOOL=7, IF=8, ELSE=9, 
		FOR=10, WHILE=11, RETURN=12, ID=13, STRING_LITERAL=14, POSITIVE_LITERAL=15, 
		FLOAT_LITERAL=16, PLUS=17, MINUS=18, MULTIPLY=19, DIVIDE=20, MODULO=21, 
		LESS_THAN=22, GREATER_THAN=23, LESS_THAN_EQUAL=24, GREATER_THAN_EQUAL=25, 
		EQUAL=26, NOT_EQUAL=27, AND=28, OR=29, NOT=30, ASSIGN=31, PLUS_ASSIGN=32, 
		MINUS_ASSIGN=33, MULTIPLY_ASSIGN=34, DIVIDE_ASSIGN=35, MODULO_ASSIGN=36, 
		INCREMENT=37, DECREMENT=38, LEFT_PARANTHESIS=39, RIGHT_PARANTHESIS=40, 
		LEFT_BRACKET=41, RIGHT_BRACKET=42, COMMA=43, SEMICOLON=44, WHITESPACE=45, 
		LINE_COMMENT=46, BLOCK_COMMENT=47;
	public static final int
		RULE_program = 0, RULE_type = 1, RULE_expression = 2, RULE_assignment = 3, 
		RULE_logicalOr = 4, RULE_logicalAnd = 5, RULE_equality = 6, RULE_relational = 7, 
		RULE_additive = 8, RULE_multiplicative = 9, RULE_unary = 10, RULE_postfix = 11, 
		RULE_primary = 12, RULE_functionCall = 13, RULE_argumentList = 14, RULE_literal = 15, 
		RULE_blockStatement = 16, RULE_ifStatement = 17, RULE_forInitialization = 18, 
		RULE_forStatement = 19, RULE_whileStatement = 20, RULE_returnStatement = 21, 
		RULE_statement = 22, RULE_variableDeclaration = 23, RULE_parameter = 24, 
		RULE_parametersList = 25, RULE_functionDeclaration = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "type", "expression", "assignment", "logicalOr", "logicalAnd", 
			"equality", "relational", "additive", "multiplicative", "unary", "postfix", 
			"primary", "functionCall", "argumentList", "literal", "blockStatement", 
			"ifStatement", "forInitialization", "forStatement", "whileStatement", 
			"returnStatement", "statement", "variableDeclaration", "parameter", "parametersList", 
			"functionDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'double'", "'string'", "'const'", "'void'", 
			"'bool'", "'if'", "'else'", "'for'", "'while'", "'return'", null, null, 
			null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'<='", 
			"'>='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'='", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'++'", "'--'", "'('", "')'", "'{'", "'}'", "','", 
			"';'", null, null, "'/*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT", "FLOAT", "DOUBLE", "STRING", "CONST", "VOID", "BOOL", "IF", 
			"ELSE", "FOR", "WHILE", "RETURN", "ID", "STRING_LITERAL", "POSITIVE_LITERAL", 
			"FLOAT_LITERAL", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "MODULO", "LESS_THAN", 
			"GREATER_THAN", "LESS_THAN_EQUAL", "GREATER_THAN_EQUAL", "EQUAL", "NOT_EQUAL", 
			"AND", "OR", "NOT", "ASSIGN", "PLUS_ASSIGN", "MINUS_ASSIGN", "MULTIPLY_ASSIGN", 
			"DIVIDE_ASSIGN", "MODULO_ASSIGN", "INCREMENT", "DECREMENT", "LEFT_PARANTHESIS", 
			"RIGHT_PARANTHESIS", "LEFT_BRACKET", "RIGHT_BRACKET", "COMMA", "SEMICOLON", 
			"WHITESPACE", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniLanguageParser.EOF, 0); }
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 254L) != 0)) {
				{
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(54);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(55);
					variableDeclaration();
					}
					break;
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniLanguageParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(MiniLanguageParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(MiniLanguageParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(MiniLanguageParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MiniLanguageParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(MiniLanguageParser.VOID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 222L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(MiniLanguageParser.PLUS_ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PlusAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterPlusAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitPlusAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivideAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode DIVIDE_ASSIGN() { return getToken(MiniLanguageParser.DIVIDE_ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DivideAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterDivideAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitDivideAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExpressionContext extends AssignmentContext {
		public LogicalOrContext logicalOr() {
			return getRuleContext(LogicalOrContext.class,0);
		}
		public AssignExpressionContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterAssignExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitAssignExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplyAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode MULTIPLY_ASSIGN() { return getToken(MiniLanguageParser.MULTIPLY_ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MultiplyAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterMultiplyAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitMultiplyAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(MiniLanguageParser.MINUS_ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MinusAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterMinusAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitMinusAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModuloAssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode MODULO_ASSIGN() { return getToken(MiniLanguageParser.MODULO_ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ModuloAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterModuloAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitModuloAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniLanguageParser.ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitAssign(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(ID);
				setState(68);
				match(ASSIGN);
				setState(69);
				assignment();
				}
				break;
			case 2:
				_localctx = new PlusAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(ID);
				setState(71);
				match(PLUS_ASSIGN);
				setState(72);
				assignment();
				}
				break;
			case 3:
				_localctx = new MinusAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(ID);
				setState(74);
				match(MINUS_ASSIGN);
				setState(75);
				assignment();
				}
				break;
			case 4:
				_localctx = new MultiplyAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(ID);
				setState(77);
				match(MULTIPLY_ASSIGN);
				setState(78);
				assignment();
				}
				break;
			case 5:
				_localctx = new DivideAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				match(ID);
				setState(80);
				match(DIVIDE_ASSIGN);
				setState(81);
				assignment();
				}
				break;
			case 6:
				_localctx = new ModuloAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				match(ID);
				setState(83);
				match(MODULO_ASSIGN);
				setState(84);
				assignment();
				}
				break;
			case 7:
				_localctx = new AssignExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(85);
				logicalOr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends ParserRuleContext {
		public List<LogicalAndContext> logicalAnd() {
			return getRuleContexts(LogicalAndContext.class);
		}
		public LogicalAndContext logicalAnd(int i) {
			return getRuleContext(LogicalAndContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(MiniLanguageParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MiniLanguageParser.OR, i);
		}
		public LogicalOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterLogicalOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitLogicalOr(this);
		}
	}

	public final LogicalOrContext logicalOr() throws RecognitionException {
		LogicalOrContext _localctx = new LogicalOrContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_logicalOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			logicalAnd();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(89);
				match(OR);
				setState(90);
				logicalAnd();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndContext extends ParserRuleContext {
		public List<EqualityContext> equality() {
			return getRuleContexts(EqualityContext.class);
		}
		public EqualityContext equality(int i) {
			return getRuleContext(EqualityContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MiniLanguageParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MiniLanguageParser.AND, i);
		}
		public LogicalAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterLogicalAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitLogicalAnd(this);
		}
	}

	public final LogicalAndContext logicalAnd() throws RecognitionException {
		LogicalAndContext _localctx = new LogicalAndContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_logicalAnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			equality();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(97);
				match(AND);
				setState(98);
				equality();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ParserRuleContext {
		public List<RelationalContext> relational() {
			return getRuleContexts(RelationalContext.class);
		}
		public RelationalContext relational(int i) {
			return getRuleContext(RelationalContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(MiniLanguageParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(MiniLanguageParser.EQUAL, i);
		}
		public List<TerminalNode> NOT_EQUAL() { return getTokens(MiniLanguageParser.NOT_EQUAL); }
		public TerminalNode NOT_EQUAL(int i) {
			return getToken(MiniLanguageParser.NOT_EQUAL, i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitEquality(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_equality);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			relational();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EQUAL || _la==NOT_EQUAL) {
				{
				{
				setState(105);
				_la = _input.LA(1);
				if ( !(_la==EQUAL || _la==NOT_EQUAL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(106);
				relational();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ParserRuleContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(MiniLanguageParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(MiniLanguageParser.LESS_THAN, i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(MiniLanguageParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(MiniLanguageParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN_EQUAL() { return getTokens(MiniLanguageParser.LESS_THAN_EQUAL); }
		public TerminalNode LESS_THAN_EQUAL(int i) {
			return getToken(MiniLanguageParser.LESS_THAN_EQUAL, i);
		}
		public List<TerminalNode> GREATER_THAN_EQUAL() { return getTokens(MiniLanguageParser.GREATER_THAN_EQUAL); }
		public TerminalNode GREATER_THAN_EQUAL(int i) {
			return getToken(MiniLanguageParser.GREATER_THAN_EQUAL, i);
		}
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitRelational(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_relational);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			additive();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) {
				{
				{
				setState(113);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(114);
				additive();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveContext extends ParserRuleContext {
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(MiniLanguageParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(MiniLanguageParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(MiniLanguageParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(MiniLanguageParser.MINUS, i);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitAdditive(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_additive);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			multiplicative();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(121);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(122);
				multiplicative();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeContext extends ParserRuleContext {
		public List<UnaryContext> unary() {
			return getRuleContexts(UnaryContext.class);
		}
		public UnaryContext unary(int i) {
			return getRuleContext(UnaryContext.class,i);
		}
		public List<TerminalNode> MULTIPLY() { return getTokens(MiniLanguageParser.MULTIPLY); }
		public TerminalNode MULTIPLY(int i) {
			return getToken(MiniLanguageParser.MULTIPLY, i);
		}
		public List<TerminalNode> DIVIDE() { return getTokens(MiniLanguageParser.DIVIDE); }
		public TerminalNode DIVIDE(int i) {
			return getToken(MiniLanguageParser.DIVIDE, i);
		}
		public List<TerminalNode> MODULO() { return getTokens(MiniLanguageParser.MODULO); }
		public TerminalNode MODULO(int i) {
			return getToken(MiniLanguageParser.MODULO, i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitMultiplicative(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multiplicative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			unary();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) {
				{
				{
				setState(129);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(130);
				unary();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(MiniLanguageParser.NOT, 0); }
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitUnary(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unary);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(NOT);
				setState(137);
				unary();
				}
				break;
			case ID:
			case STRING_LITERAL:
			case POSITIVE_LITERAL:
			case FLOAT_LITERAL:
			case LEFT_PARANTHESIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				postfix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(MiniLanguageParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(MiniLanguageParser.DECREMENT, 0); }
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitPostfix(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_postfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			primary();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INCREMENT || _la==DECREMENT) {
				{
				setState(142);
				_la = _input.LA(1);
				if ( !(_la==INCREMENT || _la==DECREMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode LEFT_PARANTHESIS() { return getToken(MiniLanguageParser.LEFT_PARANTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARANTHESIS() { return getToken(MiniLanguageParser.RIGHT_PARANTHESIS, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_primary);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(148);
				match(LEFT_PARANTHESIS);
				setState(149);
				expression();
				setState(150);
				match(RIGHT_PARANTHESIS);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode LEFT_PARANTHESIS() { return getToken(MiniLanguageParser.LEFT_PARANTHESIS, 0); }
		public TerminalNode RIGHT_PARANTHESIS() { return getToken(MiniLanguageParser.RIGHT_PARANTHESIS, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ID);
			setState(155);
			match(LEFT_PARANTHESIS);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 550829678592L) != 0)) {
				{
				setState(156);
				argumentList();
				}
			}

			setState(159);
			match(RIGHT_PARANTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniLanguageParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			expression();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(162);
				match(COMMA);
				setState(163);
				expression();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode POSITIVE_LITERAL() { return getToken(MiniLanguageParser.POSITIVE_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(MiniLanguageParser.FLOAT_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MiniLanguageParser.STRING_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(MiniLanguageParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniLanguageParser.RIGHT_BRACKET, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_blockStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(LEFT_BRACKET);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2749852941822L) != 0)) {
				{
				{
				setState(172);
				statement();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniLanguageParser.IF, 0); }
		public TerminalNode LEFT_PARANTHESIS() { return getToken(MiniLanguageParser.LEFT_PARANTHESIS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PARANTHESIS() { return getToken(MiniLanguageParser.RIGHT_PARANTHESIS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniLanguageParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(IF);
			setState(181);
			match(LEFT_PARANTHESIS);
			setState(182);
			expression();
			setState(183);
			match(RIGHT_PARANTHESIS);
			setState(184);
			statement();
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(185);
				match(ELSE);
				setState(186);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitializationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniLanguageParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInitialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterForInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitForInitialization(this);
		}
	}

	public final ForInitializationContext forInitialization() throws RecognitionException {
		ForInitializationContext _localctx = new ForInitializationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forInitialization);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case VOID:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				type();
				setState(190);
				match(ID);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(191);
					match(ASSIGN);
					setState(192);
					expression();
					}
				}

				}
				break;
			case ID:
			case STRING_LITERAL:
			case POSITIVE_LITERAL:
			case FLOAT_LITERAL:
			case NOT:
			case LEFT_PARANTHESIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniLanguageParser.FOR, 0); }
		public TerminalNode LEFT_PARANTHESIS() { return getToken(MiniLanguageParser.LEFT_PARANTHESIS, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniLanguageParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniLanguageParser.SEMICOLON, i);
		}
		public TerminalNode RIGHT_PARANTHESIS() { return getToken(MiniLanguageParser.RIGHT_PARANTHESIS, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitializationContext forInitialization() {
			return getRuleContext(ForInitializationContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(FOR);
			setState(199);
			match(LEFT_PARANTHESIS);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 550829678814L) != 0)) {
				{
				setState(200);
				forInitialization();
				}
			}

			setState(203);
			match(SEMICOLON);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 550829678592L) != 0)) {
				{
				setState(204);
				expression();
				}
			}

			setState(207);
			match(SEMICOLON);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 550829678592L) != 0)) {
				{
				setState(208);
				expression();
				}
			}

			setState(211);
			match(RIGHT_PARANTHESIS);
			setState(212);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniLanguageParser.WHILE, 0); }
		public TerminalNode LEFT_PARANTHESIS() { return getToken(MiniLanguageParser.LEFT_PARANTHESIS, 0); }
		public TerminalNode RIGHT_PARANTHESIS() { return getToken(MiniLanguageParser.RIGHT_PARANTHESIS, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(WHILE);
			setState(215);
			match(LEFT_PARANTHESIS);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 550829678592L) != 0)) {
				{
				setState(216);
				expression();
				}
			}

			setState(219);
			match(RIGHT_PARANTHESIS);
			setState(220);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniLanguageParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniLanguageParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(RETURN);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 550829678592L) != 0)) {
				{
				setState(223);
				expression();
				}
			}

			setState(226);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniLanguageParser.SEMICOLON, 0); }
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case CONST:
			case VOID:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				variableDeclaration();
				}
				break;
			case ID:
			case STRING_LITERAL:
			case POSITIVE_LITERAL:
			case FLOAT_LITERAL:
			case NOT:
			case LEFT_PARANTHESIS:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				expression();
				setState(230);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				ifStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				forStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				whileStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(235);
				returnStatement();
				}
				break;
			case LEFT_BRACKET:
				enterOuterAlt(_localctx, 7);
				{
				setState(236);
				blockStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniLanguageParser.SEMICOLON, 0); }
		public TerminalNode CONST() { return getToken(MiniLanguageParser.CONST, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniLanguageParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(239);
				match(CONST);
				}
			}

			setState(242);
			type();
			setState(243);
			match(ID);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(244);
				match(ASSIGN);
				setState(245);
				expression();
				}
			}

			setState(248);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			type();
			setState(251);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniLanguageParser.COMMA, i);
		}
		public ParametersListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterParametersList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitParametersList(this);
		}
	}

	public final ParametersListContext parametersList() throws RecognitionException {
		ParametersListContext _localctx = new ParametersListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parametersList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			parameter();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(254);
				match(COMMA);
				setState(255);
				parameter();
				}
				}
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniLanguageParser.ID, 0); }
		public TerminalNode LEFT_PARANTHESIS() { return getToken(MiniLanguageParser.LEFT_PARANTHESIS, 0); }
		public TerminalNode RIGHT_PARANTHESIS() { return getToken(MiniLanguageParser.RIGHT_PARANTHESIS, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniLanguageParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniLanguageParser.RIGHT_BRACKET, 0); }
		public ParametersListContext parametersList() {
			return getRuleContext(ParametersListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLanguageListener ) ((MiniLanguageListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			type();
			setState(262);
			match(ID);
			setState(263);
			match(LEFT_PARANTHESIS);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 222L) != 0)) {
				{
				setState(264);
				parametersList();
				}
			}

			setState(267);
			match(RIGHT_PARANTHESIS);
			setState(268);
			match(LEFT_BRACKET);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2749852941822L) != 0)) {
				{
				{
				setState(269);
				statement();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(275);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0116\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0001\u0000\u0001\u0000"+
		"\u0005\u00009\b\u0000\n\u0000\f\u0000<\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"W\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\\\b\u0004\n"+
		"\u0004\f\u0004_\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"d\b\u0005\n\u0005\f\u0005g\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006l\b\u0006\n\u0006\f\u0006o\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007t\b\u0007\n\u0007\f\u0007w\t\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\b|\b\b\n\b\f\b\u007f\t\b\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u0084\b\t\n\t\f\t\u0087\t\t\u0001\n\u0001\n\u0001\n\u0003\n\u008c\b"+
		"\n\u0001\u000b\u0001\u000b\u0003\u000b\u0090\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0099\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u009e\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00a5\b\u000e\n\u000e\f\u000e\u00a8\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00ae\b\u0010\n\u0010\f\u0010"+
		"\u00b1\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00bc\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00c2\b\u0012"+
		"\u0001\u0012\u0003\u0012\u00c5\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00ca\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ce\b"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00d2\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00da"+
		"\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u00e1\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u00ee\b\u0016\u0001\u0017\u0003\u0017\u00f1\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00f7\b\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u0101\b\u0019\n\u0019\f\u0019\u0104"+
		"\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u010a"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u010f\b\u001a"+
		"\n\u001a\f\u001a\u0112\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0000"+
		"\u0000\u001b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.024\u0000\u0007\u0002\u0000\u0001\u0004"+
		"\u0006\u0007\u0001\u0000\u001a\u001b\u0001\u0000\u0016\u0019\u0001\u0000"+
		"\u0011\u0012\u0001\u0000\u0013\u0015\u0001\u0000%&\u0001\u0000\u000e\u0010"+
		"\u0123\u0000:\u0001\u0000\u0000\u0000\u0002?\u0001\u0000\u0000\u0000\u0004"+
		"A\u0001\u0000\u0000\u0000\u0006V\u0001\u0000\u0000\u0000\bX\u0001\u0000"+
		"\u0000\u0000\n`\u0001\u0000\u0000\u0000\fh\u0001\u0000\u0000\u0000\u000e"+
		"p\u0001\u0000\u0000\u0000\u0010x\u0001\u0000\u0000\u0000\u0012\u0080\u0001"+
		"\u0000\u0000\u0000\u0014\u008b\u0001\u0000\u0000\u0000\u0016\u008d\u0001"+
		"\u0000\u0000\u0000\u0018\u0098\u0001\u0000\u0000\u0000\u001a\u009a\u0001"+
		"\u0000\u0000\u0000\u001c\u00a1\u0001\u0000\u0000\u0000\u001e\u00a9\u0001"+
		"\u0000\u0000\u0000 \u00ab\u0001\u0000\u0000\u0000\"\u00b4\u0001\u0000"+
		"\u0000\u0000$\u00c4\u0001\u0000\u0000\u0000&\u00c6\u0001\u0000\u0000\u0000"+
		"(\u00d6\u0001\u0000\u0000\u0000*\u00de\u0001\u0000\u0000\u0000,\u00ed"+
		"\u0001\u0000\u0000\u0000.\u00f0\u0001\u0000\u0000\u00000\u00fa\u0001\u0000"+
		"\u0000\u00002\u00fd\u0001\u0000\u0000\u00004\u0105\u0001\u0000\u0000\u0000"+
		"69\u00034\u001a\u000079\u0003.\u0017\u000086\u0001\u0000\u0000\u00008"+
		"7\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000"+
		"\u0000\u0000=>\u0005\u0000\u0000\u0001>\u0001\u0001\u0000\u0000\u0000"+
		"?@\u0007\u0000\u0000\u0000@\u0003\u0001\u0000\u0000\u0000AB\u0003\u0006"+
		"\u0003\u0000B\u0005\u0001\u0000\u0000\u0000CD\u0005\r\u0000\u0000DE\u0005"+
		"\u001f\u0000\u0000EW\u0003\u0006\u0003\u0000FG\u0005\r\u0000\u0000GH\u0005"+
		" \u0000\u0000HW\u0003\u0006\u0003\u0000IJ\u0005\r\u0000\u0000JK\u0005"+
		"!\u0000\u0000KW\u0003\u0006\u0003\u0000LM\u0005\r\u0000\u0000MN\u0005"+
		"\"\u0000\u0000NW\u0003\u0006\u0003\u0000OP\u0005\r\u0000\u0000PQ\u0005"+
		"#\u0000\u0000QW\u0003\u0006\u0003\u0000RS\u0005\r\u0000\u0000ST\u0005"+
		"$\u0000\u0000TW\u0003\u0006\u0003\u0000UW\u0003\b\u0004\u0000VC\u0001"+
		"\u0000\u0000\u0000VF\u0001\u0000\u0000\u0000VI\u0001\u0000\u0000\u0000"+
		"VL\u0001\u0000\u0000\u0000VO\u0001\u0000\u0000\u0000VR\u0001\u0000\u0000"+
		"\u0000VU\u0001\u0000\u0000\u0000W\u0007\u0001\u0000\u0000\u0000X]\u0003"+
		"\n\u0005\u0000YZ\u0005\u001d\u0000\u0000Z\\\u0003\n\u0005\u0000[Y\u0001"+
		"\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^\t\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000`e\u0003\f\u0006\u0000ab\u0005\u001c\u0000\u0000bd\u0003\f\u0006"+
		"\u0000ca\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000ef\u0001\u0000\u0000\u0000f\u000b\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hm\u0003\u000e\u0007\u0000ij\u0007\u0001\u0000"+
		"\u0000jl\u0003\u000e\u0007\u0000ki\u0001\u0000\u0000\u0000lo\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\r\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pu\u0003\u0010\b\u0000qr\u0007"+
		"\u0002\u0000\u0000rt\u0003\u0010\b\u0000sq\u0001\u0000\u0000\u0000tw\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"v\u000f\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000x}\u0003\u0012"+
		"\t\u0000yz\u0007\u0003\u0000\u0000z|\u0003\u0012\t\u0000{y\u0001\u0000"+
		"\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u0011\u0001\u0000\u0000\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u0080\u0085\u0003\u0014\n\u0000\u0081\u0082\u0007\u0004"+
		"\u0000\u0000\u0082\u0084\u0003\u0014\n\u0000\u0083\u0081\u0001\u0000\u0000"+
		"\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0013\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u001e\u0000"+
		"\u0000\u0089\u008c\u0003\u0014\n\u0000\u008a\u008c\u0003\u0016\u000b\u0000"+
		"\u008b\u0088\u0001\u0000\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000"+
		"\u008c\u0015\u0001\u0000\u0000\u0000\u008d\u008f\u0003\u0018\f\u0000\u008e"+
		"\u0090\u0007\u0005\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0017\u0001\u0000\u0000\u0000\u0091"+
		"\u0099\u0005\r\u0000\u0000\u0092\u0099\u0003\u001e\u000f\u0000\u0093\u0099"+
		"\u0003\u001a\r\u0000\u0094\u0095\u0005\'\u0000\u0000\u0095\u0096\u0003"+
		"\u0004\u0002\u0000\u0096\u0097\u0005(\u0000\u0000\u0097\u0099\u0001\u0000"+
		"\u0000\u0000\u0098\u0091\u0001\u0000\u0000\u0000\u0098\u0092\u0001\u0000"+
		"\u0000\u0000\u0098\u0093\u0001\u0000\u0000\u0000\u0098\u0094\u0001\u0000"+
		"\u0000\u0000\u0099\u0019\u0001\u0000\u0000\u0000\u009a\u009b\u0005\r\u0000"+
		"\u0000\u009b\u009d\u0005\'\u0000\u0000\u009c\u009e\u0003\u001c\u000e\u0000"+
		"\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0005(\u0000\u0000\u00a0"+
		"\u001b\u0001\u0000\u0000\u0000\u00a1\u00a6\u0003\u0004\u0002\u0000\u00a2"+
		"\u00a3\u0005+\u0000\u0000\u00a3\u00a5\u0003\u0004\u0002\u0000\u00a4\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u001d"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0007\u0006\u0000\u0000\u00aa\u001f\u0001\u0000\u0000\u0000\u00ab\u00af"+
		"\u0005)\u0000\u0000\u00ac\u00ae\u0003,\u0016\u0000\u00ad\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005*\u0000"+
		"\u0000\u00b3!\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\b\u0000\u0000"+
		"\u00b5\u00b6\u0005\'\u0000\u0000\u00b6\u00b7\u0003\u0004\u0002\u0000\u00b7"+
		"\u00b8\u0005(\u0000\u0000\u00b8\u00bb\u0003,\u0016\u0000\u00b9\u00ba\u0005"+
		"\t\u0000\u0000\u00ba\u00bc\u0003,\u0016\u0000\u00bb\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc#\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0003\u0002\u0001\u0000\u00be\u00c1\u0005\r\u0000\u0000"+
		"\u00bf\u00c0\u0005\u001f\u0000\u0000\u00c0\u00c2\u0003\u0004\u0002\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003\u0006\u0003\u0000"+
		"\u00c4\u00bd\u0001\u0000\u0000\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c5%\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\n\u0000\u0000\u00c7"+
		"\u00c9\u0005\'\u0000\u0000\u00c8\u00ca\u0003$\u0012\u0000\u00c9\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005,\u0000\u0000\u00cc\u00ce\u0003"+
		"\u0004\u0002\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0005"+
		",\u0000\u0000\u00d0\u00d2\u0003\u0004\u0002\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d4\u0005(\u0000\u0000\u00d4\u00d5\u0003,\u0016\u0000"+
		"\u00d5\'\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005\u000b\u0000\u0000\u00d7"+
		"\u00d9\u0005\'\u0000\u0000\u00d8\u00da\u0003\u0004\u0002\u0000\u00d9\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0005(\u0000\u0000\u00dc\u00dd\u0003"+
		",\u0016\u0000\u00dd)\u0001\u0000\u0000\u0000\u00de\u00e0\u0005\f\u0000"+
		"\u0000\u00df\u00e1\u0003\u0004\u0002\u0000\u00e0\u00df\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e3\u0005,\u0000\u0000\u00e3+\u0001\u0000\u0000\u0000\u00e4"+
		"\u00ee\u0003.\u0017\u0000\u00e5\u00e6\u0003\u0004\u0002\u0000\u00e6\u00e7"+
		"\u0005,\u0000\u0000\u00e7\u00ee\u0001\u0000\u0000\u0000\u00e8\u00ee\u0003"+
		"\"\u0011\u0000\u00e9\u00ee\u0003&\u0013\u0000\u00ea\u00ee\u0003(\u0014"+
		"\u0000\u00eb\u00ee\u0003*\u0015\u0000\u00ec\u00ee\u0003 \u0010\u0000\u00ed"+
		"\u00e4\u0001\u0000\u0000\u0000\u00ed\u00e5\u0001\u0000\u0000\u0000\u00ed"+
		"\u00e8\u0001\u0000\u0000\u0000\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ee-\u0001\u0000\u0000\u0000\u00ef\u00f1"+
		"\u0005\u0005\u0000\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f0\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0003\u0002\u0001\u0000\u00f3\u00f6\u0005\r\u0000\u0000\u00f4\u00f5\u0005"+
		"\u001f\u0000\u0000\u00f5\u00f7\u0003\u0004\u0002\u0000\u00f6\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0005,\u0000\u0000\u00f9/\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0003\u0002\u0001\u0000\u00fb\u00fc\u0005\r\u0000\u0000"+
		"\u00fc1\u0001\u0000\u0000\u0000\u00fd\u0102\u00030\u0018\u0000\u00fe\u00ff"+
		"\u0005+\u0000\u0000\u00ff\u0101\u00030\u0018\u0000\u0100\u00fe\u0001\u0000"+
		"\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u01033\u0001\u0000\u0000"+
		"\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106\u0003\u0002\u0001"+
		"\u0000\u0106\u0107\u0005\r\u0000\u0000\u0107\u0109\u0005\'\u0000\u0000"+
		"\u0108\u010a\u00032\u0019\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0005(\u0000\u0000\u010c\u0110\u0005)\u0000\u0000\u010d\u010f\u0003"+
		",\u0016\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f\u0112\u0001\u0000"+
		"\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000"+
		"\u0000\u0000\u0111\u0113\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000"+
		"\u0000\u0000\u0113\u0114\u0005*\u0000\u0000\u01145\u0001\u0000\u0000\u0000"+
		"\u001d8:V]emu}\u0085\u008b\u008f\u0098\u009d\u00a6\u00af\u00bb\u00c1\u00c4"+
		"\u00c9\u00cd\u00d1\u00d9\u00e0\u00ed\u00f0\u00f6\u0102\u0109\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}