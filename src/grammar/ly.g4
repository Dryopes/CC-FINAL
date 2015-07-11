grammar ly;

body: (bodypart SEMI)+;
funcBody: (bodypart SEMI)* RETURN expr SEMI;
procBody: (bodypart SEMI)+ ;

bodypart: decl | expr;
function: ID LPAR (param (COMMA param)*)? RPAR FNCTYPE type funcBody;
procedure : ID LPAR (param (COMMA param)*)? RPAR procBody;

decl: 	(CONST)? type declpart (COMMA declpart)*;
declpart: ID (ASS expr)?;
param:	CONST? type REF? ID (COMMA ID)*;

/** Expression. */
expr: prfOp expr        					#prfExpr
    | expr multOp expr  					#multExpr
    | expr plusOp expr  					#plusExpr
    | expr compOp expr  					#compExpr
    | expr boolOp expr  					#boolExpr
	| ID ASS expr							#assigment
	| LBLOCK (expr (COMMA expr)*)? RBLOCK	#arrayExpr
    | READ LPAR ID (COMMA ID)* RPAR 		#readExpr
    | PRINT LPAR expr (COMMA expr)* RPAR 	#printExpr
    | ID LPAR expr (COMMA expr) RPAR 		#funcExpr
    | IF LPAR expr RPAR expr (ELSE expr)?	#if
    | WHILE LPAR expr RPAR expr				#while
    | LBRACE body? expr SEMI RBRACE 		#compound
    | LPAR expr RPAR    					#parExpr
    | ID LBLOCK expr RBLOCK					#indexExpr
    | ID                					#idExpr
    | CHR									#charExpr
    | NUM               					#numExpr
    | TRUE              					#trueExpr
    | FALSE             					#falseExpr
    ;

/** Prefix operator. */
prfOp: MINUS | NOT;

/** Multiplicative operator. */
multOp: STAR | SLASH;

/** Additive operator. */
plusOp: PLUS | MINUS;

/** Boolean operator. */
boolOp: AND | OR;

/** Comparison operator. */
compOp: LE | LT | GE | GT | EQ | NE;

/** Data type. */
type: INT  					#intType
    | BOOL  				#boolType
    | CHAR 					#charType
    | type LBLOCK RBLOCK 	#arrayType
    ;
    
FNCTYPE: 'FunctionType';
    
    
TRUE: 'true';
FALSE: 'false';

READ: 'read';
PRINT: 'print';

IF: 'if';
ELSE: 'else';
WHILE: 'while';
RETURN: 'return';
    
CONST:	'const';
INT:	'int';
BOOL:	'bool';
CHAR:	'char';


ASS:    '<-';
AND:	'&&';
COLON:  ':';
COMMA:  ',';
DOT:    '.';
QUOTE:	'\'';
DQUOTE: '"';
EQ:     '=';
GE:     '>=';
GT:     '>';
LE:     '<=';
LBRACE: '{';
LPAR:   '(';
LBLOCK:	'[';
LT:     '<';
MINUS:  '-';
NE:     '!=';
NOT:	'!';
PLUS:   '+';
RBLOCK:	']';
RBRACE: '}';
REF:	'@';
RPAR:   ')';
SEMI:   ';';
SLASH:  '/';
STAR:   '*';
OR:		'||';
HT:		'#';

// Content-bearing token types
ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT (DIGIT)*;
STR: DQUOTE .*? DQUOTE;
CHR: QUOTE .? QUOTE;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

// Skipped token types
COMMENT: HT .*? '\n'  -> skip;
MULTICOMMENT: HT HT .*? HT HT -> skip;
WS: [ \t\r\n]+ -> skip;
