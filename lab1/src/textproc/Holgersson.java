package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {
	
	public static final Set<String> stopwords = new HashSet<String>();

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		List<TextProcessor> textList = new ArrayList<TextProcessor>();
		
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		
		while(scan.hasNext()) {
			String word = scan.next();
			stopwords.add(word);
		}
		scan.close();
		
		TextProcessor n = new SingleWordCounter("nils");
		TextProcessor o = new SingleWordCounter("norge");
		TextProcessor m = new MultiWordCounter(REGIONS);
		TextProcessor r = new GeneralWordCounter(stopwords);
		
		textList.addAll(Arrays.asList(n, o, m, r));
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			
			textList.forEach(v -> v.process(word));
		}
		s.close();
		
		textList.forEach(v -> v.report());
	}
}