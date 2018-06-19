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
	 * Visit a parse tree produced by {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoice(RegularExpressionParser.ChoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(RegularExpressionParser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration(RegularExpressionParser.IterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd(RegularExpressionParser.EndContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegularExpressionParser#stringList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringList(RegularExpressionParser.StringListContext ctx);
}