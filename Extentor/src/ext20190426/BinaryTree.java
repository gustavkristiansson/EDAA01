package ext20190426;

public class BinaryTree {
	private Node root;
	
	
	
	
	private int sumLeafs() {
		if(root == null) {
			return 0;
		} else {
			return recSumLeafs(root);
		}
	}
	
	private int recSumLeafs(Node n) {
		if(n.left == null) {
			return root.data; 
		} else {
			
			return recSumLeafs(n.left) + recSumLeafs(n.right);
		}
	}
	
	
	public boolean isMobile() {
		if(root == null) {
			return true;
		} else {
			return recIsMobile(root);
		}
	}
	
	private boolean recIsMobile(Node n) {
		if(n.left == null) {
			return true;
		} else {
			return recIsMobile(n.left) && recIsMobile(n.right) && 
					recSumLeafs(n.left) == recSumLeafs(n.right);
		}
	}
	
	
	private static class Node {
		private int data;
		private Node left;
		private Node right;
	}
}
