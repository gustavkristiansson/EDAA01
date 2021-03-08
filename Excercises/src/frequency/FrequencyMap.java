package frequency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FrequencyMap<E> implements Frequency<E> {
	private Map<E, Integer> map;
	
	public FrequencyMap() {
		map = new HashMap<E, Integer>();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Ökar antal förekomster av e med nbr.
	 */
	@Override
	public void incNbr(E e, int nbr) {
		Integer s = map.get(e);
		if(s == null) {
			map.put(e, nbr);
		} else {
			map.put(e, nbr + s);
		}
	}

	/**
	 * Returnerar antalet förekomster av e.
	 */
	@Override
	public int getNbr(E e) {
		Integer s = map.get(e);
		if(s == null) {
			return 0;
		} else {
			return s;
		}
	}

	@Override
	public Set<E> elements(int min, int max) {
		Set<E> returnSet = new HashSet<E>();
		for(Map.Entry<E, Integer> e : map.entrySet()) {
			if(e.getValue() >= min && e.getValue() <= max) {
				returnSet.add(e.getKey());
			}
		}
		return returnSet;
	}
}
