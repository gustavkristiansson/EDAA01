package tests;

public class ExprTree {
	private ExprNode root;
	
	
	public boolean value(SymbolTable<Boolean> table) {
		if(root == null) {
			return false;
		}
		return value(table, root);
	}
		
	private boolean value(SymbolTable<Boolean> table, ExprNode n) {
		switch(n.element) {
		case "AND": return value(table, n.left) && value(table, n.right);
		case "OR" : return value(table, n.left) || value(table, n.right); 
		case "NOT": return value(table, n.left);
		default   : return table.getValue(n.element);
		}
	}
	
	private static class ExprNode {
		private String element;
		
		private ExprNode left;
		private ExprNode right;
		
		private ExprNode(String element) {
			this.element = element;
			left = null;
			right = null;
		}
	}
}
