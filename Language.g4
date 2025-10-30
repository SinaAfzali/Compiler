lexer grammar Language;

IDENTIFIER
    : [a-zA-Z_] [a-zA-Z_0-9]* 
    ;

PLUS        : '+' ;
MINUS       : '-' ;
MULT        : '*' ;
DIV         : '/' ;
MOD         : '%' ;
POWER       : '**' ;

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
DOT         : '.' ;

WS
    : [ \t\r\n]+ -> skip
    ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;
