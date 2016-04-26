/* ANTLR 4 Grammer file for Xquery
 */

grammar XQuery;

/* XQuery */
xq
    :   var                                     # VarAsXq
    |   str_const                               # StringAsXq
    |   ap                                      # ApAsXq
    |   '(' xq ')'                              # ParenthesisXq
    |   xq ',' xq                               # XqCommaXq
    |   xq '/' rp                               # XqSlashRp
    |   xq '//' rp                              # XqSlashSlashRp
    |   '<'tag_name'>{'xq'}</'tag_name'>'       # TagNameXq
    |   ffor let? where? ret                    # FLWR
    |   let xq                                  # LetXq
    ;

/* Var */
var
    :   '$' STRING
    ;

/* "for" Clause */
ffor
    :   'for' var_in_xq+
    ;

/* "let Clause" */
let
    :   'let' (var ':=' xq)+
    ;

/* "where" Clause */
where
    :   'where' cond
    ;

/* Return Clause */
ret
    :   'return' xq
    ;

/* Condition */
cond
    :   xq ('='|'eq') xq                        # XqValueEqualCond
    |   xq ('=='|'is') xq                       # XqIdEqualCond
    |   'empty(' xq ')'                         # XqEmptyCOnd
    |   'some' var_in_xq+ 'satisfies' cond      # XqSomeCond
    |   '(' cond ')'                            # ParenthesisCond
    |   cond 'and' cond                         # AndCond
    |   cond 'or' cond                          # OrCond
    |   'not' cond                              # NotCond
    ;


/* Var in Xq */
var_in_xq
    :   var 'in' xq
    ;

/* Absoluate Path */
ap
    :   'doc' '(' file_name ')' '/' rp          # DocSlashRp
    |   'doc' '(' file_name ')' '//' rp         # DocSlashSlashRp
    ;

/* Relative Path */
rp
    :   tag_name                                # TagName
    |   '*'                                     # Star
    |   '.'                                     # Dot
    |   '..'                                    # DoubleDot
    |   'text()'                                # Text
    |   '@' att_name                            # AttName
    |   '(' rp ')'                              # ParenthesisRp
    |   rp '/' rp                               # RpSlashRp
    |   rp '//' rp                              # RpSlashSlashRp
    |   rp '[' f ']'                            # RpWithFilter
    |   rp ',' rp                               # RpCommaRp
    ;

/* Path Filter */
f
    :   rp                                      # RpFilter
    |   rp ('='|'eq') rp                        # ValueEqualFilter
    |   rp ('=='|'is') rp                       # IDEqualFilter
    |   '(' f ')'                               # ParenthesisFilter
    |   f 'and' f                               # AndFilter
    |   f 'or' f                                # OrFilter
    |   'not' f                                 # NotFilter
    ;

/* File Name (Not perfect, just a course one) */
file_name
    :   STRING ('.' STRING)* ('/' STRING ('.' STRING)*)*
    ;

/* Tag Name (Not perfect, just a course one) */
tag_name
    :   STRING
    ;

/* Attribute Name (Not perfect, just a course one) */
att_name
    :   STRING
    ;

/* String Const */
str_const
    :   '"' ~('"') '"'
    ;

/* String without dot and not empty */
STRING
    :   [a-zA-Z0-9_]+
    ;

/* White Space */
WS
    :   (' '|'\t'|'\n'|'\r')+  ->  skip
    ;
