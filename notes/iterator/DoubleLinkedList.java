package iterator;

import java.util.NoSuchElementException;

import lab5CardLists.Card;
import lab5CardLists.DoubleNode;

public class DoubleLinkedList<T> implements ListInterface<T>, Iterable<T>{

	private DoubleNode head;
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
		private DoubleNode nextNode = head;
		private boolean nextWasCalled = false;
		
		public IteratorForLinkedList() {
			if(!nextWasCalled) {
				throw new IllegalStateException();
			}
			nextNode = nextNode.getNext();
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
			nextWasCalled = true;
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
			DoubleNode curr = nextNode.getNext();
		}
	}
	
	private class DoubleNode {
		private T data;
		private DoubleNode next;
		private DoubleNode prev;
		
		public T getData() {
			return data;
		}
		public void setData(T item) {
			data = item;
		}
		public DoubleNode getNext() {
			return next;
		}
		public void setNext(DoubleNode next) {
			this.next = next;
		}
		public DoubleNode getPrev() {
			return prev;
		}
		public void setPrev(DoubleNode prev) {
			this.prev = prev;
		}
	}

}
