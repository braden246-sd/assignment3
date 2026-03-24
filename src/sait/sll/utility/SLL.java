/*
* Created by: Patrick Bouley, Braden Ouellet, Ian Vanderkley
* Date: March 24, 2026
*
* Description:
* This program implements a Singly Linked List (SLL) data structure
* using the LinkedListADT interface.
*
* Features:
* - Add elements to the beginning of the list (prepend)
* - Add elements to the end of the list (append)
* - Insert elements at a specific index
* - Replace elements at a given index
* - Remove elements from the list
* - Retrieve elements by index
* - Search for elements using indexOf and contains
* - Clear all elements from the list
* - Track and return the size of the list
*
* The linked list is composed of Node objects, where each node stores
* data and a reference to the next node in the sequence.
*
* The implementation uses a helper method (getNode) to simplify traversal
* and improve code readability.
*
* The list supports serialization, allowing the object and its contents
* to be saved and restored.
*
* All methods follow the requirements defined in the LinkedListADT interface.
*/

package sait.sll.utility;

import java.io.Serializable;

/**
 * Implements a singly linked list.
 */
public class SLL implements LinkedListADT, Serializable {
	private static final long serialVersionUID = 1L;
	private Node head;
	private int size;

	 /**
     * Constructs an empty singly linked list.
     */
	public SLL() { 
		this.head = null; 
		this.size = 0; 
	} 
	
	 /**
     * Checks if the list is empty.
     * @return true if the list contains no elements
     */
	@Override
	public boolean isEmpty() { 
		return size == 0; 
	}
	
    /**
     * Gets the number of elements in the list.
     * @return size of the list
     */	
	@Override
	public int size() { 
		return size;
	}
	 /**
     * Removes all elements from the list.
     */
	@Override
	public void clear() { 
		head = null; 
		size = 0; 
	}

	 /**
     * Adds a new element at the beginning of the list.
     * @param data data to add
     */
	@Override
	public void prepend(Object data) { 
		Node newNode = new Node(data); 
		newNode.setNext(head); 
		head = newNode; 
		size++; 
	}
	/**
	* Adds a new element to the end of the list.
	* @param data data to add
	*/
	@Override
	public void append(Object data) { 
		Node newNode = new Node(data); 
		if (head == null) {  
			head = newNode; 
		}
		else {
			Node current = head;
			while (current.getNext() != null) { 
				current = current.getNext();
			}
			current.setNext(newNode); 
		}
		
		size++;  
	}
	
    /**
     * Helper method that returns the node at a specific index.
     * Used by insert, replace, delete, and retrieve.
     * @param index index of the node to find
     * @return node at the given index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
	protected Node getNode(int index) {
		if (index < 0 || index >= size) { 
			throw new IndexOutOfBoundsException();
		}
		Node current = head; 
		
		for (int i =0; i < index; i++) { 
			current = current.getNext();
		}
		return current; 
		
	}
	
    /**
     * Gets the data stored at the specified index.
     * @param index index of the element to retrieve
     * @return data stored at the index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
	
    @Override
    public Object retrieve(int index) {
    	Node node = getNode(index);
    	return node.getData();
    }

	/**
     * Inserts a new node at a specific position in the list.
     * @param data data to insert
     * @param index position to insert at
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    @Override
    public void insert(Object data, int index) {
    	if (index < 0 || index > size) { 
    		throw new IndexOutOfBoundsException(); 
   }
    	  if (index == 0) {  
    	        prepend(data);
    	        return;
    	    }

    	    Node newNode = new Node(data); 

    	    Node previous = getNode(index - 1); 
    	    newNode.setNext(previous.getNext()); 
    	    previous.setNext(newNode); 

    	    size++; 
    }
	
    /**
     * Replaces the data at a specific index.
     * @param data new data to store
     * @param index index of the element to replace
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    @Override
    public void replace(Object data, int index) { 
        Node node = getNode(index);
        node.setData(data);      
    }
	
    /**
     * Removes the node at a specific index.
     * @param index index of the element to delete
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) { 
            throw new IndexOutOfBoundsException(); 
        }

        if (index == 0) {
            head = head.getNext(); 
            size--; 
            return;
        }

        Node previous = getNode(index - 1); 
        Node toDelete = previous.getNext(); 

        previous.setNext(toDelete.getNext());
		
        size--; 
    }

    /**
     * Searches the list and returns the index of matching data.
     * @param data data to search for
     * @return index of the matching element, or -1 if not found
     */
    @Override
    public int indexOf(Object data) {
        Node current = head; 
        int index = 0; 

		while (current !=null) {
	        if ((current.getData() == null && data == null) ||
				(current.getData() != null && current.getData().equals(data))) {
				return index;
			}
		
            current = current.getNext(); 
            index++;
		}

        return -1 ; 
    }
    /**
     * Checks if the list contains a specific value.
     * @param data data to search for
     * @return true if the value exists in the list
     */
    @Override
    public boolean contains(Object data) {
        return indexOf(data) != -1;
    }
}



