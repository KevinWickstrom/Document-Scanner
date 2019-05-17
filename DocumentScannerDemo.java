package documentScanner;
import java.io.*;

public class DocumentScannerDemo {

	public static void main(String[] args) throws IOException{
		DocumentScanner test = new DocumentScanner();
		
		test.scanDocument();
		
		test.printInorder();
		test.printMaxWord();
		test.search("she");
	}

}
