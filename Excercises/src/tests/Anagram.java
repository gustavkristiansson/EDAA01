package tests;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Anagram {
	private Map<String, Set<String>> anagrams;
	
	/** Skapar ett objekt som hanterar anagram. */
	public Anagram() {
		anagrams = new HashMap<String, Set<String>>();
	}

	public void add(String word) {
	    String sorted = alphabetize(word);
	    
	    Set<String> set = anagrams.get(sorted);
	    
	    if(set == null) {
	    	set = new HashSet<String>();
	    	anagrams.put(sorted, set);
	    }
		set.add(word);
	}

    /** Returnerar en mängd med alla ord som är anagram till 
        ordet word. Mängdens iterator ska leverera orden i
        i stigande alfabetisk ordning. word ska inte ingå i mängden.
	    Om word inte har några insatta anagram ska en tom mängd 
	    returneras. */
	public Set<String> getAnagramsOf(String word) {
		Set<String> set = anagrams.get(alphabetize(word));
		
		if(set !=  null) {
			set = new HashSet<String>(set);
			set.remove(word);
		} else {
			set = new HashSet<String>();
		}
	    
	    Set<String> sortedSet = new TreeSet<String>(set);
	    
	    return sortedSet;
	}
	
	

    /** Returnerar en sträng med bokstäverna i word sorterade i 
        bokstavsordning. */
    private String alphabetize(String word) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < word.length(); i++) {
			StringBuilder temp = new StringBuilder();
			temp.append(word.charAt(i));
			list.add(temp.toString());
		}
		Collator collator = Collator.getInstance(new Locale("sv", "se"));
		Collections.sort(list, collator);
		StringBuilder b = new StringBuilder();
		for (String s : list) {
			b.append(s);
		}
		return b.toString();
	}
    
	public static void main(String[] args) {
		Anagram anagram = new Anagram();
		
		anagram.add("avig");
		
		anagram.add("viga");
		
		anagram.getAnagramsOf("giva");
		
		System.out.println(anagram.getAnagramsOf("giva"));
	
	} 
}