package ext20180312;

import java.util.Comparator;

public class ListPriorityQueue<E> implements SimplePriorityQueue<E> {
	private Node<E> first;
	Comparator<E> comp;
	
	
	public ListPriorityQueue(Comparator<E> comp) {
		first = null;
		this.comp = comp;
	}

	@Override
	public void insert(E e) {
		Node<E> n = new Node<E>(e);
		if(first == null || comp.compare(e, first.element) < 0) {
			n.next = first;
			first = n;
		} else {
			Node<E> n2 = new Node<E>(e);
			while(n2.next != null && comp.compare(e, n2.next.element) > 0) {
				n2 = n2.next;
			}
			n.next = n2.next;
			n2.next = n;
		}
	}

	@Override
	public E poll() {
		if(first == null) {
			return null;
		} else {
			E e = first.element;
			first = first.next;
			return e;
		}
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}
	
	public static void main(String[] args) {
		
	}
	
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		private Node(E e) {
			element = e;
			next = null;
		}
	}
}
