grammar RegularExpression;

start : regEx stringList;

regEx: choice;

choice : choice '+' concatenation
    | concatenation
    ;

concatenation : concatenation iteration
    | iteration
    ;

iteration : iteration'*'
    | end
    ;

end : '('choice')'
    | ID
    | '_'
    ;

stringList : ',' ID* stringList
	|
    | '_'
	;

ID : [a-zA-Z0-9];

WS : [ \t\r\n]+ -> skip;