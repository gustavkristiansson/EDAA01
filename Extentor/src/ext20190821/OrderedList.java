package ext20190821;

public class OrderedList<E extends Comparable<E>> {
	private ListNode<E> first;
	
	public OrderedList() {
		first = null;
	}
	
	public void add(E e) {
		ListNode<E> n = new ListNode<E>(e);
		if(first == null) {
			first = n;
		} 
		
		if(first.next == null) {
			if(first.element.compareTo(e) >= 0) {
				n.next = first;
				first = n;
			} else {
				first.next = n;
			}
		}
		else {
			ListNode<E> curr = first;
			
			while(curr.next != null) {
				if(curr.next.element.compareTo(e) >= 0) {
					n.next = curr.next;
					curr.next = n;
					return;
				}
				curr = curr.next;
			}
			curr.next = n;
		}
	}
	
	public E peek() {
		if(first != null) {
			return first.element;
		}
		return null;
	}
	
	public E poll() {
		if(first == null) {
			return null;
		}
		E temp = first.element;
		first = first.next;
		return temp;	
	}
	
	
	private static class ListNode<E> {
		private E element;
		private ListNode<E> next;
		
		private ListNode(E e) {
			element = e;
			next = null;
		}	
	}
}
