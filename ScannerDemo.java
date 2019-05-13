package documentScanner;

public class ScannerDemo {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		System.out.println("///");
		bst.print_Preorder();
		System.out.println("///");
		bst.print_Inorder();
		System.out.println("///");
		bst.print_Postorder();
		bst.insert("Hej");
		bst.insert("Abc");
		bst.insert("Jag");
		bst.insert("Makaroner");
		
		System.out.println(bst.findMin(bst.getRoot()).getKey());
		
		BinarySearchTreeNode n = bst.search("Hej");
		if(n == null) {
			System.out.println("oh no, null");
		}
		else {
			System.out.println(n.getKey() + " " + n.getHash() + " " + n.getCount());
		}
		
		n = bst.findParent("Makaroner");
		if(n == null) {
			System.out.println("oh no, null");
		}
		else {
			System.out.println(n.getKey() + " " + n.getHash() + " " + n.getCount());
		}
		
		System.out.println("///");
		bst.print_Preorder();
		System.out.println("///");
		bst.print_Inorder();
		System.out.println("///");
		bst.print_Postorder();
		
		bst.insert("Mig");
		bst.insert("Hej");
		
		System.out.println("///");
		bst.print_Preorder();
		System.out.println("///");
		bst.print_Inorder();
		System.out.println("///");
		bst.print_Postorder();
		
	}
}
