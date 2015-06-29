grammar ly;

@header{package grammar;}

body: (decl SEMI | expr SEMI)+;

decl: type ID (COMMA ID)*;
function: ID LPAR (decl (COLON decl)*)? RPAR '~~' type expr;

/** Expression. */
expr: ID ASS expr							#assigment
	| prfOp expr        					#prfExpr
    | expr plusOp expr  					#plusExpr
    | expr multOp expr  					#multExpr
    | expr compOp expr  					#compExpr
    | expr boolOp expr  					#boolExpr
    | READ LPAR ID (COMMA ID)* RPAR 		#readExpr
    | PRINT LPAR expr (COMMA expr) RPAR 	#printExpr
    | IF LPAR expr RPAR expr (ELSE expr)?	#if
    | WHILE LPAR expr RPAR expr				#while
    | LBRACE body expr SEMI RBRACE 			#compound
    | LPAR expr RPAR    					#parExpr
    | ID                					#idExpr
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
type: INT  	#intType
    | BOOL  #boolType
    | CHAR 	#charType
    ;
    
TRUE: 'true';
FALSE: 'false';

READ: 'read';
PRINT: 'print';

IF: 'if';
ELSE: 'else';
WHILE: 'while';
    
INT:	'int';
BOOL:	'bool';
CHAR:	'char';


ASS:    '<-';
AND:	'&&';
COLON:  ':';
COMMA:  ',';
DOT:    '.';
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
RPAR:   ')';
SEMI:   ';';
SLASH:  '/';
STAR:   '*';
OR:		'||';
HT:	'#';

// Content-bearing token types
ID: LETTER (LETTER | DIGIT)*;
NUM: DIGIT (DIGIT)*;
STR: DQUOTE .*? DQUOTE;

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];

// Skipped token types
COMMENT: HT .*? '\n'  -> skip;
MULTICOMMENT: HT HT .*? HT HT -> skip;
WS: [ \t\r\n]+ -> skip;
