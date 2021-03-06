package thompson;

import java.util.ArrayList;
import java.util.Stack;

public class Thompson {

	public static NFA nfa;
	private static int count;

	public Thompson() {
		this.nfa = new NFA();
		this.count = 0;
	}

	public Thompson(NFA nfa) {
		this.nfa = nfa;
		this.count = 0;
	}

	public class NFA {

		private ArrayList<Node> nodes;
		private ArrayList<Edge> edges;

		public NFA() {
			this.nodes = new ArrayList<Node>();
			this.edges = new ArrayList<Edge>();
		}

		public NFA(ArrayList<Node> nfa, ArrayList<Edge> edges) {
			this.nodes = nfa;
			this.edges = edges;
		}

		public ArrayList<Node> getNodes() {
			return this.nodes;
		}

		public ArrayList<Edge> getEdges() {
			return this.edges;
		}

		public Node getInitialNode() {
			for (int i = 0; i < this.nodes.size(); i++) {
				if (this.nodes.get(i).isInitial) {
					return this.nodes.get(i);
				}
			}
			return new Node();
		}

		public Node getFinalNode() {
			for (int i = 0; i < this.nodes.size(); i++) {
				if (this.nodes.get(i).isFinal) {
					return this.nodes.get(i);
				}
			}
			return new Node();
		}

		@Override
		public String toString() {
			String temp = "States (i for initial state; f for final state):\n";
			for (int i = 0; i < nodes.size(); i++) {
				temp += nodes.get(i) + "\n";
			}
			temp += "\nEdges (start, end, input):\n";
			for (int i = 0; i < edges.size(); i++) {
				temp += edges.get(i) + "\n";
			}
			return temp;
		}

		public ArrayList<Node> getNextNodes(Node node, char input) {
			ArrayList<Node> nextNodes = new ArrayList<Node>();
			for (Edge edge : node.edges) {
				if (input == edge.input || edge.input == '_') {
					nextNodes.add(edge.endNode);
				}
			}
			return nextNodes;
		}

	}

	private class Node {
		private ArrayList<Edge> edges;
		private boolean isInitial = false;
		private boolean isFinal = false;
		private int id;

		private Node() {
			this.edges = new ArrayList<Edge>();
			this.id = Thompson.count++;
		}

		private Node(ArrayList<Edge> archi) {
			this.edges = archi;
			this.id = Thompson.count++;
		}
		
		private ArrayList<Edge> getOuterEdges () {
			ArrayList<Edge> outerEdges = new ArrayList<>();
			for (Edge edge : this.edges) {
				if (edge.startNode == this)
					outerEdges.add(edge);
			}
			return outerEdges;
		}

		private void setIsInitial(boolean isInitial) {
			this.isInitial = isInitial;
		}

		private void setIsFinal(boolean isFinal) {
			this.isFinal = isFinal;
		}

		private void setEdges(ArrayList<Edge> edges) {
			this.edges = edges;
		}

		private ArrayList<Edge> getEdges() {
			return this.edges;
		}

		@Override
		public String toString() {
			if (this.isFinal)
				return this.id + "f";
			else if (this.isInitial)
				return this.id + "i";
			else
				return this.id + "";
		}

	}

	private class Edge {
		private Node startNode;
		private Node endNode;
		private char input;
		// private String id = "";

		private Edge() {
			this.startNode = new Node();
			this.endNode = new Node();
			this.input = '_'; // '_' significa epsilon
			// this.id = "" + this.startNode + this.endNode + this.input;
		}

		private Edge(Node nodoPartenza, Node nodoArrivo, char input) {
			this.startNode = nodoPartenza;
			this.endNode = nodoArrivo;
			this.input = input;
			// this.id = "" + this.startNode + this.endNode + this.input;
		}

		private void setStartNode(Node startNode) {
			this.startNode = startNode;
		}

		private void setEndNode(Node endNode) {
			this.endNode = endNode;
		}

		private Node getStartNode() {
			return this.startNode;
		}

		private Node getEndNode() {
			return this.endNode;
		}

		@Override
		public String toString() {
			return "(" + this.startNode + ", " + this.endNode + ", " + this.input + ")";
		}

	}

	/*
	 * *********** INIZIO METODI COSTRUZIONE NFA CON ALGORITMO DI THOMPSON
	 * ************
	 */

