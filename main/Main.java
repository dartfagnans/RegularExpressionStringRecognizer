package main;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.RegularExpressionLexer;
import grammar.RegularExpressionParser;
import thompson.Thompson;
import thompson.Thompson.NFA;

public class Main {

	public static void main(String[] args) throws IOException {

		CharStream input = CharStreams.fromStream(System.in);

		RegularExpressionLexer lexer = new RegularExpressionLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		RegularExpressionParser parser = new RegularExpressionParser(tokens);

		ParseTree tree = parser.start();

		NFABuilder nfaBuilder = new NFABuilder();
		nfaBuilder.visit(tree);

		NFA nfa = Thompson.nfa;
		Thompson t = new Thompson();
		t.nfa = nfa;

		StringListListener stringListListener = new StringListListener();

		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(stringListListener, tree);

	}

}
