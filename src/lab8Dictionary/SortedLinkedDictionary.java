package lab8Dictionary;

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
    	// to implement
    }
    
    public int getSize() {
    	return numberOfEntries;
    }
    
    public void clear() {
    	// to implement
    }
    
    public boolean isEmpty () {
    	// to implement
    }
    
    public boolean contains (K aKey) {
    	// to implement
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
    	// to implement
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
    	// to implement
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
