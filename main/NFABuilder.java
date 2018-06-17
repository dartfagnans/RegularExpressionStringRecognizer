package main;

import grammar.RegularExpressionBaseListener;
import grammar.RegularExpressionParser;
import thompson.Thompson;
import thompson.Thompson.NFA;

public class NFABuilder extends RegularExpressionBaseListener {
	
	Thompson thompson = new Thompson();
	
	@Override
	public void exitEnd (RegularExpressionParser.EndContext ctx) {
		String prova = ctx.ID().getText();
		NFA nfa = thompson.singleCharInput(prova.charAt(0));
	}
	
	@Override
	public void exitChoice (RegularExpressionParser.ChoiceContext ctx) {
		
	}
	
}
