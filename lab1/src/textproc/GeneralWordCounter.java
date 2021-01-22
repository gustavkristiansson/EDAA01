package textproc;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {
	Set<String> stopwords = new HashSet<String>();
	
	public GeneralWordCounter(Set<String> exceptions) {
		
		//TODO 
	}
	
	public void readExceptions() {
		Scanner scan = new Scanner(new File("undantagsord.txt"));
			while(scan.hasNext()) {
				String word = scan.next();
				stopwords.add(word);
			}
		scan.close();
	}
	
	public void process(String w) {
		// TODO Auto-generated method stub
		
	}

	public void report() {
		// TODO Auto-generated method stub
		
	}
	 
			


}
