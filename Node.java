
public class Node {
	
	private int value;
	private int key;
	private Node next;
	private Node prev;
	
	//default constructor
	public Node()
	{
		this.value = 0;
		this.key = 0;
		setNext(null);
		setPrev(null);
	}
	
	//constructor
	public Node(int key, int value)
	{
		this.key = key;
		this.value = value;
		setNext(null);
		setPrev(null);
	}
	
	//GETTERS
	public int getValue() {
		return value;
	}
	
	public int getKey() {
		return key;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}
	
	//SETTERS

	public void setValue(int value) {
		this.value = value;
	}
	
	public void setKey(int key) {
		this.key = key;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	

}
