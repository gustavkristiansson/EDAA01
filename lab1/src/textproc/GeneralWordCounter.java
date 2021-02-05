package textproc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor {
	private Set<String> stopwords = new HashSet<String>();
	private Map<String, Integer> wordFreq;
	
	public GeneralWordCounter(Set<String> stopwords) {
		wordFreq = new TreeMap<String, Integer>();
		this.stopwords = stopwords;	
	}
	
	public void process(String w) {
		if (!stopwords.contains(w)) {
			if(wordFreq.containsKey(w)) {
				wordFreq.put(w, wordFreq.get(w) + 1);
			}
			else wordFreq.put(w, 1);
		}	
	}

	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = wordFreq.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort(new WordCountComparator());
		
		for(int i = 0; i < 15; i++) {
			System.out.println(wordList.get(i));
		}
		//for(String key : m.keySet()) {
		//	if(m.get(key) >= 200) System.out.println(key + ": " + m.get(key));
		//}
	}
	
	public List<Map.Entry<String, Integer>> getWordList() {
		return new ArrayList<Map.Entry<String, Integer>>(wordFreq.entrySet());
	}
}
