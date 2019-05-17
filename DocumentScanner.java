package documentScanner;
import java.util.*;
import java.io.*;

//Class done by Kevin

public class DocumentScanner {
	private BinarySearchTree bst;
	
	//Constructor
	public DocumentScanner() {
		bst = new BinarySearchTree();
	}
	
	//Scans text file and creates BST
	public void scanDocument() throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Please import a file to build a binary tree.");
		String fileName = scan.next();
		Scanner infile = new Scanner(new File(fileName));
		
		while (infile.hasNext()) {
			bst.insert(infile.next());
		}
		scan.close();
		infile.close();
	}
	
	//Finds the count of a specific word
	public void search(String word) {
		BinarySearchTreeNode target = bst.search(word);
		System.out.println(word + " count: " + target.getCount());
	}
	
	//Prints the word with the most occurrences and its count
	public void printMaxWord() {
		BinarySearchTreeNode target = findMax(bst.getRoot());
		System.out.println("Word: " + target.getKey() + "\n" + "Count: " + target.getCount());
	}
	
	//Finds the node that has the highest count (helper)
	private BinarySearchTreeNode findMax(BinarySearchTreeNode target) { 
        if (target == null) 
            return new BinarySearchTreeNode(); 
  
        BinarySearchTreeNode leftChildMax = findMax(target.getLeftChild()); 
        BinarySearchTreeNode rightChildMax = findMax(target.getRightChild()); 
  
        if (leftChildMax.getCount() > target.getCount()) 
            target = leftChildMax; 
        if (rightChildMax.getCount() > target.getCount()) 
        	target = rightChildMax; 
        return target; 
    } 
	
	//Different prints
	public void printPreorder() {
		bst.print_Preorder();
	}
	
	public void printInorder() {
		bst.print_Inorder();
	}
	
	public void printPostorder() {
		bst.print_Postorder();
	}
}
