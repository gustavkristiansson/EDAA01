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
		table = (Entry<K, V>[]) new Entry[capacity];
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
//		for(int i = 0; i < capacity; i++) {
//			sb.append(i + " " + table[i].toString());
//		}
		return sb.toString();
	}

	@Override
	public V get(Object obj) {
		K key = (K) obj;
		Entry<K, V> e = table[index(key)];
		
		while(e != null) {
			if(e.key.equals(key)) {
				return e.getValue();
			}
			e = e.next;
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
		
		if((double) size/(double) capacity >= 0.75) {
			rehash();
		}
		
		if(e == null) {
			table[index(key)] = new Entry<K, V>(key, value);
		} else {
			while(e.next != null && e.key.equals(key)) {
				e = e.next;
			}
			
			if(e.key.equals(key)) {
				V oldValue = e.getValue();
				e.value = value;
				return oldValue;
			} else {
				e.next = new Entry<K, V>(key, value);
			}
		}
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	private int index(K key) {
		return Math.abs(key.hashCode() % capacity);
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
		Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[table.length * 2];
		Entry<K, V>[] oldTable = table;
		table = newTable;
		
		for(int i = 0; i < oldTable.length; i++) {
			Entry<K, V> entry = oldTable[i];
			
			if(entry != null) {
				while(entry.next != null) {
					put(entry.getKey(), entry.getValue());
					entry = entry.next;
				}
			put(entry.getKey(), entry.getValue());
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
