package textproc;

import java.util.Map;
import java.util.HashMap;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> m = new HashMap<String, Integer>();
	
	public MultiWordCounter(String[] words) {
		for(String word : words) {
			m.put(word, 0);
		}
		for(String key : m.keySet()) {
			process(key);	
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
