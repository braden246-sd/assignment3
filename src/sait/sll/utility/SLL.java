package sait.sll.utility;
import java.io.Serializable;
//SLL = singly linked list
public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;
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
	
	
    @Override
    // adds a new node at a specific position in the list
    public void insert(Object data, int index) {
    	if (index < 0 || index > size) { // this should check if the index is outside the valid range
    		throw new IndexOutOfBoundsException(); // is this the exception we want to use for all of them?
   }
    	  if (index == 0) { //if we are inserting at the begining, we can reuse the prepend function from earlier 
    	        prepend(data);
    	        return;
    	    }

    	    Node newNode = new Node(data); // This should hold the data

    	    Node previous = getNode(index - 1); // this finds the node before the insert position 
    	    newNode.setNext(previous.getNext()); // new node points to the nextr node in the list 
    	    previous.setNext(newNode); // this should make the previous node point to the new node

    	    size++; // increase list size by 1
    }

    @Override
    // This should replace the data at a specific index
    public void replace(Object data, int index) { 
        Node node = getNode(index);   // get the node at that index
        node.setData(data);           // update the data at that node
    }

    @Override
    // this will remove a node at a specific index
    public void delete(int index) {
        if (index < 0 || index >= size) { // make surte the index is in the valid range of our list
            throw new IndexOutOfBoundsException(); // repeated exception 
        }
        
        // If we want to remove the first node
        if (index == 0) {
            head = head.getNext(); // move the head to the next node
            size--; // reduce the list size
            return;
        }

        Node previous = getNode(index - 1); // find the node before the one we want to delete
        Node toDelete = previous.getNext(); // this will be the node we are removing 

        previous.setNext(toDelete.getNext());
        // This should skip the deleted node and reconnect the list again

        size--; // we have to reduce the list size when deleting 
    }


    @Override
    // This should search the list and return the index of matching data
    public int indexOf(Object data) {
        Node current = head; // start at the first node
        int index = 0; // should keep track of the position in the list

        // this should move through the list until it reaches the end
        while (current != null) {
            if (current.getData().equals(data)) { // checks if the data matches
                return index;
                // this should return the index where it found the data 
            }

            current = current.getNext(); // moves to the next node
            index++; // this should increase the index counter
        }

        return -1 ; // a placeholder for if data isnt found. it compiles wrong with a string so I just made it a negative number
    }

    @Override
    // checks if the list contains a specific value
    public boolean contains(Object data) {
        return indexOf(data) != -1;
        // if the index returns the data, return truw to confirm
    }
}



