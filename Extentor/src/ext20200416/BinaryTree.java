package ext20200416;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
	private Node<E> root;
	
	
	public List<E> leaves() {
		List<E> list = new ArrayList<>();
		return recLeaves(root, list);
	}
	
	private List<E> recLeaves(Node<E> n, List<E> list) {
		if(n != null) {
			if(n.left == null && n.right == null) {
				list.add(n.element);
			}
			recLeaves(n.left, list);
			recLeaves(n.right, list);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
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
