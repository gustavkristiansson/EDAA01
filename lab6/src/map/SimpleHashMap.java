package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	private int size = 0;
	private int capacity = 10;
	
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
		this.capacity = capacity;
		table = (Entry<K, V>[]) new Entry[capacity];
	}
	
	public static void main(String[] args) {
		SimpleHashMap<Integer, Integer> map = new SimpleHashMap();
		
		final int n = 10;
		
		java.util.Random random = new java.util.Random();
		
		for(int i = 0; i < n; i++) {
			int x = random.nextInt(15) - 5; 
			map.put(x, x);
		}
		
		System.out.println(map.show());
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		
		Entry<K, V> entry = null;
		for(int i = 0; i < capacity; i++) {
			sb.append(i);
			sb.append("\t");
			
			entry = table[i];
			while(entry != null) {
				sb.append(entry);
				entry = entry.next;
			}
			sb.append("\n");	
		}
		return sb.toString();
	}

	@Override
	public V get(Object obj) {
		K key = (K) obj;
		Entry<K, V> entry = find(index(key), key);
		
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
		
			
		if(e == null) {
			table[index(key)] = new Entry<K, V>(key, value);
		} else {
			while(e.next != null && !e.getKey().equals(key)) {
				e = e.next;
			}
			
			if(e.key.equals(key)) {
				V oldValue = e.getValue();
				e.setValue(value);
				if(((double) size/(double) capacity) >= 0.75) {
					rehash();
				}
				return oldValue;
			} else {
				e.next = new Entry<K, V>(key, value);
			}
		}
		
		size++;
		
		if(((double) size/(double) capacity) >= 0.75) {
			rehash();
		}
		
		return null;
	}

	@Override
	public V remove(Object obj) {
		
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
		Entry<K, V>[] tempTable = (Entry<K, V>[]) new Entry[table.length * 2]; 
		size = 0;
		
		Entry<K, V>[] oldTable = table;
		
		table = tempTable;
		
		Entry<K, V> temp = null;
		
		for(int i = 0; i < oldTable.length; i++) {
				temp = oldTable[i];
			
			if(temp != null) {
				while(temp.next != null) {
					put(temp.getKey(), temp.getValue());
					temp = temp.next;
				}
				put(temp.getKey(), temp.getValue());
			}
		}
	}
		
		
		
//		int oldCap = capacity;
//		
//		
//		capacity*=2;
//		
//		
//		
//		
//		
//		Entry<K, V> entry = null;
//		for(int i = 0; i < oldCap; i++) {
//			entry = oldTable[i];
//			
//			while(entry != null) {
//				put(entry.getKey(), entry.getValue());
//				entry = entry.next;
//			}
//		}
//		oldTable = null;
//	}
 	
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
