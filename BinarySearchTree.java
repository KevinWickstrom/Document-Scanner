package documentScanner;
// AUTHOR: AXEL PONTEN
public class BinarySearchTree {
	
	private BinarySearchTreeNode root;

	// CONSTRUCTORS
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(BinarySearchTreeNode n) {
		root = n;
	}

	// hash function from instructions
	public int hashCode(String key) {
		double hash = 0.0;
		int base;
		int power;
		for (int i = 0; i < key.length(); i++) {
			base = (int) key.charAt(i) - 96;
			power = (i == 0) ? 3 : 2;
			hash += Math.pow(base, power) * Math.PI / (i + 1);
		}
		return (int) (hash * Math.E * 5 / key.length());
	}

	// INSERT 
	public void insert(String s) {
		int key = hashCode(s);
		// if tree is empty, make the string the node
		if(root == null) {
			root = new BinarySearchTreeNode(s, hashCode(s));
		}
		else {
			// pass into recursive insert-method
			insert(root, key, s);
		}
	}
	
	// pass in both the string and its hashcode as a parameter to avoid calculating key every iteration (passing parameter is cheaper than calling hashCode())
	private void insert(BinarySearchTreeNode current, int hash, String s) {
		int currentHash = current.getHash();
		
		// try/catch to find when leaf node is reached
		if(hash > currentHash) {
			try {
			insert(current.getRightChild(), hash, s);
			}
			catch (NullPointerException e) {
				// will run when at a leaf node
				current.setRightChild(new BinarySearchTreeNode(s,hash));
			}
		}
		else if(hash < currentHash) {
			try {
				insert(current.getLeftChild(), hash, s);
			}
			catch (NullPointerException e) {
				// will run when at a leaf node
				current.setLeftChild(new BinarySearchTreeNode(s,hash));
			}
		}
		// if duplicate, increment counter
		else if(hash == currentHash) {
			current.incrementCount();
		}
	}
	
	// SEARCH METHODS
	public BinarySearchTreeNode search(String word) {
		int hash = hashCode(word);
		return search(root, hash);
	}
	
	// recursive search
	private BinarySearchTreeNode search(BinarySearchTreeNode current, int hash) {
		int currentHash = current.getHash();
		if (hash > currentHash) {
			if(current.getRightChild() == null) {
				return null;
			}
			else {
				return search(current.getRightChild(), hash);
			}
		}
		else if(hash < currentHash) {
			if(current.getLeftChild() == null) {
				return null;
			}
			else {
				return search(current.getLeftChild(), hash);
			}
		}
		// if hash is not larger or smaller than currentHash then it's equal to it, which means node was found
		else {
			return current;
		}
		
	}
	
	// FIND PARENT, same idea as the search method, but keep track of the parent at all times.
	public BinarySearchTreeNode findParent(String s) {
		int hash = hashCode(s);
		return findParent(root, null, hash);
	}
	
	private BinarySearchTreeNode findParent(BinarySearchTreeNode current, BinarySearchTreeNode parent, int hash) {
		int currentHash = current.getHash();
		if (hash > currentHash) {
			if(current.getRightChild() == null) {
				return null;
			}
			else {
				return findParent(current.getRightChild(), current, hash);
			}
		}
		else if(hash < currentHash) {
			if(current.getLeftChild() == null) {
				return null;
			}
			else {
				return findParent(current.getLeftChild(), current, hash);
			}
		}
		// if hash is not larger or smaller than currentHash then it's equal to it, which means node was found
		else {
			return parent;
		}
	}
	
	public boolean delete(String s) {
		/*Cases:
		 * 
		 * Case 1. Delete a leaf node. Set parent's child reference to null
		 * Case 2. Delete a node in tree. Replace with min-node in right subtree
		 * Case 3. Delete a node in tree, but right subtree does not have a left branch
		 */
		
		BinarySearchTreeNode n = search(s);
		
		// check that the node exists
		if(n == null) {
			return false;
		}
		
		// CASE 1, node is a leaf
		if(n.isLeaf()) {
			BinarySearchTreeNode parent = findParent(n.getKey());
			// check if current node is to the right or left of parent
			if(n.getHash() > parent.getHash()) {
				parent.setRightChild(null);
			}
			else {
				parent.setLeftChild(null);
			}
			
			// deletion successful
			return true;
		}
		
		// CASE 2, replace node with successor node until successor node is a leaf node
		
		
		// CASE 3
		
	}
	
	private BinarySearchTreeNode deleteCase2(BinarySearchTreeNode toDelete) {
		// min in right subtree
		BinarySearchTreeNode succ = findMin(toDelete.getRightChild());
		if(succ.isLeaf()) {
			// detach succ from tree
			BinarySearchTreeNode parent = findParent(succ.getKey());
			// check if current node is to the right or left of parent
			if(succ.getHash() > parent.getHash()) {
				parent.setRightChild(null);
			}
			else {
				parent.setLeftChild(null);
			}
			
			// now replace toDelete with succ
			
			
		}
	}
	
	
	public BinarySearchTreeNode findMin(BinarySearchTreeNode current) {
		if(current.getLeftChild() == null) {
			return current;
		}
		else {
			return findMin(current.getLeftChild());
		}
	}
	

	
	// PRINTING METHODS
	public void print_Preorder() {
		if(root == null) {
			System.out.println("Empty tree");
		}
		else {
			print_Preorder(root);
		}
	}
	
	private void print_Preorder(BinarySearchTreeNode n) {
		if(n == null) {
			return;
		}
		System.out.println(n.getKey() + " " + n.getCount() + " " + n.getHash());
		print_Preorder(n.getLeftChild());
		print_Preorder(n.getRightChild());
	}
	
	public void print_Inorder() {
		if(root == null) {
			System.out.println("Empty tree");
		}
		else {
			print_Inorder(root);
		}
	}
	
	private void print_Inorder(BinarySearchTreeNode n) {
		if(n == null) {
			return;
		}
		print_Inorder(n.getLeftChild());
		System.out.println(n.getKey() + " " + n.getCount());
		print_Inorder(n.getRightChild());
	}
	
	public void print_Postorder() {
		if(root == null) {
			System.out.println("Empty tree");
		}
		else {
			print_Postorder(root);
		}
	}
	
	private void print_Postorder(BinarySearchTreeNode n) {
		if(n == null) {
			return;
		}
		print_Postorder(n.getLeftChild());
		print_Postorder(n.getRightChild());
		System.out.println(n.getKey() + " " + n.getCount());
	}
	
	// SETTERS AND GETTERS
	public BinarySearchTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinarySearchTreeNode root) {
		this.root = root;
	}
	
	

}
