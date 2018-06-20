package main;

import java.util.ArrayList;

import grammar.RegularExpressionBaseListener;
import grammar.RegularExpressionParser;
import thompson.Thompson;

public class StringListListener extends RegularExpressionBaseListener {
	ArrayList<String> strings = new ArrayList<String>();
	Thompson t = new Thompson();

	@Override
	public void enterStringList(RegularExpressionParser.StringListContext ctx) {
		if (ctx.ID().size() != 0) {
			String string = "";
			for (int i = 0; i < ctx.ID().size(); i++) {
				string += ctx.ID(i).getText();
			}
			strings.add(string);
		}
	}

	public ArrayList<String> getStrings() {
		return this.strings;
	}

}
