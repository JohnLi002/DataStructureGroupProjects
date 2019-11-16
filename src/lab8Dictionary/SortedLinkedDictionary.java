package lab8Dictionary;
/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.util.Iterator;

public class SortedLinkedDictionary <K extends Comparable <? super K> , V> 
implements DictionaryInterface <K, V> {
	private DictNode head;
	private DictNode tail;
	private int numberOfEntries;

	public SortedLinkedDictionary () {
		head = null; 
		tail = null; 
		numberOfEntries = 0;
	}

	public V getValue (K key) {
		DictNode n = head;
		for(n = head; n != null; n = n.getNext()) {
			if(n.getKey().equals(key)) {
				return n.getValue();
			}
		}
		return null;
	}

	public int getSize() {
		return numberOfEntries;
	}

	public void clear() {
		head = null;
		tail = null;
		numberOfEntries = 0;
	}

	public boolean isEmpty () {
		return numberOfEntries == 0;
	}

	public boolean contains (K aKey) {
		DictNode n = head;
		for(n = head; n != null; n = n.getPrev()) {
			if(n.getKey().equals(aKey)) {
				return true;
			}
		}
		return false;
	}

	private DictNode getNodeAfterKey(K aKey) {
		DictNode curr = head;
		while (curr != null && aKey.compareTo (curr.getKey()) > 0)
			curr = curr.getNext();
		return curr;	
	}

	public V add (K newKey, V newValue ) {
		DictNode nodeAfter;	
		DictNode toAdd = new DictNode (newKey, newValue);

		if (isEmpty()) {
			head = tail = toAdd;
			numberOfEntries = 1;
			return null;
		}  

		nodeAfter = getNodeAfterKey(newKey); 

		if (null == nodeAfter) {
			tail.setNext (toAdd);
			toAdd.setPrev (tail);
			tail = toAdd;
		}
		else if (newKey.equals (nodeAfter.getKey())) {
			//System.out.println ("Replacing value for " + newKey);
					V oldValue = nodeAfter.getValue();
					nodeAfter.setValue(newValue);
					return oldValue;
		}	
		else if (nodeAfter == head) {
			toAdd.setNext(head);
			head.setPrev (toAdd);
			head = toAdd;
		}
		else {
			DictNode prevNode = nodeAfter.getPrev();
			prevNode.setNext(toAdd);
			toAdd.setPrev(prevNode);
			toAdd.setNext(nodeAfter);
			nodeAfter.setPrev(toAdd);
		}
		numberOfEntries ++;
		return null;	
	}


	public V remove (K aKey) {
		V result = null;
		
		if(!contains(aKey)) {
			return result;
		} else if(head.getKey().equals(aKey)) {
			result = head.getValue();
			head = head.getPrev();
			head.setNext(null);
		} else if(tail.getKey().equals(aKey)) {
			tail = tail.getNext();
			tail.setPrev(null);
		} else {
			DictNode n;
			for(n = head; n != null; n = n.getPrev()) {
				if(n.getKey().equals(aKey)) {
					result = n.getValue();
				}
			}
		}
		
		return result;

	}


	public Iterator <K> getKeyIterator () {
		return new KeyIteratorForLinkedDictionary ();
	}
	public Iterator <V> getValueIterator () {
		return new ValueIteratorForLinkedDictionary ();
	}
	private class KeyIteratorForLinkedDictionary implements Iterator <K> {
		private DictNode nextNode;

		public KeyIteratorForLinkedDictionary () {
			nextNode = head;
		}

		public boolean hasNext () {
			return (nextNode != null);
		}

		public K next() {
			if (!hasNext())
				throw new IllegalStateException ("Iteration after the list");
			K result = nextNode.getKey();
			nextNode = nextNode.getNext();
			return result;
		}

		public void remove ()  {
			throw new UnsupportedOperationException ("No remove in dictionary iterator");
		}
	}

	private class ValueIteratorForLinkedDictionary implements Iterator <V> {
		//to implement
		private DictNode nextNode;
		
		ValueIteratorForLinkedDictionary(){
			nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public V next() {
			if (!hasNext())
				throw new IllegalStateException ("Iteration after the list");
			V result = nextNode.getValue();
			nextNode = nextNode.getNext();
			return result;
		}
		
	}
	
	private class DictNode {
		private K key;
		private V value;
		private DictNode next;
		private DictNode prev;

		public DictNode (K newKey, V newValue) {
			key = newKey; value = newValue;
			next = null; prev = null;
		}

		public K getKey() { return key;}
		public V getValue() {return value;}
		public void setValue (V newValue) { value = newValue; }
		public DictNode getNext() {return next;}
		public DictNode getPrev() {return prev;}
		public void setNext (DictNode n) {next = n;}
		public void setPrev (DictNode p) {prev = p;}
	}

}
