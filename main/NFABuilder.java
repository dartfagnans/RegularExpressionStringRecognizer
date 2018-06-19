package main;

import grammar.RegularExpressionBaseVisitor;
import grammar.RegularExpressionParser;
import thompson.Thompson;
import thompson.Thompson.NFA;

public class NFABuilder extends RegularExpressionBaseVisitor<NFA> {

	Thompson thompson = new Thompson();

	@Override
	public NFA visitRegEx(RegularExpressionParser.RegExContext ctx) {
		return visit(ctx.choice());
	}

	@Override
	public NFA visitUnion(RegularExpressionParser.UnionContext ctx) {
		return thompson.union(visit(ctx.choice()), visit(ctx.concatenation()));
	}

	@Override
	public NFA visitGoToConcat(RegularExpressionParser.GoToConcatContext ctx) {
		return visit(ctx.concatenation());
	}

	@Override
	public NFA visitConcat(RegularExpressionParser.ConcatContext ctx) {
		return thompson.concatenation(visit(ctx.concatenation()), visit(ctx.iteration()));
	}

	@Override
	public NFA visitGoToIteration(RegularExpressionParser.GoToIterationContext ctx) {
		return visit(ctx.iteration());
	}

	@Override
	public NFA visitIterat(RegularExpressionParser.IteratContext ctx) {
		return thompson.kleenStar(visit(ctx.iteration()));
	}

	@Override
	public NFA visitGoToEnd(RegularExpressionParser.GoToEndContext ctx) {
		return visit(ctx.end());
	}

	@Override
	public NFA visitParens(RegularExpressionParser.ParensContext ctx) {
		return visit(ctx.regEx());
	}

	@Override
	public NFA visitId(RegularExpressionParser.IdContext ctx) {
		return thompson.singleCharInput(ctx.ID().getText().charAt(0));
	}
}
