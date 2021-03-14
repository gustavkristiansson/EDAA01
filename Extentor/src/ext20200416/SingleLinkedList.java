package ext20200416;

public class SingleLinkedList<E> {
	private Node<E> first;
	private Node<E> last;
	private int size;
	
	public SingleLinkedList() {
		first = last = null;
		size = 0;
	}
	
	
	public void clear() {
		first = last = null;
		size = 0;
	}
	
	public void clearN(int n) {
		if(n < 0) {
			throw new IllegalArgumentException();
		}
		if(size < n) {
			first = last = null;
		} else {
			for(int i = 0; i < n; i++) {
				first = first.next;
				size--;
			}
		}
	}
	
	public void merge(SingleLinkedList<E> l, int pos) {
		if(pos < 0 || pos > size) {
			throw new IllegalArgumentException();
		}
		if(l.first == null) {
			return;
		}
		if(size == 0) {
			first = l.first;
			last = l.last;
		} else if(pos == 0) {
			l.last.next = first;
			first = l.first;
		} else if(pos == size){
			last.next = l.first;
			last = l.last;
		} else {
			Node<E> pre = first;
			
			for(int i = 0; i < pos - 1; i++) {
				pre = pre.next;
			}
		
			l.last.next = pre.next;
			pre.next = l.first;
		}
		size += l.size;
		l.clear();
	}
		
	
	
	

	
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		private Node(E element) {
		this.element = element;
		next = null;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
