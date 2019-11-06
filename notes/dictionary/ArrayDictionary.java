package dictionary;

import java.util.Arrays;

public class ArrayDictionary<K, V> implements DictionaryInterface<K,V>{
	private Entry<K,V>[] entries; 
	private int numberOfEntries;
	private int capacity;
	private final static int DEFAULT_CAPACITY = 10;
	private boolean initialized = false;
	
	public ArrayDictionary(int capacity) {
		this.capacity = capacity;
		numberOfEntries = 0;
		entries = new Entry<K,V>[capacity];
		initialized = true;
	}
	
	public ArrayDictionary() {
		this(DEFAULT_CAPACITY);
	}
	
	public int locatePosition(K key) {
		int idx = 0;
		while(idx < numberOfEntries) {
			if(key.equals(entries[idx].getKey())){
				break;
			}
		}
		return idx;
	}
	
	public void checKInitialization() {
		if(!initialized) {
			throw new SecurityException();
		}
	}
	
	private void ensureCapacity() {
		if(numberOfEntries == capacity) {
			capacity *= 2;;
		}
		entries = Arrays.copyOf(entries, capacity);
	}
	
	public V add(K newKey, V newValue) {
		int index = locatePosition(newKey);
		entries[numberOfEntries++] = new Entry(newKey, newValue);
		ensureCapacity();
		
		if(index < numberOfEntries) {
			V oldValue = entries[index].getValue();
			entries[index].setValue(newValue);
			return oldValue;
		}
		Entry<K,V> newEntry = new Entry(newKey,newValue);
		entries[numberOfEntries++] = new Entry(newKey,newValue);
		ensureCapacity();
		return null;
	}
	
	public V remove(K aKey) {
		int index = locatePosition(aKey);
		if(index == numberOfEntries) {
			return null;
		}
		V oldValue = entries[index].getValue();
		entries[index] = entries[numberOfEntries-1];
		entries[--numberOfEntries] = null;
		return oldValue;
	}
}
