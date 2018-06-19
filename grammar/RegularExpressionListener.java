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
	 * Enter a parse tree produced by {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 */
	void enterChoice(RegularExpressionParser.ChoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#choice}.
	 * @param ctx the parse tree
	 */
	void exitChoice(RegularExpressionParser.ChoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(RegularExpressionParser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#concatenation}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(RegularExpressionParser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterIteration(RegularExpressionParser.IterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitIteration(RegularExpressionParser.IterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void enterEnd(RegularExpressionParser.EndContext ctx);
	/**
	 * Exit a parse tree produced by {@link RegularExpressionParser#end}.
	 * @param ctx the parse tree
	 */
	void exitEnd(RegularExpressionParser.EndContext ctx);
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