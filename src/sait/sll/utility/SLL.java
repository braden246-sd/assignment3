package sait.sll.utility;
import java.io.Serializable;
//SLL = singly linked list
public class SLL implements LinkedListADT, Serializable {
	private Node head;
	private int size;
	
	public SLL() { //constructor to create an empty linked list 
		this.head = null; //first node in the linked list (null means the list is empty)
		this.size = 0; //list starts with size oif 0
	} 
	
	@Override
	public boolean isEmpty() { //returns TRUE if list has no elements 
		return size == 0; //if size is 0, list is empty
	}
	
	@Override
	public int size() { //returns how mny elements are in the list 
		return size;
		
	}
	
	@Override
	public void clear() { //removes all elements from the list 
		head = null; //removes all nodes
		size = 0; //resets size to 0 
	}
	
	@Override
	public void prepend(Object data) { //adds a new element at the beginning of the list
		Node newNode = new Node(data); //creates a new node holding the data
		newNode.setNext(head); //new node points to the old first node 
		head = newNode; //new node becomes the first node 
		size++; // increase the list size by 1 
	}
	
	@Override
	public void append(Object data) { // adds a new element to the end of the list 
		Node newNode = new Node(data); //create a new node
		if (head == null) { //if the list is empty 
			head = newNode; //new node becomes the first node
		}
		else { //start at the first node 
			Node current = head;
			while (current.getNext() != null) { //move thru the list until we reach the last node 
				current = current.getNext();
			}
			current.setNext(newNode); //attach the new node at the end 
		}
		
		size++; //increase size by 1 
	}
	
	//helper method retunrs the node at a specific spot
	//should be used by insert replace delete and retrieve 
	protected Node getNode(int index) {
		if (index < 0 || index >= size) { //if the index is outside the valid range thows an error
			throw new IndexOutOfBoundsException();
		}
		Node current = head; //Start at the first Node
		//move forward 'index' times to reach the correct node 
		for (int i =0; i < index; i++) { 
			current = current.getNext();
		}
		return current; //return the node we found 
		
	}
    @Override
    public Object retrieve(int index) {
        //get the node at the index
    	Node node = getNode(index);
    	return node.getData();
    }
	
	//NEXT METHODS (NOT DONE YET) these are just place holders so the code compiles for my stuff 
    @Override
    public void insert(Object data, int index) {
        throw new UnsupportedOperationException(); // Will implement later
    }

    @Override
    public void replace(Object data, int index) {
        throw new UnsupportedOperationException(); // Will implement later
    }

    @Override
    public void delete(int index) {
        throw new UnsupportedOperationException(); // Will implement later
    }



    @Override
    public int indexOf(Object data) {
        throw new UnsupportedOperationException(); // Will implement later
    }

    @Override
    public boolean contains(Object data) {
        throw new UnsupportedOperationException(); // Will implement later
    }
}



