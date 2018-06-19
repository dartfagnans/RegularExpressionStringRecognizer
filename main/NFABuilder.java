package main;

import grammar.RegularExpressionBaseVisitor;
import grammar.RegularExpressionParser;
import thompson.Thompson;
import thompson.Thompson.NFA;

public class NFABuilder extends RegularExpressionBaseVisitor<NFA> {
	
	Thompson thompson = new Thompson();
	
	@Override
	public NFA visitEnd (RegularExpressionParser.EndContext ctx) {
		return thompson.singleCharInput(ctx.ID().getText().charAt(0));
	}
	
	@Override
	public NFA visitChoice (RegularExpressionParser.ChoiceContext ctx) {
		return thompson.union(visit(ctx.choice()), visit(ctx.concatenation()));
	}
	
	@Override
	public NFA visitConcatenation (RegularExpressionParser.ConcatenationContext ctx) {
		return thompson.concatenation(visit(ctx.concatenation()), visit(ctx.iteration()));
	}
	
	@Override
	public NFA visitIteration (RegularExpressionParser.IterationContext ctx) {
		return thompson.kleenStar(visit(ctx.iteration()));
	}
	
	@Override
	public NFA visitRegEx (RegularExpressionParser.RegExContext ctx) {
		return visit(ctx.choice());
	}	
}
