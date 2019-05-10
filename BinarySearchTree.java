
public class BinarySearchTree {
	
	private BinarySearchTreeNode root;

	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(BinarySearchTreeNode n) {
		root = n;
	}
	
	// SETTERS AND GETTERS
	public BinarySearchTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinarySearchTreeNode root) {
		this.root = root;
	}
	
	

}
