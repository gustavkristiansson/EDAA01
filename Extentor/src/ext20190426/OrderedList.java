package ext20190426;

public class OrderedList<E extends Comparable<E>> {
	private ListNode<E> first;
	
	public OrderedList() {
		first = null;
	}
	
	public void deleteDuplicates() {
		if(first != null) {
			ListNode<E> pre = first;
			ListNode<E> curr = first.next;
			while(curr != null) {
				if(pre.element.equals(curr.element)) {
					pre.next = curr.next;	
				}
				pre = curr;
				curr = curr.next;
			}
		}
	}
	
	
	/** Returns the element in the middle of this list.
		@return the element in the middle */
	public E middleVal() {
		if(first != null) {
			ListNode<E> middle = first;
			ListNode<E> last = first.next;
			
			while(last != null && last.next != null) {
				middle = middle.next;
				last = last.next.next;
			}
			return middle.element;
 		}	
		return null;
	}
	
	
	
	
	private static class ListNode<E> {
		private E element;
		private ListNode<E> next;
		
		public ListNode(E e) {
			this.element = e;
			next = null;
		}
	}
	

}
