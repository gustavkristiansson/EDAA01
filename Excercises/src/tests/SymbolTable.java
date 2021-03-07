package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class SymbolTable<E> {
	private Map<String, E> map;
	
	public SymbolTable() {
		map = new HashMap<String, E>();
	}
	
	public void addSymbol(String symbol, E value) {
		map.put(symbol, value);
	}
	
	public E getValue(String symbol) {
		E value = map.get(symbol);
		if(value == null) {
			throw new NoSuchElementException("value");
		} 
		return value;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Set<Map.Entry<String, E>> set = map.entrySet();
		
		for(Map.Entry<String, E> s : set) {
			E value = s.getValue();
			sb.append(s.getKey() + " " + value + "\n");
		}
		return sb.toString();	
	}
	
	public static void main(String args[]) {
		SymbolTable<Boolean> st = new SymbolTable<Boolean>();
		st.addSymbol("a", true);
		st.addSymbol("b", true);
		st.addSymbol("c", false);
		st.addSymbol("d", true);
		System.out.println(st);
	}
}
