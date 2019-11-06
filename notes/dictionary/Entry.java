package dictionary;

public class Entry<K,V> {
	private K key;
	private V value;
	
	//constructor
	
	public Entry(K newKey, V newValue) {
		// TODO Auto-generated constructor stub
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
