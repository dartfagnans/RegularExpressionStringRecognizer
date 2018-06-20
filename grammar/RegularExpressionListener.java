package grammar;
// Generated from RegularExpression.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RegularExpressionParser}.
 */
public interface RegularExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RegularExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RegularExpressionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RegularExpressionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RegularExpressionParser#regEx}.
	 * @param ctx the parse tree
	 */
	void enterRegEx(RegularExpressionParser.RegExContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#regEx}.
	 * @param ctx the parse tree
	 */
	void exitRegEx(RegularExpressionParser.RegExContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goToConcat}
	 * labeled alternative in {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterGoToConcat(RegularExpressionParser.GoToConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goToConcat}
	 * labeled alternative in {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitGoToConcat(RegularExpressionParser.GoToConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code union}
	 * labeled alternative in {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterUnion(RegularExpressionParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code union}
	 * labeled alternative in {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitUnion(RegularExpressionParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goToIteration}
	 * labeled alternative in {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 */
	void enterGoToIteration(RegularExpressionParser.GoToIterationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goToIteration}
	 * labeled alternative in {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 */
	void exitGoToIteration(RegularExpressionParser.GoToIterationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concat}
	 * labeled alternative in {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 */
	void enterConcat(RegularExpressionParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 */
	void exitConcat(RegularExpressionParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iterat}
	 * labeled alternative in {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterIterat(RegularExpressionParser.IteratContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iterat}
	 * labeled alternative in {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitIterat(RegularExpressionParser.IteratContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goToEnd}
	 * labeled alternative in {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterGoToEnd(RegularExpressionParser.GoToEndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goToEnd}
	 * labeled alternative in {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitGoToEnd(RegularExpressionParser.GoToEndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void enterParens(RegularExpressionParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void exitParens(RegularExpressionParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void enterId(RegularExpressionParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void exitId(RegularExpressionParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEpsilon(RegularExpressionParser.EpsilonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEpsilon(RegularExpressionParser.EpsilonContext ctx);
	/**
	 * Enter a parse tree produced by {@link RegularExpressionParser#stringList}.
	 * @param ctx the parse tree
	 */
	void enterStringList(RegularExpressionParser.StringListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#stringList}.
	 * @param ctx the parse tree
	 */
	void exitStringList(RegularExpressionParser.StringListContext ctx);
}