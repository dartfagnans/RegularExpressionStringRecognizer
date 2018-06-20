package main;

import java.util.ArrayList;

import grammar.RegularExpressionBaseListener;
import grammar.RegularExpressionParser;
import thompson.Thompson;

public class StringListListener extends RegularExpressionBaseListener {
	ArrayList<String> strings = new ArrayList<String>();
	Thompson t = new Thompson(Thompson.nfa);

	@Override
	public void enterStringList(RegularExpressionParser.StringListContext ctx) {
		if (ctx.word().size() != 0) {
			String string = "";
			for (int i = 0; i < ctx.word().size(); i++) {
				string += ctx.word(i).getText();
			}
			strings.add(string);
			System.out.print(t.recognizer(string) + " ");
		}
	}

	public ArrayList<String> getStrings() {
		return this.strings;
	}

}
