package main;

import grammar.RegularExpressionBaseVisitor;
import grammar.RegularExpressionParser;
import thompson.Thompson;
import thompson.Thompson.NFA;

public class NFABuilder extends RegularExpressionBaseVisitor<NFA> {
	
	Thompson thompson = new Thompson();
	
	@Override
	public NFA visitEnd (RegularExpressionParser.EndContext ctx) {
		String prova = ctx.ID().getText();
		System.out.println(prova);
		NFA nfa = thompson.singleCharInput(prova.charAt(0));
		return nfa;
	}
	
	@Override
	public NFA visitChoice (RegularExpressionParser.ChoiceContext ctx) {
		System.out.println(ctx.getChild(0));
		System.out.println(ctx.getChildCount());
//		System.out.println(ctx.getChild(1));
		return thompson.singleCharInput('a');
	}
	
	@Override
	public NFA visitConcatenation (RegularExpressionParser.ConcatenationContext ctx) {
		System.out.println(ctx.getChild(0));
		System.out.println(ctx.getChildCount());
//		System.out.println(ctx.getChild(1));
		return thompson.singleCharInput('a');
	}
	
	@Override
	public NFA visitIteration (RegularExpressionParser.IterationContext ctx) {
		System.out.println(ctx.getChild(0));
		System.out.println(ctx.getChildCount());
//		System.out.println(ctx.getChild(1));
		return thompson.singleCharInput('a');
	}
	
	@Override
	public NFA visitRegEx (RegularExpressionParser.RegExContext ctx) {
		System.out.println(ctx.getChild(0));
		System.out.println(ctx.getChildCount());
		System.out.println(ctx.getChild(1));
		return thompson.singleCharInput('a');
	}
	
	@Override
	public NFA visitStringList (RegularExpressionParser.StringListContext ctx) {
		System.out.println(ctx.getChild(0));
		System.out.println(ctx.getChildCount());
		System.out.println(ctx.getChild(1));
		return thompson.singleCharInput('a');
	}
	
}
