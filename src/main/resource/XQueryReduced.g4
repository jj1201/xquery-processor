
grammar XQueryReduced;

xq
    :   'for' var 'in' path (',' var 'in' path )* 'where' cond 'return' ret
    ;

path
    :   DOC '(' QUOTED_STRING ')' (slash STRING)* (slash ('node()'|'text()'))?
    |   var (slash STRING)* (slash ('node()'|'text()'))?
    ;

ret
    :   var                                     # RetVar
    |   ret ',' ret                             # RetRet
    |   '<' tag '>' '{' ret '}' '<''/' tag '>'  # RetTag
    |   path                                    # RetPath
    ;

cond
    :   var ('eq'|'=') var2 (('and'|'AND') var ('eq'|'=') var2)*
    ;

var2
    :   constant|var
    ;

constant
    :   QUOTED_STRING
    |   STRING
    ;

var
    :   '$' STRING
    ;

tag
    :   STRING
    ;

DOC
    :   'doc' | 'document'
    ;

slash
    :   '/' | '//'
    ;

QUOTED_STRING
    :   '"' INNER_STRING '"'
    ;
fragment
INNER_STRING
    :   ( ~('"') )*
    ;

STRING
    :   [a-zA-Z0-9_]+
    ;

WS
    :   (' '|'\t'|'\n'|'\r')+   -> skip
    ;