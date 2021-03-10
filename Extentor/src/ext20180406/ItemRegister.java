package ext20180406;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class ItemRegister {
	Map<Item, PriorityQueue<Bid>> map;
	
	
	public ItemRegister() {
		map = new HashMap<> ();
	}
	
	public boolean addItem(Item item) {
		if(map.containsKey(item)) {
			return false;
		} else {
			PriorityQueue<Bid> q = new PriorityQueue<>((b1, b2) -> b2.getAmount() - b1.getAmount());
			map.put(item, q);
			return true;
		}
	}
	
	
	public void addBid(Item item, Bid bid) {
		if(!map.containsKey(item)) {
			throw new NoSuchElementException();
		} else {
			map.get(item).add(bid);
		}
	}
	
	public Bid getHighestBid(Item item) {
		if(map.containsKey(item)) {
			return map.get(item).peek();
		} else {
		throw new NoSuchElementException();
		}
	}
}

