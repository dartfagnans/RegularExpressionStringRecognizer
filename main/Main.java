package main;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import grammar.RegularExpressionLexer;
import grammar.RegularExpressionParser;
import thompson.Thompson;
import thompson.Thompson.NFA;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
//		 Thompson thompson = new Thompson();
//		
//		 NFA nfa1 = thompson.singleCharInput('a');
//		 NFA nfa2 = thompson.singleCharInput('b');
//		 NFA nfa3 = thompson.singleCharInput('c');
//		 NFA nfa4 = thompson.singleCharInput('d');
//		 
//		 NFA nfa5 = thompson.union(nfa1, nfa2);
//		 NFA nfa6 = thompson.union(nfa3, nfa4);
//		 
//		 NFA nfaResult = thompson.concatenation(nfa5, nfa6);
//		 
//		 String s = "ad";
//		 String s1 = "bb";
//		 String s2 = "bc";
//		 String s3 = "ac";
//		 String s4 = "cd";
//		 
//		 System.out.println(nfaResult);
//		 System.out.println(thompson.recognizer(s));
//		 System.out.println(thompson.recognizer(s1));
//		 System.out.println(thompson.recognizer(s2));
//		 System.out.println(thompson.recognizer(s3));
//		 System.out.println(thompson.recognizer(s4));

		// create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(System.in);

		// create a lexer that feeds off of input CharStream
		RegularExpressionLexer lexer = new RegularExpressionLexer(input);

		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// create a parser that feeds off the tokens buffer
		RegularExpressionParser parser = new RegularExpressionParser(tokens);

		// begin parsing at init rule
		ParseTree tree = parser.start();

		NFABuilder nfaBuilder = new NFABuilder();
		nfaBuilder.visit(tree);
		
		NFA nfa = Thompson.nfa;

		StringListListener stringListListener = new StringListListener();
		
//		stringListVisitor.visit(tree);

		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker

		walker.walk(stringListListener, tree);

//		System.out.println(Thompson.nfa);
		
		
		Thompson t = new Thompson();
		t.nfa = nfa;
		for (String string : stringListListener.getStrings()) {
			System.out.print(string + ": " + t.recognizer(string) + ", ");
		}
	}

}
