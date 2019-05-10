package documentScanner;
//Class done by Kevin

public class BinarySearchTreeNode {
	private String key;
	private BinarySearchTreeNode right;
	private BinarySearchTreeNode left;
	
	public BinarySearchTreeNode() {
		key = "";
		right = null;
		left = null;
	}
	
	public BinarySearchTreeNode(String key) {
		this.key = key;
		right = null;
		left = null;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setLeftChild(BinarySearchTreeNode add) {
		left = add;
	}
	
	public void setRightChild(BinarySearchTreeNode add) {
		right = add;
	}
	
	public String getKey() {
		return key;
	}
	
	public BinarySearchTreeNode getLeftChild() {
		return left;
	}
	
	public BinarySearchTreeNode getRightChild() {
		return right;
	}
}
