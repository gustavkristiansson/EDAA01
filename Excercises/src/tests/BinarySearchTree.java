package tests;

public class BinarySearchTree<E extends Comparable<E>> {
	private Node<E> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public E deleteMin() {
		if(root == null) {
			return null;
		}
		E temp = null;
		if(root.left == null) {
			temp = root.element;
			root = root.right;
		} else {
			Node<E> n = root;
			Node<E> p = root.left;
			while(p.left!= null) {
				n = p;
				p = p.left;
			} 
			temp = p.element;
			n.left = p.right;
		}
		
		return temp;
	}
	
	private static class Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;
		
		private Node(E element) {
			this.element = element;
			left = null;
			right = null;
		}
	}

}
