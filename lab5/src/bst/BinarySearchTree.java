package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
	}
	
	public static void main(String[] args) {
		BSTVisualizer window = new BSTVisualizer("Binary Tree", 400, 400);
		BSTVisualizer window2 = new BSTVisualizer("Binary Tree after rebuild", 400, 400);
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(23);
		tree.add(25);
		tree.add(87);
		tree.add(33);
		tree.add(17);
		tree.add(84);
		
		window.drawTree(tree);
		tree.rebuild();
		window2.drawTree(tree);
		tree.printTree();
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		return add(root, x);
	}
	
	private boolean add(BinaryNode<E> n, E x) {
		if(root == null) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		
		int comp = comparator.compare(x, n.element);
		
		if(comp == 0) {
			return false;
		} else if(comp > 0) {
			if(n.right != null) {
				add(n.right, x);
			} else {
				n.right = new BinaryNode<E>(x);
				size++;
			}
		} else if(comp < 0) {
			if(n.left != null) {
				add(n.left, x);
			} else {
				n.left = new BinaryNode<E>(x);
				size++;
			}
		}
		return true;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	private int height(BinaryNode<E> n) {
		if(n == null) {
			return 0;
		} else {
			return 1 + Math.max(height(n.left), height(n.right));
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		size = 0;
		root = null;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(BinaryNode<E> n) {
		if(n != null) {
			printTree(n.left);
			System.out.println(" " + n.element);
			printTree(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> list = new ArrayList<E>();
		// Adds all elements to array and then rebuilds tree recursively
		toArray(root, list);
		root = buildTree(list, 0, list.size());
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if(n != null) {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first > last || first == sorted.size()) {
			return null;
		}
		int mid = first + ((last - first) / 2);
		BinaryNode<E> newRoot = new BinaryNode<E>(sorted.get(mid));
		newRoot.left = buildTree(sorted, first, mid - 1);
		newRoot.right = buildTree(sorted, mid + 1, last);
		return newRoot;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
