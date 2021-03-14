package ext20200115;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Largest<E> {
	private PriorityQueue<E> q;
	private Comparator<E> comp;
	private int k;
	
	public Largest(Comparator<E> comp, int k) {
		if(k < 0) {
			throw new IllegalArgumentException();
		}
		this.k = k;
		this.comp = comp;
		q = new PriorityQueue(comp);	
	}
	
	/**
	* Adds the element e if it belongs to the k largest.
	* @param e element that may be added
	*/
	public void add(E e) {
		if(k > q.size()) {
			q.offer(e);
		} else {
			if(comp.compare(e, q.peek()) > 0) {
				q.poll();
				q.offer(e);
			}	
		}
	}
	
	/**
	* Returns a list of the k largest elements.
	* The list can contain fewer than k elements if k elements have not yet been added.
	* @returns a list of the k largest elements
	*/
	public List<E> largest() {
		List<E> list = new ArrayList<>();

		for(E e : list) {
			list.add(e);
		}
		
		return list;
	}
	
	
	
	public static void main(String[] args) {
		Largest<Integer> maxHeap = new Largest<>((i1, i2) -> i1.compareTo(i2), 1000);
		Largest<Integer> minHeap = new Largest<>(((i1, i2) -> i2.compareTo(i1)), 1000);
	}
}
