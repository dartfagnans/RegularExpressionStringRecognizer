grammar RegularExpression;

start : regEx stringList;

regEx: choice;

choice : choice '+' concatenation #union
    | concatenation #goToConcat
    ;

concatenation : concatenation iteration #concat
    | iteration #goToIteration
    ;

iteration : iteration'*' #iterat
    | end #goToEnd
    ;

end : '('regEx')' #parens
    | ID #id
    | '_' #epsilon
    ;

stringList : ',' WORD* stringList
	|
	;

ID : [a-zA-Z0-9];
WORD : ('a'..'z'|'A'..'Z'|'0'..'9'|'_');

WS : [ \t\r\n]+ -> skip;