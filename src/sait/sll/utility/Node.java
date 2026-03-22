package sait.sll.utility;
import java.io.Serializable;

/**
 * Represents a node in a singly linked list.
 * Stores data and a reference to the next node.
 */

public class Node implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Object data;
	private Node next;
	
	public Node(Object data) {
		this.data = data;
		this.next = null; //null because every new node starts out with no connection to any other node
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	

	
	
	
}
