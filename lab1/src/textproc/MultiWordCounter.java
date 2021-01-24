package textproc;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> m = new TreeMap<String, Integer>();
	
	public MultiWordCounter(String[] words) {
		for(String word : words) {
			m.put(word, 0);
		}
	}
	
	public void process(String w) {
		if(m.containsKey(w)) {
			Integer count = m.get(w);
			m.put(w, count + 1);
		}
	}

	public void report() {
		for(String key : m.keySet()) {
			System.out.println(key + ": " + m.get(key)); 
		}	
	}
}
