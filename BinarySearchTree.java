package documentScanner;
import java.util.ArrayList;
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
		if (root == null) {
			root = new BinarySearchTreeNode(s, hashCode(s));
		} else {
			// pass into recursive insert-method
			insert(root, key, s);
		}
	}

	// pass in both the string and its hashcode as a parameter to avoid calculating
	// key every iteration (passing parameter is cheaper than calling hashCode())
	private void insert(BinarySearchTreeNode current, int hash, String s) {
		int currentHash = current.getHash();

		// try/catch to find when leaf node is reached
		if (hash > currentHash) {
			try {
				insert(current.getRightChild(), hash, s);
			} catch (NullPointerException e) {
				// will run when at a leaf node
				current.setRightChild(new BinarySearchTreeNode(s, hash));
			}
		} else if (hash < currentHash) {
			try {
				insert(current.getLeftChild(), hash, s);
			} catch (NullPointerException e) {
				// will run when at a leaf node
				current.setLeftChild(new BinarySearchTreeNode(s, hash));
			}
		}
		// if duplicate, increment counter
		else if (hash == currentHash) {
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
			if (current.getRightChild() == null) {
				return null;
			} else {
				return search(current.getRightChild(), hash);
			}
		} else if (hash < currentHash) {
			if (current.getLeftChild() == null) {
				return null;
			} else {
				return search(current.getLeftChild(), hash);
			}
		}
		// if hash is not larger or smaller than currentHash then it's equal to it,
		// which means node was found
		else {
			return current;
		}

	}

	// FIND PARENT, same idea as the search method, but keep track of the parent at
	// all times.
	public BinarySearchTreeNode findParent(String s) {
		int hash = hashCode(s);
		return findParent(root, null, hash);
	}

	private BinarySearchTreeNode findParent(BinarySearchTreeNode current, BinarySearchTreeNode parent, int hash) {
		int currentHash = current.getHash();
		if (hash > currentHash) {
			if (current.getRightChild() == null) {
				return null;
			} else {
				return findParent(current.getRightChild(), current, hash);
			}
		} else if (hash < currentHash) {
			if (current.getLeftChild() == null) {
				return null;
			} else {
				return findParent(current.getLeftChild(), current, hash);
			}
		}
		// if hash is not larger or smaller than currentHash then it's equal to it,
		// which means node was found
		else {
			return parent;
		}
	}

	public boolean delete(String s) {
		BinarySearchTreeNode n = search(s);
		return delete(n);
	}

	private boolean delete(BinarySearchTreeNode n) {
		/*
		 * Cases: Case 0. 0 children. Point parent to null Case 1. 1 child. Point parent
		 * to the node's child. Case 2. 2 children. Find min in right subtree and
		 * replace.
		 */
		// check that the node exists
		if (n == null) {
			return false;
		}
		// find number of children of node we want to delete
		int numChildren = n.numChildren();
		// find suitable deletion case
		switch (numChildren) {
		case 0:
			deleteCase0(n);
			break;
		case 1:
			deleteCase1(n);
			break;
		case 2:
			deleteCase2(n);
			break;
		}
		return true;
	}

	private void deleteCase0(BinarySearchTreeNode toDelete) {
		// first handle case if the node is root
		if (toDelete == root) {
			root = null;
		} else {
			BinarySearchTreeNode parent = findParent(toDelete.getKey());
			// check if current node is to the right or left of parent
			if (toDelete.getHash() > parent.getHash()) {
				parent.setRightChild(null);
			} else {
				parent.setLeftChild(null);
			}
		}
		// deletion successful
	}

	private void deleteCase1(BinarySearchTreeNode toDelete) {
		// get parent of toDelete
		BinarySearchTreeNode parent = findParent(toDelete.getKey());
		// get child of toDelete
		BinarySearchTreeNode child;
		if (toDelete.getLeftChild() != null) {
			child = toDelete.getLeftChild();
			toDelete.setLeftChild(null);
		} else {
			child = toDelete.getRightChild();
			toDelete.setRightChild(null);
		}
		// parent is null if toDelete is root
		if (parent == null) {
			root = child;
		} else {
			// point parent to child after finding if toDelete is right/left of parent
			if (parent.getLeftChild() == toDelete) {
				parent.setLeftChild(child);
			} else {
				parent.setRightChild(child);
			}
		}
	}

	private void deleteCase2(BinarySearchTreeNode toDelete) {
		/*
		 * find successor node (minNode in right subtree), replace toDelete with
		 * successor node then, delete the successor node (either case0, case1 or case2
		 * (recursive))
		 */
		// find successor
		BinarySearchTreeNode succ = findMin(toDelete.getRightChild());
		// delete the succ node (reason i delete before copying succ to toDelete is
		// because when we try to delete succ after replacing toDelete with succ the delete method will reach the current
		// toDelete before it reaches succ, and thus will try to delete the same node twice)
		delete(succ);
		// one way to replace a node with another is to copy the relevant data and keep
		// the children
		toDelete.setKey(succ.getKey());
		toDelete.setHash(succ.getHash());
		toDelete.setCount(succ.getCount());
	}

	public BinarySearchTreeNode findMin(BinarySearchTreeNode current) {
		if (current.getLeftChild() == null) {
			return current;
		} else {
			return findMin(current.getLeftChild());
		}
	}
	
	

	// PRINTING METHODS
	public void print_Preorder() {
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			print_Preorder(root);
		}
	}

	private void print_Preorder(BinarySearchTreeNode n) {
		if (n == null) {
			return;
		}
		System.out.println(n.getKey() + " " + n.getCount() + " " + n.getHash());
		print_Preorder(n.getLeftChild());
		print_Preorder(n.getRightChild());
	}

	public void print_Inorder() {
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			print_Inorder(root);
		}
	}

	private void print_Inorder(BinarySearchTreeNode n) {
		if (n == null) {
			return;
		}
		print_Inorder(n.getLeftChild());
		System.out.println(n.getKey() + " " + n.getCount());
		print_Inorder(n.getRightChild());
	}

	public void print_Postorder() {
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			print_Postorder(root);
		}
	}

	private void print_Postorder(BinarySearchTreeNode n) {
		if (n == null) {
			return;
		}
		print_Postorder(n.getLeftChild());
		print_Postorder(n.getRightChild());
		System.out.println(n.getKey() + " " + n.getCount());
	}
	
	// just for my own use
	public void print_BreadthFirst() {
		ArrayList<BinarySearchTreeNode> queue = new ArrayList<BinarySearchTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				BinarySearchTreeNode n = queue.get(0);
				System.out.print(n.getKey() + " " + n.getHash() + "\t");
				queue.remove(0);
				if(n.getLeftChild() != null) {
					queue.add(n.getLeftChild());	
				}
				if(n.getRightChild() != null) {
					queue.add(n.getRightChild());
				}
				
			}
			System.out.println();
		}
		
	}

	// SETTERS AND GETTERS
	public BinarySearchTreeNode getRoot() {
		return root;
	}

	public void setRoot(BinarySearchTreeNode root) {
		this.root = root;
	}

}
