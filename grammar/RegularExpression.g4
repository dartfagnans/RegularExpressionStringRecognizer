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

stringList : ',' word* stringList
	|
    | '_'
	;

word : ID | '_' ;

ID : [a-zA-Z0-9];

WS : [ \t\r\n]+ -> skip;