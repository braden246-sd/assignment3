package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;


class LinkedListTests {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}
	
	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("c", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("b", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("a", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.insert("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}
	
	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.replace("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.delete(2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
	}
	
	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}
	
// Create our tests below here to try for the new methods we created in the SLL file
	
	@Test
	void testInsertAtBeginning() {
		this.linkedList.append("d");
		this.linkedList.append("c");
	    this.linkedList.append("b");
	    this.linkedList.insert("a", 0);

	    /**
	     * Linked list should now be:
	     * 
	     * a -> d -> c -> b
	     */

	    assertEquals("a", this.linkedList.retrieve(0));
	    assertEquals("d", this.linkedList.retrieve(1));
	    assertEquals("c", this.linkedList.retrieve(2));
	    assertEquals("b", this.linkedList.retrieve(3));
	}
		/**
	 * Tests inserting an element at the end of the list using the insert method.
	 * Verifies that the element is placed at the correct position and that
	 * the list size updates correctly.
	 */
	@Test
	void testInsertAtEnd() {
	    this.linkedList.append("a");
	    this.linkedList.append("b");
	    this.linkedList.append("c");

	    this.linkedList.insert("d", 3);

	    // Verify correct order after insertion
	    assertEquals("a", this.linkedList.retrieve(0));
	    assertEquals("b", this.linkedList.retrieve(1));
	    assertEquals("c", this.linkedList.retrieve(2));
	    assertEquals("d", this.linkedList.retrieve(3));

	    // Verify size increased
	    assertEquals(4, this.linkedList.size());
	}

	/**
	 * Tests deleting the first node (head) of the list.
	 * Verifies that the head is updated correctly and the list shifts left.
	 */
	@Test
	void testDeleteFirstNode() {
	    this.linkedList.append("a");
	    this.linkedList.append("b");
	    this.linkedList.append("c");

	    this.linkedList.delete(0);

	    // Verify first element is removed and list shifts
	    assertEquals("b", this.linkedList.retrieve(0));
	    assertEquals("c", this.linkedList.retrieve(1));

	    // Verify size decreased
	    assertEquals(2, this.linkedList.size());
	}

	/**
	 * Tests deleting the last node (tail) of the list.
	 * Verifies that the last element is removed and the list size updates.
	 */
	@Test
	void testDeleteLastNode() {
	    this.linkedList.append("a");
	    this.linkedList.append("b");
	    this.linkedList.append("c");

	    this.linkedList.delete(2);

	    // Verify last element is removed
	    assertEquals("a", this.linkedList.retrieve(0));
	    assertEquals("b", this.linkedList.retrieve(1));

	    // Verify size decreased
	    assertEquals(2, this.linkedList.size());
	}

	/**
	 * Tests clearing the entire list.
	 * Verifies that all elements are removed, the list is empty,
	 * and the size is reset to zero.
	 */
	@Test
	void testClearList() {
	    this.linkedList.append("a");
	    this.linkedList.append("b");
	    this.linkedList.append("c");

	    this.linkedList.clear();

	    // Verify list is empty
	    assertTrue(this.linkedList.isEmpty());

	    // Verify size reset
	    assertEquals(0, this.linkedList.size());
	}
}
