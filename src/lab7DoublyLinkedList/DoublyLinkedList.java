package lab7DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements ListInterface<T>, Iterable <T> {

	private DoubleNode head;
	private DoubleNode tail;
	private int numberOfEntries;

	@Override
	public Iterator <T> iterator () {
		return new ListIteratorForDList();
	}


	public DoublyLinkedList(){
		numberOfEntries = 0;
		head = null;
		tail = null;
	}

	@Override
	public void add(T newEntry) {
		DoubleNode n = new DoubleNode(newEntry);
		
		if(head == null && tail == null) {
			head = tail = n; //set both head and tail to new node
		} else {
			n.setNext(tail);
			tail.setPrev(n);
			tail = tail.getPrev();
		}
	}

	@Override
	public void add(int newPosition, T newEntry) {
		for(int i = 0; i < newPosition; i++) {
			
		}

	}

	@Override
	public T remove(int givenPosition) {
		if(!(isEmpty())) {
			throw new IndexOutOfBoundsException();
		} else if(givenPosition < 0 || givenPosition >= numberOfEntries) {
			throw new IndexOutOfBoundsException();
		} else if(givenPosition == 0) {
			head = head.getPrev();
			head.setNext(null);
		} 
		DoubleNode n = head;
		for(int i = 0; i < givenPosition - 1; i++) {
			n = n.getPrev();
		}
		
		n = n.setNext(n.getNext().getNext());
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		if(!contains(anEntry)) {
			return false;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		numberOfEntries = 0; 
		head = null; //set both head and tail to num
		tail = null;
		//is it okay to use head = tail = null? this does the same exact thing
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
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries != 0);
	}

	@Override
	public boolean contains(T anEntry) {
		for(DoubleNode n = head; !isEmpty() && n.getPrev() != null; n = n.getPrev()) {
			//if the first node is not empty and the previous node isn't empty as well, the loop will continue
			if(head.getData().equals(anEntry)) {
				return true;
			}
		}
		return false; //entry was never found
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	private class ListIteratorForDList implements ListIterator<T>, Iterator<T>{
		private DoubleNode nextNode;
		private DoubleNode prevNode;
		private int index;

		public ListIteratorForDList() {
			nextNode = head;
			index = 0;
		}

		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}

			T item = nextNode.getData();
			nextNode = nextNode.getNext();
			return item;
		}

		public boolean hasNext() {
			return nextNode != null;
		}

		public void add(T entry) {
			DoubleNode insert = new DoubleNode(entry);
			insert.setNext(nextNode);
			nextNode.setPrev(insert);
			if(nextNode != head){
				DoubleNode prevNode = nextNode.getPrev();
			}
			prevNode.setNext(insert);
		}

		public T previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(nextNode == null) {
				nextNode = tail;
			} else {
				nextNode = nextNode.getPrev();
			}
			return nextNode.getData();
		}

		public boolean hasPrevious() {
			return nextNode != head;
		}

		@Override
		public int nextIndex() {
			return index+1;
		}

		@Override
		public int previousIndex() {
			return index-1;
		}


	}
	private class DoubleNode {
		private T data;
		private DoubleNode next;
		private DoubleNode prev;

		public DoubleNode(T entry) {
			T data = entry;
		}
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