	// TODO!! TUTTO OK!
	public NFA singleCharInput(char input) {
		// creo un nuovo nodo e lo imposto come iniziale
		Node nodeOne = new Node();
		nodeOne.setIsInitial(true);
		// creo un nuovo nodo e lo imposto come finale
		Node nodeTwo = new Node();
		nodeTwo.setIsFinal(true);
		// creo un arco che colleghi i due nodi con input = input
		Edge edge = new Edge(nodeOne, nodeTwo, input);
		// creo una lista di archi
		ArrayList<Edge> edgesOne = new ArrayList<Edge>();
		// aggiungo il nuovo arco alla lista
		edgesOne.add(edge);
		// creo una lista di archi
		ArrayList<Edge> edgesTwo = new ArrayList<Edge>();
		// aggiungo il nuovo arco alla lista
		edgesTwo.add(edge);
		// creo una lista di archi
		ArrayList<Edge> edges = new ArrayList<Edge>();
		// aggiungo il nuovo arco alla lista
		edges.add(edge);
		// assegno ai due nodi l'arco passandogli la lista
		nodeOne.setEdges(edgesOne);
		nodeTwo.setEdges(edgesTwo);
		// creo una lista di nodi
		ArrayList<Node> nodes = new ArrayList<Node>();
		// aggiungo alla lista i due nodi
		nodes.add(nodeOne);
		nodes.add(nodeTwo);
		// ritorno un nuovo NFA con i nodi e gli archi generati
		this.nfa = new NFA(nodes, edges);
		return this.nfa;
	}

	// TODO!!! TUTTO OK!!
	public NFA union(NFA left, NFA right) {
		// genero un nuovo nodo e lo imposto come iniziale
		Node fakeNodeOne = new Node();
		fakeNodeOne.setIsInitial(true);
		// genero un nuovo nodo e lo imposto come finale
		Node fakeNodeTwo = new Node();
		fakeNodeTwo.setIsFinal(true);
		// prendo il nodo iniziale del NFA sinistro di partenza
		Node exInitialLeft = left.getInitialNode();
		// e non lo rendo pi� iniziale
		exInitialLeft.setIsInitial(false);
		// stessa cosa per il nodo finale
		Node exFinalLeft = left.getFinalNode();
		exFinalLeft.setIsFinal(false);
		// stessa cosa per il ramo destro
		Node exInitialRight = right.getInitialNode();
		exInitialRight.setIsInitial(false);
		Node exFinalRight = right.getFinalNode();
		exFinalRight.setIsFinal(false);
		// creo i 4 nuovi archi
		Edge edge1 = new Edge(fakeNodeOne, exInitialLeft, '_');
		Edge edge2 = new Edge(fakeNodeOne, exInitialRight, '_');
		Edge edge3 = new Edge(exFinalLeft, fakeNodeTwo, '_');
		Edge edge4 = new Edge(exFinalRight, fakeNodeTwo, '_');
		// creo una lista di archi e ci aggiungo i nuovi 4
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		// aggiungo i nuovi archi ai due nuovi nodi
		ArrayList<Edge> newFakeNodeOneEdges = new ArrayList<Edge>();
		newFakeNodeOneEdges.add(edge1);
		newFakeNodeOneEdges.add(edge2);
		fakeNodeOne.setEdges(newFakeNodeOneEdges);
		ArrayList<Edge> newFakeNodeTwoEdges = new ArrayList<Edge>();
		newFakeNodeTwoEdges.add(edge3);
		newFakeNodeTwoEdges.add(edge4);
		fakeNodeTwo.setEdges(newFakeNodeTwoEdges);
		// aggiungo alla lista anche gli archi gi� esistenti
		addEdgesFromList(left.getEdges(), edges);
		addEdgesFromList(right.getEdges(), edges);
		// prendo i vecchi archi dell'ex nodo iniziale sinistro
		ArrayList<Edge> exEdgesInitialLeft = new ArrayList<Edge>();
		addEdgesFromList(exInitialLeft.getEdges(), exEdgesInitialLeft);
		// ci aggiungo i nuovi archi che riguardano il nodo
		exEdgesInitialLeft.add(edge1);
		// risetto la nuova lista di archi per il nodo interessato
		exInitialLeft.setEdges(exEdgesInitialLeft);
		// prendo i vecchi archi dell'ex nodo finale sinistro
		ArrayList<Edge> exFinalLeftEdges = new ArrayList<Edge>();
		addEdgesFromList(exFinalLeft.getEdges(), exFinalLeftEdges);
		// ci aggiungo i nuovi archi che riguardano il nodo
		exFinalLeftEdges.add(edge3);
		// risetto la nuova lista di archi per il nodo interessato
		exFinalLeft.setEdges(exFinalLeftEdges);
		// prendo i vecchi archi dell'ex nodo iniziale destro
		ArrayList<Edge> exInitialRightEdges = new ArrayList<Edge>();
		addEdgesFromList(exInitialRight.getEdges(), exInitialRightEdges);
		// ci aggiungo i nuovi archi che riguardano il nodo
		exInitialRightEdges.add(edge2);
		// risetto la nuova lista di archi per il nodo interessato
		exInitialRight.setEdges(exInitialRightEdges);
		// prendo i vecchi archi dell'ex nodo finale destro
		ArrayList<Edge> exEdgesFinalRight = new ArrayList<Edge>();
		addEdgesFromList(exFinalRight.getEdges(), exEdgesFinalRight);
		// ci aggiungo i nuovi archi che riguardano il nodo
		exEdgesFinalRight.add(edge4);
		// risetto la nuova lista di archi per il nodo interessato
		exFinalRight.setEdges(exEdgesFinalRight);
		// creo una lista di nodi e ci aggiungo i due nuovi
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(fakeNodeOne);
		nodes.add(fakeNodeTwo);
		// aggiungo alla lista anche i nodi gi� esistenti
		addNodesFromList(left.getNodes(), nodes);
		addNodesFromList(right.getNodes(), nodes);
		// ritorno un nuovo NFA passandogli la lista di nodi e di archi
		this.nfa = new NFA(nodes, edges);
		return this.nfa;
	}

