package ext20200416;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMap {
	private Map<Book, Map<Integer, Integer>> bookMap;
	private static final int MAX_RATING = 5;
	
	
	public BookMap() {
		bookMap = new HashMap<>();
	}
	
	public void add(Book b) {
		Map<Integer, Integer> m = bookMap.get(b);
		if(b == null) {
			bookMap.put(b, new HashMap<Integer, Integer>());
		} else {
			bookMap.put(b, m);
		}
	}
	
	public void addRating(Book b, int i) {
		Map<Integer,Integer> m = bookMap.get(b);
		
		Integer rating = m.get(i);
		if(rating == null) {
			m.put(i, 1);
		} else {
			m.put(i, rating + 1);
		}
	}
	
	public int getRatings(Book b, int i) {
		return bookMap.get(b).get(i);
	}
	
	public double getMid(Book b) {
		Map<Integer,Integer> m = bookMap.get(b);
		
		double sum = 0;
		
		double nbrGrades = 0;
		
		for(Map.Entry<Integer, Integer> e : m.entrySet()) {
			sum += (double)e.getValue();
			nbrGrades++;
		}
		
		return sum / nbrGrades;
	}
	
	
	
	
	
	
	
	

}
