package ext20190318;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ratings {
	private Map<String, List<Integer>> map;
	
	public Ratings() {
		map = new HashMap<String, List<Integer>>();
	}
	
	private void addRate(String name, int rating) {
		List<Integer> list = map.get(name);
		if(list == null) {
			list = new ArrayList<Integer>();
			map.put(name, list);
		} 
		list.add(rating);
	}
	
	public double averageRating(String name) {
		List<Integer> list = map.get(name);
		if(list == null) {
			return 0;
		}
		double score = 0.0;
		for(int i : list) {
			score += (double) i;
		}
		return score / list.size();
	}
	
	public Map<String, Double> allAverageRatings() {
		Map<String, Double> temp = new HashMap<String, Double>();
		
		for(String s : map.keySet()) {
			temp.put(s, averageRating(s));
		}
		return temp;
	}

}
