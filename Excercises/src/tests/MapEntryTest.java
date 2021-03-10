package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapEntryTest {
	

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Hejsan", 1);
		map.put("Hoppsan", 2);
		map.put("Hej", 3);
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(entrySet);
		list.sort((e1, e2) -> e1.getValue() - e2.getValue());
		
		System.out.println(list);

	}

}