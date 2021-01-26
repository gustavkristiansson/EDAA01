package tests;

public class QueueNode<E> {
	E element;
	QueueNode<E> next;
	
	public QueueNode(E element) {
		this.element = element;
		next = null;
	}
	

}
