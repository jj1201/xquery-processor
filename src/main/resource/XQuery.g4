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
    |   '<'tag_name'>''{'xq'}''</'tag_name'>'   # TagNameXq
    |   'for' flwr                              # FlwrXq
    |   let xq                                  # LetXq
    ;

/* Var */
var
    :   '$' STRING
    ;

/* String Constant */
str_const
    :   QUOTED_STRING
    ;

/* "FLWR Clause (Recursive Definition) */
flwr
    :   var 'in' xq (lwr | (',' flwr))
    ;

/* LWR (Part of flwr helper) */
lwr
    :   let? where? ret
    ;

/* "let Clause" */
let
    :   'let' (var ':=' xq) (',' var ':=' xq)*
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
    |   'empty' '(' xq ')'                         # XqEmptyCond
    |   'some' some_cond                        # XqSomeCond
    |   '(' cond ')'                            # ParenthesisCond
    |   cond 'and' cond                         # AndCond
    |   cond 'or' cond                          # OrCond
    |   'not' cond                              # NotCond
    ;

/* "Some" condition (Recursive Definition) */
some_cond
    :   var 'in' xq (('satisfies' cond )
                     | some_cond)               # SomeCond
    ;

/* Absoluate Path */
ap
    :   ('doc' | 'document') '(' file_name ')' '/' rp        # DocSlashRp
    |   ('doc' | 'document') '(' file_name ')' '//' rp       # DocSlashSlashRp
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
    :   QUOTED_STRING
    ;

/* Tag Name (Not perfect, just a course one) */
tag_name
    :   STRING
    ;

/* Attribute Name (Not perfect, just a course one) */
att_name
    :   STRING
    ;

/* Quited String */
QUOTED_STRING
    :   '"' INNER_STRING '"'
    ;
fragment
INNER_STRING
    :   ( ~('"') )*
    ;

/* String without dot and not empty */
STRING
    :   [a-zA-Z0-9_]+
    ;

/* White Space */
WS
    :   (' '|'\t'|'\n'|'\r')+   -> skip
    ;