	// TODO!!! TUTTO OK!!
	public NFA concatenation(NFA left, NFA right) {
		Node exFinalLeft = left.getFinalNode();
		exFinalLeft.setIsFinal(false);
		Node exInitialRight = right.getInitialNode();

		ArrayList<Edge> exInitialRightEdges = exInitialRight.getEdges();

		for (Edge edge : exInitialRightEdges) {
			edge.setStartNode(exFinalLeft);
		}

		ArrayList<Edge> exFinalLeftEdges = exFinalLeft.getEdges();
		addEdgesFromList(exInitialRightEdges, exFinalLeftEdges);
		exFinalLeft.setEdges(exFinalLeftEdges);

		right.getNodes().remove(exInitialRight);
		right.getEdges().remove(exInitialRightEdges);

		ArrayList<Node> nodes = new ArrayList<Node>();
		addNodesFromList(left.getNodes(), nodes);
		addNodesFromList(right.getNodes(), nodes);

		ArrayList<Edge> edges = new ArrayList<Edge>();
		addEdgesFromList(left.getEdges(), edges);
		addEdgesFromList(right.getEdges(), edges);

		this.nfa = new NFA(nodes, edges);
		return this.nfa;
	}

	// TODO TUTTO OK!!
	public NFA kleenStar(NFA nfa) {
		// creo i due nuovi stati fake e imposto il primo come iniziale e il secondo
		// come finale
		Node fakeNodeOne = new Node();
		fakeNodeOne.setIsInitial(true);
		Node fakeNodeTwo = new Node();
		fakeNodeTwo.setIsFinal(true);
		// prendo l'ex nodo iniziale e lo imposto come non iniziale
		Node exInitialNode = nfa.getInitialNode();
		exInitialNode.setIsInitial(false);
		// stessa cosa con l'ex nodo finale
		Node exFinalNode = nfa.getFinalNode();
		exFinalNode.setIsFinal(false);
		// creo le nuove transizioni
		Edge fakeEdgeOne = new Edge(fakeNodeOne, exInitialNode, '_');
		Edge fakeEdgeTwo = new Edge(exFinalNode, fakeNodeTwo, '_');
		Edge fakeEdgeThree = new Edge(exFinalNode, exInitialNode, '_');
		Edge fakeEdgeFour = new Edge(fakeNodeOne, fakeNodeTwo, '_');
		// setto gli archi per i nuovi nodi
		ArrayList<Edge> fakeNodeOneEdges = new ArrayList<Edge>();
		fakeNodeOneEdges.add(fakeEdgeOne);
		fakeNodeOneEdges.add(fakeEdgeFour);
		fakeNodeOne.setEdges(fakeNodeOneEdges);
		ArrayList<Edge> fakeNodeTwoEdges = new ArrayList<Edge>();
		fakeNodeTwoEdges.add(fakeEdgeTwo);
		fakeNodeTwoEdges.add(fakeEdgeFour);
		fakeNodeTwo.setEdges(fakeNodeTwoEdges);
		// prendo i vecchi archi dal vecchio nodo iniziale e ci aggiungo i nuovi
		ArrayList<Edge> exInitialNodeEdges = exInitialNode.getEdges();
		exInitialNodeEdges.add(fakeEdgeOne);
		exInitialNodeEdges.add(fakeEdgeThree);
		// setto la nuova lista di archi
		exInitialNode.setEdges(exInitialNodeEdges);
		// stessa cosa per l'ex nodo finale
		ArrayList<Edge> exFinalNodeEdges = exFinalNode.getEdges();
		exFinalNodeEdges.add(fakeEdgeTwo);
		exFinalNodeEdges.add(fakeEdgeThree);
		exFinalNode.setEdges(exFinalNodeEdges);
		// creo una lista con i nuovi archi
		ArrayList<Edge> edges = new ArrayList<Edge>();
		edges.add(fakeEdgeOne);
		edges.add(fakeEdgeTwo);
		edges.add(fakeEdgeThree);
		edges.add(fakeEdgeFour);
		// aggiungo alla lista i vecchi archi
		addEdgesFromList(nfa.getEdges(), edges);
		// creo una lista per i nuovi nodi
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(fakeNodeOne);
		nodes.add(fakeNodeTwo);
		// aggiungo alla lista i vecchi nodi
		addNodesFromList(nfa.getNodes(), nodes);
		// ritorno un nuovo nfa passandogli gli archi e i nodi
		this.nfa = new NFA(nodes, edges);
		return this.nfa;
	}

