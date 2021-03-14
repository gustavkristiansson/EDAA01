package ext20200316;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	private Node root;
	
	/** Konstruktor - skapar ett Huffmanträd som representerar en binär kodning
	av symbolerna i frequencies. */
	public HuffmanTree(Map<Character, Double> frequencies) {
		PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> Double.compare(n1.weight, n2.weight));
		
		for(Map.Entry<Character, Double> e : frequencies.entrySet()) {
			q.offer(new Node(e.getKey(), e.getValue()));
		}
		
		while(q.size() > 1) {
			Node left = q.poll();
			Node right = q.poll();
		
			Node node = new Node(' ', left.weight + right.weight);	
			
			node.left = left;
			node.right = right;
			q.offer(node);
		}
		root = q.poll();
	}
	
	
	
	
	
	
	
	/** Statiskt nästlad klass - beskriver en nod i trädet. */
	private static class Node {
		private char symbol;
		private double weight;
		private Node left;
		private Node right;
		
		/* Skapar en nod som innehåller symbolen symbol. */
		private Node(char symbol, double weight) {
			this.symbol = symbol;
			this.weight = weight;
		}
	}
}
