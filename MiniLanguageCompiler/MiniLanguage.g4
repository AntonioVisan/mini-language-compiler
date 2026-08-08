grammar MiniLanguage;

/* Parser rules */

program: (functionDeclaration | variableDeclaration)* EOF;

type: INT | FLOAT | DOUBLE | STRING | BOOL | VOID;

expression: assignment;

assignment:
	ID ASSIGN assignment			# assign
	| ID PLUS_ASSIGN assignment		# plusAssign
	| ID MINUS_ASSIGN assignment	# minusAssign
	| ID MULTIPLY_ASSIGN assignment	# multiplyAssign
	| ID DIVIDE_ASSIGN assignment	# divideAssign
	| ID MODULO_ASSIGN assignment	# moduloAssign
	| logicalOr						# assignExpression;

logicalOr: logicalAnd (OR logicalAnd)*;

logicalAnd: equality (AND equality)*;

equality: relational ((EQUAL | NOT_EQUAL) relational)*;

relational:
	additive (
		(
			LESS_THAN
			| GREATER_THAN
			| LESS_THAN_EQUAL
			| GREATER_THAN_EQUAL
		) additive
	)*;

additive: multiplicative ((PLUS | MINUS) multiplicative)*;

multiplicative: unary ((MULTIPLY | DIVIDE | MODULO) unary)*;

unary: NOT unary | postfix;

postfix: primary (INCREMENT | DECREMENT)?;

primary:
	ID
	| literal
	| functionCall
	| LEFT_PARANTHESIS expression RIGHT_PARANTHESIS;

functionCall:
	ID LEFT_PARANTHESIS argumentList? RIGHT_PARANTHESIS;

argumentList: expression (COMMA expression)*;

literal: POSITIVE_LITERAL | FLOAT_LITERAL | STRING_LITERAL;

blockStatement: LEFT_BRACKET (statement)* RIGHT_BRACKET;

ifStatement:
	IF LEFT_PARANTHESIS expression RIGHT_PARANTHESIS statement (
		ELSE statement
	)?;

forInitialization: type ID (ASSIGN expression)? | assignment;
forStatement:
	FOR LEFT_PARANTHESIS (forInitialization)? SEMICOLON expression? SEMICOLON expression?
		RIGHT_PARANTHESIS statement;

whileStatement:
	WHILE LEFT_PARANTHESIS expression? RIGHT_PARANTHESIS statement;

returnStatement: RETURN expression? SEMICOLON;

statement:
	variableDeclaration
	| expression SEMICOLON
	| ifStatement
	| forStatement
	| whileStatement
	| returnStatement
	| blockStatement;

variableDeclaration:
	CONST? type ID (ASSIGN expression)? SEMICOLON;

parameter: type ID;
parametersList: parameter (COMMA parameter)*;

functionDeclaration:
	type ID LEFT_PARANTHESIS parametersList? RIGHT_PARANTHESIS LEFT_BRACKET (
		statement
	)* RIGHT_BRACKET;

/* Lexer rules */
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];
fragment LETTER: LOWERCASE | UPPERCASE;
fragment DIGIT: [0-9];
fragment UNDERLINE: '_';

INT: 'int';
FLOAT: 'float';
DOUBLE: 'double';
STRING: 'string';
CONST: 'const';
VOID: 'void';
BOOL: 'bool';
IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
RETURN: 'return';

ID: (LETTER | UNDERLINE) (LETTER | DIGIT | UNDERLINE)*;
STRING_LITERAL: '"' (~["\r\n])* '"';

POSITIVE_LITERAL: [0-9]+;
FLOAT_LITERAL: POSITIVE_LITERAL '.' POSITIVE_LITERAL;

PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
MODULO: '%';

LESS_THAN: '<';
GREATER_THAN: '>';
LESS_THAN_EQUAL: '<=';
GREATER_THAN_EQUAL: '>=';
EQUAL: '==';
NOT_EQUAL: '!=';

AND: '&&';
OR: '||';
NOT: '!';

ASSIGN: '=';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MULTIPLY_ASSIGN: '*=';
DIVIDE_ASSIGN: '/=';
MODULO_ASSIGN: '%=';

INCREMENT: '++';
DECREMENT: '--';
LEFT_PARANTHESIS: '(';
RIGHT_PARANTHESIS: ')';
LEFT_BRACKET: '{';
RIGHT_BRACKET: '}';
COMMA: ',';
SEMICOLON: ';';

WHITESPACE: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*';