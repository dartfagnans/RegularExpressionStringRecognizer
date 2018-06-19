package grammar;

// Generated from RegularExpression.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegularExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegularExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RegularExpressionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#regEx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegEx(RegularExpressionParser.RegExContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goToConcat}
	 * labeled alternative in {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToConcat(RegularExpressionParser.GoToConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code union}
	 * labeled alternative in {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(RegularExpressionParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goToIteration}
	 * labeled alternative in {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToIteration(RegularExpressionParser.GoToIterationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concat}
	 * labeled alternative in {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(RegularExpressionParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iterat}
	 * labeled alternative in {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterat(RegularExpressionParser.IteratContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goToEnd}
	 * labeled alternative in {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoToEnd(RegularExpressionParser.GoToEndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(RegularExpressionParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(RegularExpressionParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code epsilon}
	 * labeled alternative in {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEpsilon(RegularExpressionParser.EpsilonContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList(RegularExpressionParser.StringListContext ctx);
}