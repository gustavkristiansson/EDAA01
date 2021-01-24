package textproc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
	private Set<String> stopwords = new HashSet<String>();
	private Map<String, Integer> m = new TreeMap<String, Integer>();
	
	public GeneralWordCounter(Set<String> stopwords) {
		this.stopwords = stopwords;	
	}
	
	public void process(String w) {
		if (!stopwords.contains(w)) {
			if(m.containsKey(w)) {
				m.put(w, m.get(w) + 1);
			}
			else m.put(w, 0);
		}	
	}

	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = m.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		
		for(int i = 0; i < 15; i++) {
			System.out.println(wordList.get(i));
		}
		//for(String key : m.keySet()) {
		//	if(m.get(key) >= 200) System.out.println(key + ": " + m.get(key));
		//}
	}
}
