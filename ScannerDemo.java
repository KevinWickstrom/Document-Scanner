package documentScanner;

public class ScannerDemo {

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert("Hej");
		bst.insert("Abc");
		bst.insert("Jag");
		bst.insert("Makaroner");
		
		
		System.out.println("Min: " + bst.findMin(bst.getRoot()).getKey());
		
		BinarySearchTreeNode n = bst.search("Hej");
		/*if(n == null) {
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
		}*/
		
		System.out.println("Printing preorder:");
		bst.print_Preorder();
		System.out.println("///Preorder done///");

		bst.insert("Mig");
		bst.insert("Hej");
		System.out.println("Printing preorder:");
		bst.print_Preorder();
		System.out.println("///Preorder done///");
		bst.delete("Hej");
		System.out.println("Printing preorder:");
		bst.print_Preorder();
		System.out.println("///Preorder done///");

		bst.delete("afasdpkjdas");
		System.out.println("///");
		bst.print_Preorder();
		bst.delete("Abc");
		System.out.println("///");
		bst.print_Preorder();
		bst.delete("Makaroner");
		System.out.println("///");
		bst.print_Preorder();
		bst.delete("Mig");
		System.out.println("///");
		bst.print_Preorder();
		System.out.println("///");

		
	}
}
