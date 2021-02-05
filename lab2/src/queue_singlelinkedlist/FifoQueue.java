package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode<E> x = new QueueNode<E>(e);
		if(size != 0) {
			x.next = last.next;
			last.next = x;
		} else {
			x.next = x;
		}
		last = x;
		size++;
		return true;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {	
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if(size == 0) {
			return null;
		} 
		return last.next.element;
	}
	

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if(size == 0) {
			return null;
		} 
		QueueNode<E> x = last.next;
		last.next = x.next;
		size--;
		return x.element;
	}
	
	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * to this queue. The specified queue (q) is empty after the call.
	 * @param q the queue to append
	 * @throws IllegalArgumentException if this queue and q are identical
	 */
	public void append(FifoQueue<E> q) {
		if(this == q) {
			throw new IllegalArgumentException("Cannot append Queue to self.");
		}
		if(size == 0) {
			size = q.size();
			last = q.last;
			//last.next = q.last.next;
		} else if(q.size() != 0) {
			QueueNode<E> temp = q.last.next;
			for(int i = 0; i < q.size(); i++) {
				QueueNode<E> n = new QueueNode<E>(temp.element);
				n.next = last.next;
				last.next = n;
				last = n;
				temp = temp.next;
				size++;
			}	
		}
		q.size = 0;
		q.last = null;
		
//		this.addAll(q);
//		q.clear();
		
//		while(q.size() != 0) {
//			offer(q.poll());
//		}
	}
	
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int x;
		
		/**Constructor*/
		private QueueIterator() {
			pos = last;
			x = 1;
		}
		
		public boolean hasNext() {
			return pos != null && x <= size;
		}
		
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			} 	
			E element = pos.next.element;
			pos = pos.next;
			x++;
			return element;
		}
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			this.element = x;
			next = null;
		}
	}
}
