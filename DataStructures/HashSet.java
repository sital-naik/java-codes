package com.learning.collection;

import java.util.Iterator;

public class HashSet<K> implements Iterable<K>{
	
	private HashMap<K, String> map;
	
	public HashSet() {
		map = new HashMap<>();
	}

	public int size() {
		return map.getSize();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public boolean contains(K value) {
		return map.contains(value);
	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>() {
			Iterator<HashMap<K, String>.Entry> iterator = map.entrySet().iterator();
			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public K next() {
				return iterator.next().getKey();
			}
		};
	}

	public void add(K value) {
		map.put(value, "");
	}

	public boolean remove(K o) {
		
		return false;
	}

	public void clear() {
		map = new HashMap<>();
	}

}
