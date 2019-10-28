package iterator;

import java.util.NoSuchElementException;

public class LinkedList<T> implements ListInterface<T>, Iterable<T>{

	private Node firstNode;
	private int numberOfEntries;
	
	@Override
	public Iterator<T> iterator(){
		return new IteratorForLinkedList();
	}

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class IteratorForLinkedList implements Iterator<T> {
		private Node nextNode;
		private Node currNode = null;
		private Node prevNode = null;
		private boolean nextWasCalled = false;
		
		public IteratorForLinkedList() {
			if(firstNode == null) {
				throw new IllegalStateException();
			}
			nextNode = firstNode;
		}

		
		@Override
		public boolean hasNext() {
			return (nextNode != null);
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T item  = nextNode.getData();
			nextNode = nextNode.getNext();
			prevNode = currNode;
			currNode = nextNode;
			nextNode = nextNode.getNext();
			return item;
			
		}

		@Override
		public void remove() {
			// throw new UnsupportedOperatorionException();
			
			if(!nextWasCalled) {
				throw new IllegalStateException("illgal call to remove without next");
			}
			
			nextWasCalled = false;
			if(prevNode == null)
				firstNode = nextNode;
			else {
				prevNode.setNext(nextNode);
				numberOfEntries--;
			}
			currNode = prevNode;
		}
	}
	
	private class Node {
		private T data;
		private Node next;

//		*Never used
//	
//		public Node() {
//			this (null);
//		}
		
		public Node(T anEntry) {
			data = anEntry;
			next = null;
		}
		
		
//		*Never Used
//		
//		public void setData (T dataPortion) {
//			data = dataPortion;
//		}
		public T getData (){
			return data;
		}
		
		public void setNext(Node nextNode){
			next = nextNode;
		}
		
		public Node getNext() {
			return next;
		}
	}

}
