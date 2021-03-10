package ext20180406;

public class SingleLinkedList<E> {
	private ListNode<E> first;
	
	public SingleLinkedList() {
		first = null;
	}
	
	
	public int removeAllOccurencies(E e) {
		ListNode<E> p = first;
		ListNode<E> pre = null;
		
		int i = 0;
		while(p != null) {
			if(p.element.equals(e)) {
				if(pre == null) {
					first = first.next;
				} else {
					pre.next = p.next;
				}
				i++;
			} else {
				pre = p;
			}
			p = p.next;
		}
		return i;
	}
	
	
	private static class ListNode<E> {
		private E element;
		private ListNode<E> next;
		
		
		public ListNode(E e){
			element = e;
			next = null;
		}
	}
}
