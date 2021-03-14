package ext20170814;

public class LinkedPolynomial {
	private Node first;
	
	
	public LinkedPolynomial() {
		first = null;
	}
	
	
	
	
	public int getCoefficient(int exp) {
		if(exp < 0) {
			throw new IllegalArgumentException();
		}
		
		Node n = first;
		
		while(n != null) {
			if(n.exp == exp) {
				return n.coeff;
			}
			n = n.next;
		}
		
		return 0;
	}
	
	
	
	
	

	
	
	
	
	private static class Node {
		private int exp;
		private int coeff;
		private Node next;
		
		private Node(int exp, int coeff) {
			this.exp = exp;
			this.coeff = coeff;
			next = null;
		}
	}
}
