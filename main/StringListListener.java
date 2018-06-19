package main;

import java.util.ArrayList;

import grammar.RegularExpressionBaseListener;
import grammar.RegularExpressionParser;

public class StringListListener extends RegularExpressionBaseListener {
	
	ArrayList<String> stringhe = new ArrayList<String>();
	
	@Override
	public void exitStringList (RegularExpressionParser.StringListContext ctx) {
		String string = "";
		string = ctx.getText();
		stringhe.add(string);
		System.out.println(string);
	}

}
