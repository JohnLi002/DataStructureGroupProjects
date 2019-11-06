package dictionary;

public class SortedLinkedDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {
	private DictNode head;
	private DictNode tail;
	private int numberOfEntries;

	public V add(K key, V value) {
		DictNode toAdd = new DictNode(key, value);
		if(isEmpty()) {
			head = toAdd;
			tail = toAdd;
			numberOfEntries = 1;
			return null;
		}
		DictNode after = getNodeAfter(key);
		if(key.equals(after.getKey())) {
			V oldValue = after.getValue();
			after.setValue(value);
			return oldValue;
		}
		if(after == head) {
			toAdd.setNext(head);
			head.setPrev(toAdd);
			head = toAdd;
		} else if(tail.getNext() == null) { //may or may not be dead code
			tail.setNext(toAdd);
			toAdd.setPrev(tail);
			tail = toAdd;
		} else {
			DictNode before = after.getPrev();
			before.setNext(toAdd);
			toAdd.setPrev(toAdd);
			toAdd.setNext(after);
			after.setPrev(toAdd);
		}
		numberOfEntries++;
		return null;
	}

	private boolean isEmpty() {
		return numberOfEntries == 0;
	}

	private DictNode getNodeAfter(K key) {
		DictNode curr = head;
		while(curr != null && key.compareTo(curr.getKey()) > 0) {
			curr = curr.getNext();
		}
		return curr;
	}

	private class DictNode {
		private K key;
		private V value;
		private DictNode next;
		private DictNode prev;

		public DictNode(K key2, V value2) {
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

		public DictNode getNext() {
			return next;
		}

		public void setNext(DictNode next) {
			this.next = next;
		}

		public DictNode getPrev() {
			return prev;
		}

		public void setPrev(DictNode prev) {
			this.prev = prev;
		}
	}
}