package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFileChooser;

public class BookReaderApplication {
	private static final Set<String> stopwords = new HashSet<String>();
	private static String text = "nilsholg.txt";
	
	private static void scanStopWords() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		while(scan.hasNext()) {
			String word = scan.next();
			stopwords.add(word);
		}
		scan.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		scanStopWords();
		
		JFileChooser fileChooser = new JFileChooser("");
		fileChooser.showDialog(null, "Choose file");
		File file = fileChooser.getSelectedFile();
		
		GeneralWordCounter counter = new GeneralWordCounter(stopwords);
		
		List<TextProcessor> textList = new ArrayList<TextProcessor>();		
		textList.add(counter);	
		
//		Scanner s = new Scanner(new File(text));
		Scanner s = new Scanner(file);
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			textList.forEach(v -> v.process(word));
		}
		s.close();
		
		BookReaderController controller = new BookReaderController(counter);
	}
}
