package ext20200316;

public class SingleLinkedList<E> {
	private Node<E> first;
	private int size;
	
	
	public SingleLinkedList() {
		first = null;
		size = 0;
	}
	
	
	public String reversed() {
		StringBuilder sb = new StringBuilder();
		if(first != null) {
			reversed(first, sb);
			return sb.toString();
		} else {
			return "";
		}
	}
	
	private void reversed(Node<E> n, StringBuilder sb) {
		if(n != null) {
			reversed(n.next, sb);
			sb.append(n.element + "\n");	
		}	
	}
	
	public void add(E e) {
		Node<E> n = new Node<E>(e);
		
		if(first == null) {
			first = n;
			n.next = first.next;
		} else {
			Node<E> temp = first;
			while(temp != null) {
				temp = temp.next;
			}
			temp.next = n;
			n.next = null;
		}
		size++;
	}
	
	
	/**
	* Removes the element at the specified position in this list.
	* @param index the index of the element to be removed
	* @return the element that was removed from the list
	* @throws IndexOutOfBoundException if the index is out of range
	*/
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			E e = first.element;
			first = first.next;
			size--;
			return e;
		}
		Node<E> temp = first;
		
		for(int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		
		E e = temp.next.element;
		temp.next = temp.next.next;
		size--;
		return e;
	}
	
	public static <E> void reverse(E[] a) {
		reverse(a, 0, a.length - 1);
	}
	
	private static <E> void reverse(E[] a, int first, int last) {
		if(first < last) {
			swap(a, first, last);		
			reverse(a, first + 1, last - 1);	
		}
	}
	
	private static <E> void swap(E[] a, int first, int last) {
		E temp = a[first];
		a[first] = a[last];
		a[last] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[] {1,5,6,3,5,4};
		
//		for(int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
		reverse(a);
		
		
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
	}
	
	
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		private Node(E element) {
			this.element = element;
			next = null;
		}
	}
}
