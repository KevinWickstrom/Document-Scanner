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
		
		System.out.println("Printing breadth first1");
		bst.print_BreadthFirst();

		bst.insert("Mig");
		System.out.println("Printing breadth first2");
		bst.print_BreadthFirst();
		bst.insert("Hej");
		
		
		System.out.println("Printing breadth first3");
		bst.print_BreadthFirst();
		bst.delete("afasdpkjdas");
		bst.delete("Hej");
		System.out.println("Printing breadth first4");
		bst.print_BreadthFirst();
		bst.delete("Abc");
		System.out.println("Printing breadth first5");
		bst.print_BreadthFirst();
		bst.delete("Makaroner");
		System.out.println("Printing breadth first6");
		bst.print_BreadthFirst();
		bst.delete("Mig");
		System.out.println("Printing breadth first7");
		bst.print_BreadthFirst();
		
		

		
	}
}
