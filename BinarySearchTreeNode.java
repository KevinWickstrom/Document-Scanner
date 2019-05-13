package documentScanner;
//Class done by Kevin

public class BinarySearchTreeNode {
	private String key;
	private int hash;
	private int count;
	private BinarySearchTreeNode right;
	private BinarySearchTreeNode left;
	
	public BinarySearchTreeNode() {
		key = "";
		right = null;
		left = null;
	}
	
	public BinarySearchTreeNode(String key) {
		this.key = key;
		count = 1;
		right = null;
		left = null;
	}
	
	public BinarySearchTreeNode(String key, int hash) {
		this.key = key;
		this.hash = hash;
		count = 1;
		right = null;
		left = null;
	}
	
	public void incrementCount() {
		count++;
	}
	
	public boolean isLeaf() {
		if(getLeftChild() == null && getRightChild() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int numChildren() {
		int num = 0;
		if(getLeftChild() != null) {
			num++;
		}
		if(getRightChild() != null ) {
			num++;
		}
		return num;
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

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
