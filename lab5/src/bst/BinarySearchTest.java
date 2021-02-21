package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
	private BinarySearchTree<String> myStringTree;
	private BinarySearchTree<Integer> myIntTree;
	private BinarySearchTree<Integer> my2ndIntTree;
	

	@BeforeEach
	void setUp() throws Exception {
		myStringTree = new BinarySearchTree<String>();
		myIntTree = new BinarySearchTree<Integer>();
		
		my2ndIntTree = new BinarySearchTree<Integer>((e1, e2) -> e2.compareTo(e1));
	}

	@AfterEach
	void tearDown() throws Exception {
		myStringTree = null;
		myIntTree = null;
	}
	
	@Test
	void testHeight() {
		myIntTree.add(15);
		myIntTree.add(24);
		myIntTree.add(78);
		myIntTree.add(10);
		myIntTree.add(3);
		assertTrue(myIntTree.height() == 3);
	}

	@Test
	void testHeightEmpty() {
		assertTrue((myIntTree.height() == 0), "Wrong result from empty tree");
		assertEquals(0, myIntTree.height(), "Wrong height from empty tree");
	}
	
	@Test
	void testSizeEmpty() {
		assertTrue((myIntTree.size()) == 0, "Wrong result from empty tree");
		assertEquals(0, myIntTree.size, "Wrong size from empty tree");
	}
	
	@Test
	void testAddStrings() {
		assertTrue(myStringTree.add("Hejsan"));
		assertTrue(myStringTree.add("Hoppsan"));
		assertTrue(myStringTree.add("Tester"));
		assertTrue((myStringTree.size() == 3), "Wrong height size result from tree");
	}
	
	@Test
	void testAddInts() {
		assertTrue(myIntTree.add(23));
		assertTrue(myIntTree.add(42));
		assertTrue(myIntTree.add(15));
		assertTrue(myIntTree.add(28));
		assertTrue((myIntTree.size() == 4), "Wrong size size result from tree");
		assertTrue((myIntTree.height() == 3), "Wrong height result from tree");
	}
	
	@Test
	void testAddSame() {
		assertTrue(myIntTree.add(24));
		assertFalse(myIntTree.add(24));
	}
	
	@Test
	void testSize() {
		myIntTree.add(27);
		myIntTree.add(42);
		myIntTree.add(15);
		myIntTree.add(28);
		assertTrue(myIntTree.size() == 4, "Wrong size of tree");
	}
	
	@Test
	void testClear() {
		my2ndIntTree.add(23);
		my2ndIntTree.add(25);
		my2ndIntTree.add(19);
		my2ndIntTree.clear(); 
		assertTrue(my2ndIntTree.size() == 0);
		assertTrue(my2ndIntTree.height() == 0);
	}
}
