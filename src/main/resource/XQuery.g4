/* ANTLR 4 Grammer file for Xquery
 */

grammar XQuery;

/* Absoluate Path */
ap
    :   'doc' '(' file_name ')' '/' rp
    |   'doc' '(' file_name ')' '//' rp
    ;

/* Relative Path */
rp
    :   tag_name
    |   '*'
    |   '.'
    |   '..'
    |   'text()'
    |   '@' att_name
    |   '(' rp ')'
    |   rp '/' rp
    |   rp '//' rp
    |   rp '[' f ']'
    |   rp ',' rp
    ;

/* Path Filter */
f
    :   rp
    |   rp '=' rp
    |   rp 'eq' rp
    |   rp '==' rp
    |   rp 'is' rp
    |   '(' f ')'
    |   f 'and' f
    |   f 'or' f
    |   'not' f
    ;


/* File Name (Not perfect, just a course one) */
file_name
    :   STRING ('.' STRING)*
    ;

/* Tag Name (Not perfect, just a course one) */
tag_name
    :   STRING
    ;

/* Attribute Name (Not perfect, just a course one) */
att_name
    :   STRING
    ;

/* String without dot and not empty */
STRING
    :   [a-zA-Z0-9_]+
    ;

/* White Space */
WS
    :   (' '|'\t'|'\n'|'\r')+  ->  skip
    ;
