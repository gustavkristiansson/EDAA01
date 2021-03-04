package map;

import java.util.Random;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] table;
	private int size = 0;
	
	/** 
	 * Constructs an empty hashmap with de default initial capacity [16] 
	 * and the default load factor of 0.75.	
	 */
	public SimpleHashMap() {
		table = (Entry<K, V>[]) new Entry[16];
	}
	
	/**
	 * Constructs an empty hashmap with the specified initial capacity and the
	 * default load factor (0.75).
	 */
	public SimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[capacity];
	}
	
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> map = new SimpleHashMap(10);
		
		final int n = 10;
		
		Random random = new Random();
		
		for(int i = 0; i < n; i++) {
			int x = random.nextInt(2000) - 500; 
			map.put(x, x);
		}
		
		System.out.println(map.show());
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				sb.append(i + "   " + table[i].toString());
				Entry<K, V> temp = table[i];
				
				while (temp.next != null) {
					sb.append(" " + temp.next.toString());
					temp = temp.next;
				}
				
				sb.append("\n");
			} else {
				sb.append(i + "   null\n");
			}
		}
		return sb.toString();
	}

	@Override
	public V get(Object key) {
		Entry<K, V> entry = find(index((K) key), (K) key);
		
		if(entry != null) {	
			return entry.value;
		} 
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> e = find(index(key), key);
		
		if(e == null){
			e = table[index(key)];
			
			if(e == null){
				table[index(key)] = new Entry<K,V>(key, value);
			}else{
				while(e.next != null) {
					e = e.next;	
				}
				e.next = new Entry<K,V>(key, value);
			}
		}else {
			V old_value = e.value;
			e.value = value;
			return old_value;
		}
		
		size++;
		
		if((double) size/(double) table.length >= 0.75) {
			rehash();
		}
		
		return null;
	}

	@Override
	public V remove(Object obj) {
		K key = (K) obj;
		int index = index(key);
		
		Entry<K, V> entry = table[index];
		
		while(entry != null) {
			if(entry.key.equals(key)) {
				table[index] = entry.next;
				size--;
				return entry.value;
			} else if(entry.next != null && entry.next.key.equals(key)) {
				V value = entry.next.value;
				entry.next = entry.next.next;
				size--;
				return value;
			}
			entry = entry.next;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % table.length);
	}
	
	private Entry<K, V> find(int index, K key) {
		Entry<K, V> entry = table[index];
		
		while(entry != null) {
			if(entry.getKey().equals(key)) {
				return entry;
			}
			entry = entry.next;
		}
		return null;	
	}
	
	private void rehash() {
		size = 0;
		Entry<K, V>[] tempTable = (Entry<K, V>[]) new Entry[table.length * 2];
		Entry<K, V>[] oldTable = table;
		table = tempTable;
		
		for(int i = 0; i < oldTable.length; i++) {
			Entry<K, V> temp = oldTable[i];

			if(temp != null) {
				while(temp.next != null) {
					put(temp.getKey(), temp.getValue());
					temp = temp.next;
				}
				put(temp.getKey(), temp.getValue());
			}
		}
		oldTable = null;
	}
 	
	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		} 

		@Override
		public V setValue(V value) {
			this.value = value;
			return value;
		}
		
		@Override
		public String toString() {
			return key + " = " + value;
		}
	}
}
