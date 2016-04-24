/* ANTLR 4 Grammer file for Xquery
 */

grammar XQuery;

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

/* String without dot and not empty */
STRING
    :   [a-zA-Z0-9_]+
    ;

/* White Space */
WS
    :   (' '|'\t'|'\n'|'\r')+  ->  skip
    ;
