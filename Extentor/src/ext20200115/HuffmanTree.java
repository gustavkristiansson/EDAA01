package ext20200115;

import java.util.Map;
import java.util.TreeMap;

public class HuffmanTree {
	private Node root;
	
	
	
	/** Returnerar en sträng som innehåller den klartext som motsvarar den binära
	koden code. */
	public String decode(String code) {
		StringBuilder sb =  new StringBuilder();
		
		Node temp = root;
		
		for(int i = 0; i < code.length(); i++) {
			if(code.charAt(i) == '0') {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
			if(temp.left == null) {
				sb.append(temp.symbol);
				temp = root;
			}
		}
		return sb.toString();
	}
	
	public Map<Character, String> getEncoding() {
		Map<Character, String> map = new TreeMap<>();
		if(root != null) {
			getEncoding(root, "", map);
		}
		return map;
	}
	
	private void getEncoding(Node n, String text, Map<Character, String> map) {
		if(n.left == null) {
			map.put(n.symbol, text);
		} else {
			getEncoding(n.left, text + "0", map);
			getEncoding(n.right, text + "1", map);
		}
	}
	
	
	private static class Node {
		private char symbol;
		private Node left;
		private Node right;
		
		private Node(char symbol) {
			this.symbol = symbol;
		}
	}
}
