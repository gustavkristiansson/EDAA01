package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		List<TextProcessor> textList = new ArrayList<TextProcessor>();
		
		TextProcessor p = new SingleWordCounter("nils");
		TextProcessor j = new SingleWordCounter("norge");
		TextProcessor r = new MultiWordCounter(REGIONS);
		
		textList.addAll(Arrays.asList(p, j, r));
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		for(TextProcessor text : textList) {
			while (s.hasNext()) {
				String word = s.next().toLowerCase();
				text.process(word);
			}
			text.report();
		}
		
		//s.close();
	
		

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			p.process(word);
			j.process(word);
			r.process(word);
		}

		s.close();

		p.report();
		j.report();
		r.report();
	}
}