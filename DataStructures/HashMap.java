package com.learning.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class HashMap<K, V> {

	public class Entry {
		private int hash;
		private K key;
		private V value;

		Entry(K key, V value) {
			this.key = key;
			this.hash = key.hashCode();
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "(key = " + key + ", value = " + value + ")";
		}

	}
	
	public class EntrySet implements Iterable<Entry>{

		public int size() {
			return size;
		}

		public Iterator<HashMap<K, V>.Entry> iterator() {
			return new Iterator<Entry>() {
				
				LinkedList<Entry> entryList;
				LinkedList<Entry>.Node curr;
				int index = 0;
				int next = size,expectedSize = size;
				
				@Override
				public boolean hasNext() {
					return next-- != 0;
				}

				@Override
				public Entry next() {
					if(expectedSize != size) {
						throw new ConcurrentModificationException();
					}
					return getNextEntry();
				}
				
				private Entry getNextEntry() {
					if(curr == null) {
						do{
							entryList = entrylistArr[index];
						}while(entrylistArr[index++] == null);
						curr = entryList.getfirst();
					}else {
						curr = curr.getNext();
					}
					return curr == null ? getNextEntry(): curr.getValue();
				}
				
			};
		}
		
	}
	

	private LinkedList<Entry>[] entrylistArr;
	private int size = 0, capacity = 16;
	private float loadFactor = 0.75f;
	private EntrySet entrySet;
	

	@SuppressWarnings("unchecked")
	public HashMap() {
		entrylistArr = new LinkedList[capacity];
	}
	
	public int getSize() {
		return size;
	}

	public EntrySet entrySet() {
		return entrySet==null? entrySet = new EntrySet() : entrySet;
	}

	private boolean isOverloaded() {
		return size > capacity * loadFactor;
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		size = 0;
		capacity = capacity * 2;
		LinkedList<Entry>[] new_entrylistArr = new LinkedList[capacity];
		LinkedList<Entry> entryList;
		for (int i = 0; i < entrylistArr.length; i++) {
			entryList = entrylistArr[i];
			if (entryList != null) {
				for (Entry entry : entryList) {
					putVal(new_entrylistArr, entry);
				}
			}
		}
		entrylistArr = new_entrylistArr;
	}

	private int findIndex(int hash) {
		return hash & (capacity - 1);
	}

	public void put(K key, V value) {
		if (isOverloaded()) {
			rehash();
		}
		Entry entry = new Entry(key, value);
		putVal(entrylistArr, entry);
	}

	private void putVal(LinkedList<Entry>[] arr, Entry entry) {
		K key = entry.key;
		int hash = entry.hash;
		int index = findIndex(hash);
		LinkedList<Entry> entryList = arr[index];
		if (entryList == null) {
			entryList = new LinkedList<>();
			arr[index] = entryList;
		}
		for (Entry en : entryList) {
			if (en.key.equals(key)) {
				en.value = entry.value;
				return;
			}
		}
		entryList.add(entry);
		size++;
	}

	public V get(K key) {
		int hash = key.hashCode();
		int index = findIndex(hash);
		LinkedList<Entry> tempList = entrylistArr[index];
		for (Entry en : tempList) {
			if (en.key.equals(key)) {
				return en.value;
			}
		}
		return null;
	}

	public boolean contains(K key) {
		int hash = key.hashCode();
		int index = findIndex(hash);
		LinkedList<Entry> tempList = entrylistArr[index];
		for (Entry en : tempList) {
			if (en.key.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

}
