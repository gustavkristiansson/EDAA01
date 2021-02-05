package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {
	private static String text = "nilsholg.txt";
	public static final Set<String> stopwords = new HashSet<String>();
	
	public static void scanStopWords() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		while(scan.hasNext()) {
			String word = scan.next();
			stopwords.add(word);
		}
		scan.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		scanStopWords();
		
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		BookReaderController controller = new BookReaderController(counter);
		
		List<TextProcessor> textList = new ArrayList<TextProcessor>();
				
		textList.add(counter);		
		
		Scanner s = new Scanner(new File(text));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			textList.forEach(v -> v.process(word));
		}
		s.close();
	}

}
