grammar Language;

// ==================== PARSER RULES ====================

program
    : (packageDecl | importDecl | classDecl | interfaceDecl | varDecl | methodDecl)* EOF
    ;

// Package
packageDecl
    : PACKAGE qualifiedName SEMI
    ;

// Import
importDecl
    : IMPORT qualifiedName (DOT '*')? SEMI
    ;

// Qualified Name
qualifiedName
    : IDENTIFIER (DOT IDENTIFIER)*
    ;

// ==================== CLASSES & INTERFACES ====================

classDecl
    : annotation* (PUBLIC | PRIVATE | PROTECTED)? ABSTRACT? CLASS IDENTIFIER (typeParameters)? (EXTENDS type)? (IMPLEMENTS typeList)? LBRACE classBody* RBRACE
    ;

interfaceDecl
    : annotation* INTERFACE IDENTIFIER (typeParameters)? (EXTENDS typeList)? LBRACE interfaceBody* RBRACE
    ;

classBody
    : varDecl
    | methodDecl
    | constructorDecl
    ;

interfaceBody
    : methodDecl
    | varDecl
    ;

// Type list
typeList
    : type (COMMA type)*
    ;

// Type parameters (Generics)
typeParameters
    : '<' type (COMMA type)* '>'
    ;

// ==================== METHODS & CONSTRUCTORS ====================

methodDecl
    : annotation* (PUBLIC | PRIVATE | PROTECTED)? STATIC? (ABSTRACT | VOID | type) IDENTIFIER LPAREN paramList? RPAREN (block | SEMI)
    ;

constructorDecl
    : annotation* (PUBLIC | PRIVATE | PROTECTED)? IDENTIFIER LPAREN paramList? RPAREN block
    ;

paramList
    : param (COMMA param)*
    ;

param
    : type IDENTIFIER
    ;

// ==================== VARIABLE DECLARATIONS ====================

varDecl
    : annotation* (PUBLIC | PRIVATE | PROTECTED)? STATIC? type IDENTIFIER (ASSIGN expr)? SEMI
    ;

// ==================== STATEMENTS ====================

block
    : LBRACE statement* RBRACE
    ;

statement
    : block
    | varDecl
    | exprStatement
    | ifStatement
    | whileStatement
    | forStatement
    | returnStatement
    | breakStatement
    | continueStatement
    ;

exprStatement
    : expr SEMI
    ;

ifStatement
    : IF LPAREN expr RPAREN statement (ELSE statement)?
    ;

whileStatement
    : WHILE LPAREN expr RPAREN statement
    ;

forStatement
    : FOR LPAREN (varDecl | exprStatement | SEMI)? expr? SEMI? expr? RPAREN statement
    ;

returnStatement
    : RETURN expr? SEMI
    ;

breakStatement
    : BREAK SEMI
    ;

continueStatement
    : CONTINUE SEMI
    ;

// ==================== EXPRESSIONS (Layered Precedence) ====================

expr : assignmentExpr ;

assignmentExpr
    : conditionalExpr
    | conditionalExpr ASSIGN assignmentExpr
    ;

conditionalExpr
    : logicalOrExpr
    | logicalOrExpr '?' expr ':' expr
    ;

logicalOrExpr
    : logicalAndExpr
    | logicalOrExpr OR logicalAndExpr
    ;

logicalAndExpr
    : equalityExpr
    | logicalAndExpr AND equalityExpr
    ;

equalityExpr
    : relationalExpr
    | equalityExpr (EQ | NEQ) relationalExpr
    ;

relationalExpr
    : additiveExpr
    | relationalExpr (LT | LE | GT | GE) additiveExpr
    ;

additiveExpr
    : multiplicativeExpr
    | additiveExpr (PLUS | MINUS) multiplicativeExpr
    ;

multiplicativeExpr
    : unaryExpr
    | multiplicativeExpr (MULT | DIV | MOD) unaryExpr
    ;

unaryExpr
    : NOT unaryExpr
    | primaryExpr
    ;

primaryExpr
    : THIS
    | literal
    | IDENTIFIER
    | IDENTIFIER LPAREN argList? RPAREN
    | NEW type (LPAREN argList? RPAREN | LBRACK expr RBRACK)
    | LPAREN expr RPAREN
    | primaryExpr DOT IDENTIFIER
    | primaryExpr DOT IDENTIFIER LPAREN argList? RPAREN
    ;

argList
    : expr (COMMA expr)*
    ;

// ==================== TYPES & LITERALS ====================

type
    : primitiveType
    | IDENTIFIER
    | type LBRACK RBRACK
    ;

primitiveType
    : 'int'
    | 'boolean'
    | 'char'
    | 'String'
    | 'void'
    ;

literal
    : INTLIT
    | STRINGLIT
    | CHARLIT
    | BOOLEANLIT
    | NULLLIT
    ;

// ==================== ANNOTATIONS ====================

annotation
    : '@' IDENTIFIER (LPAREN (expr (COMMA expr)*)? RPAREN)?
    ;

// ==================== LEXER RULES ====================

// Keywords
ABSTRACT : 'abstract' ;
PUBLIC   : 'public' ;
PRIVATE  : 'private' ;
PROTECTED: 'protected' ;
CLASS    : 'class' ;
INTERFACE: 'interface' ;
EXTENDS  : 'extends' ;
IMPLEMENTS: 'implements' ;
STATIC   : 'static' ;
VOID     : 'void' ;
IF       : 'if' ;
ELSE     : 'else' ;
WHILE    : 'while' ;
FOR      : 'for' ;
BREAK    : 'break' ;
CONTINUE : 'continue' ;
RETURN   : 'return' ;
NEW      : 'new' ;
THIS     : 'this' ;
IMPORT   : 'import' ;
PACKAGE  : 'package' ;

// Delimiters
SEMI     : ';' ;
COMMA    : ',' ;
LBRACE   : '{' ;
RBRACE   : '}' ;
LBRACK   : '[' ;
RBRACK   : ']' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
DOT      : '.' ;
QUESTION : '?' ;
COLON    : ':' ;

// Literals
BOOLEANLIT : 'true' | 'false' ;
NULLLIT    : 'null' ;
INTLIT     : [0-9]+ ('_' [0-9]+)* ;
CHARLIT    : '\'' . '\'' ;
STRINGLIT  : '"' .*? '"' ;

// Operators
PLUS        : '+' ;
MINUS       : '-' ;
MULT        : '*' ;
DIV         : '/' ;
MOD         : '%' ;
EQ          : '==' ;
NEQ         : '!=' ;
LT          : '<' ;
GT          : '>' ;
LE          : '<=' ;
GE          : '>=' ;
AND         : '&&' ;
OR          : '||' ;
NOT         : '!' ;
ASSIGN      : '=' ;

// Identifier
IDENTIFIER : [a-zA-Z_] [a-zA-Z_0-9]* ;

// Whitespace and comments
WS : [ \t\r\n]+ -> skip ;
LINE_COMMENT  : '//' ~[\r\n]* -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
