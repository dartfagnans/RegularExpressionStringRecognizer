package main;

import thompson.Thompson;
import thompson.Thompson.NFA;

public class Main {

	public static void main(String[] args) {
		Thompson thompson = new Thompson();

		NFA nfa1 = thompson.singleCharInput('a');
		NFA nfa2 = thompson.singleCharInput('b');
		NFA nfa3 = thompson.singleCharInput('c');
		NFA nfa4 = thompson.singleCharInput('d');
		
		NFA nfaResult = thompson.union(
							thompson.kleenStar(
									thompson.concatenation
										(thompson.union(
										nfa3, nfa4),
									nfa1)
							), 
						nfa2);
		
		System.out.println(nfaResult);
	}

}
