package testqueue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

class TestAppendFifoQueue {
	private FifoQueue<Integer> IntQ1;
	private FifoQueue<Integer> IntQ2;

	@BeforeEach
	void setUp() throws Exception {
		IntQ1 = new FifoQueue<Integer>();
		IntQ2 = new FifoQueue<Integer>();
	}

	@AfterEach
	void tearDown() throws Exception {
		IntQ1 = null;
		IntQ2 = null;
	}
	
	/**
	 * Test if two empty Queues are concatenated.
	 */
	@Test
	void testAppendTwoEmpty() {
		IntQ1.append(IntQ2);
		assertTrue(IntQ1.isEmpty() && IntQ2.isEmpty(), "Cannot append empty queue");
	}
	
	
	/**
	 * Test concatenation of two non-empty Queues.
	 */
	@Test
	void testAppend() {
		IntQ1.offer(1);
		IntQ1.offer(2);
		IntQ1.offer(3);
		IntQ2.offer(4);
		IntQ2.offer(5);
		IntQ2.offer(6);
		IntQ1.append(IntQ2);
		assertTrue(IntQ2.size() == 0, "Queue not empty after append");
		assertTrue(IntQ1.size() == 6);
	}
	
	/**
	 * Test concatenation of empty Queue to non-empty Queue.
	 */
	@Test
	void testAppendEmptyToNonEmpty() {
		IntQ1.offer(1);
		IntQ1.append(IntQ2);
		assertTrue(IntQ1.size() == 1);
		assertTrue(IntQ2.size() == 0, "Queue appended not empty");
	}
	
	/**
	 * Test concatenation of non-empty Queue to empty Queue.
	 */
	@Test
	void testAppendToEmpty() {
		IntQ1.offer(1);
		IntQ1.offer(2);
		IntQ1.offer(3);
		IntQ2.append(IntQ1);
		assertTrue(IntQ1.size() == 0, "Queue appended not empty" );
		assertTrue(IntQ2.size() == 3);
	}
	
	/**
	 * Test concatenation of the same Queue.
	 */
	@Test
	void testAppendToSelf() {
		assertArrayEquals("Cannot append to self", IntQ1, IntQ1);
	}
	

}
