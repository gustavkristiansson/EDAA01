package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	
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
	

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V put(K arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V value) {
			this.value = value;
			return this.value;
		}
		
		@Override
		public String toString() {
			return this.key + " = " + this.value;
		}
	}
}