	private void addEdgesFromList(ArrayList<Edge> edgesToAdd, ArrayList<Edge> edges) {
		for (int i = 0; i < edgesToAdd.size(); i++) {
			edges.add(edgesToAdd.get(i));
		}
	}

	private void addNodesFromList(ArrayList<Node> nodesToAdd, ArrayList<Node> nodes) {
		for (int i = 0; i < nodesToAdd.size(); i++) {
			nodes.add(nodesToAdd.get(i));
		}
	}

	@Override
	public String toString() {
		return this.nfa.toString();
	}

	private ArrayList<Node> epsClosure(Node node) {
		ArrayList<Edge> edges = node.getOuterEdges();
		ArrayList<Node> epsClosure = new ArrayList<Node>();
		for (Edge edge : edges) {
			if (edge.input == '_') {
				if (!epsClosure.contains(edge.endNode))
					epsClosure.add(edge.endNode);
			}
		}
		return epsClosure;
	}

	private ArrayList<Node> epsClosure(ArrayList<Node> nodes) {
		Stack<Node> S = new Stack<Node>();
		S.addAll(nodes);
		ArrayList<Node> closure = new ArrayList<Node>();
		addNodesFromList(nodes, closure);
		Node n = new Node();

		while (!S.isEmpty()) {
			n = S.pop();
			for (Node node : move(n, '_')) {
				if (!closure.contains(node)) {
					closure.add(S.push(node));
				}
			}
		}
		return closure;

	}

	private ArrayList<Node> move(Node node, char input) {
		ArrayList<Node> move = new ArrayList<Node>();
		for (Edge edge : node.getOuterEdges()) {
			if (edge.input == input) {
				move.add(edge.endNode);
			}
		}
		return move;
	}

	private ArrayList<Node> move(ArrayList<Node> nodes, char input) {
		ArrayList<Node> move = new ArrayList<Node>();
		for (Node node : nodes) {
			ArrayList<Edge> edges = node.getOuterEdges();
			for (Edge edge : edges) {
				if (edge.input == input) {
					if (!move.contains(edge.endNode)) {
						move.add(edge.endNode);
					}
				}
			}
		}
		return move;
	}

	private boolean checkString(String string) {
		ArrayList<Node> startClosure = new ArrayList<Node>();
		startClosure.add(this.nfa.getInitialNode());
		ArrayList<Node> S = epsClosure(startClosure);
		char c = string.charAt(0);

		for (int i = 0; i < string.length(); i++) {
			c = string.charAt(i);
			S = epsClosure(move(S, c));
		}

		if (S.contains(this.nfa.getFinalNode()))
			return true;
		else
			return false;
	}

	public String recognizer(String string) {
		if (checkString(string))
			return "OK";
		return "KO";
	}

	public void setNFA(NFA nfa) {
		this.nfa = nfa;
	}

}
