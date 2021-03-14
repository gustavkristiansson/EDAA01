package ext20190821;

public class BinarySearchTree<E extends Comparable<E>> {
	private Node<E> root;
	
	public void printBiggerThan(E x) {
		if(root == null) {
			return;
		} else {
			printBiggerThan(root, x);
		}
	}
	
	private void printBiggerThan(Node<E> n, E x) {
		int comp = n.data.compareTo(x);
		if(comp > 0) {
			printBiggerThan(n.left, x);
			System.out.println(n.data);
		}
		printBiggerThan(n.right, x);
	}
	
	
	public static int snowBalls(int n) {
		if(n == 1) {
			return 1;
		} else {
			return n * n + snowBalls(n-1);
		}
	}
	
	public static void main(String[] args) {
		int x = snowBalls(3);
		
		System.out.println(x);
		
	}
	
	
	
	
	
	
	private static class Node<E> {
		private E data;
		private Node<E> left;
		private Node<E> right;
		
		
		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
}
	

