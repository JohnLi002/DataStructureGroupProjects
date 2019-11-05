package lab7DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements ListInterface<T>, Iterable <T> {
	private DoubleNode head;
	private DoubleNode tail;
	private int numberOfEntries;

	public DoublyLinkedList(){
		numberOfEntries = 0;
		head = null;
		tail = null;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIteratorForDList();
	}

	@Override
	public void add(T newEntry) {
		DoubleNode n = new DoubleNode(newEntry);
		if(numberOfEntries == 0) {
			head = n; //set both head and tail to new node
			tail = head;
		} else {
			n.setPrev(tail);
			tail.setNext(n);
			tail = n;
		}
		numberOfEntries++;
	}

	@Override
	public void add(int newPosition, T newEntry) {
		DoubleNode add = new DoubleNode(newEntry);
		if(newPosition < 0 || newPosition >= numberOfEntries) {
			throw new IndexOutOfBoundsException();
		} else if(newPosition == 0) {
			add.setNext(head);
			head.setPrev(add);
			head = add;
			numberOfEntries++;
			return;
		} else if(newPosition == numberOfEntries - 1) {
			add.setPrev(tail);
			tail.setNext(add);
			tail = add;
			numberOfEntries++;
			return;
		}
		DoubleNode n = head;
		for(int i = 0; i < newPosition - 1; i++) {
			n = n.getNext();
		}
		add.setNext(n.getNext());
		n.setNext(add);
		add.setPrev(n);
		numberOfEntries++;
	}

	@Override
	public T remove(int givenPosition) {
		if(!(isEmpty())) { // all to make sure that the list is not empty
			throw new IndexOutOfBoundsException();
		} else if(givenPosition < 0 || givenPosition >= numberOfEntries) { //make sure correct positions given: 6 entry = position 0-5
			throw new IndexOutOfBoundsException();
		} else if(givenPosition == 0) { //in case the position is at the very beginning
			T data = head.getData();
			head = head.getNext();
			head.setPrev(null);
			numberOfEntries--;
			return data;
		} else if(givenPosition == numberOfEntries-1) { // in case the right entry is at the very end
			T data = tail.getData(); //record tail data
			tail = tail.getPrev(); //moves the tail node one forward
			tail.setNext(null); //set the previous one as null
			numberOfEntries--;
			return data;
		}
		
		DoubleNode n = head;
		
		for(int i = 0; i < givenPosition; i++) { //loops to the right node at the correct position
			n = n.getNext();
		}
		T item = n.getData(); //records the data at the current node which will be returned
		n = n.getPrev(); //goes back one node because the current node is what will be removed
		n.setNext(n.getNext().getNext()); //sets the new previous node to the node before the next one (aka it skips over the node
		                                  //after the next one
		n.getNext().setPrev(n); //the new previous node has the wrong next node, replace it with the new one
		numberOfEntries--;//decrease entries
		return item;
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
		if(!(isEmpty())) { //checks if it is even possible to use given position
			throw new IndexOutOfBoundsException();
		} else if(givenPosition < 0 || givenPosition >= numberOfEntries) { //if position too small or too big
			throw new IndexOutOfBoundsException();
		}
		
		DoubleNode n = head;
		for(int i = 0; i < givenPosition; i++) { //finds correct node location
			n = n.getNext();
		}
		T data = n.getData(); //record old data
		n.setData(newEntry); //replace with new data
		return data;
	}

	@Override
	public T getEntry(int givenPosition) {
		if(!(isEmpty())) {
			throw new IndexOutOfBoundsException();
		} else if(givenPosition < 0 || givenPosition >= numberOfEntries) {
			throw new IndexOutOfBoundsException();
		} 

		DoubleNode n = head;

		for(int i = 0; i < givenPosition; i++) {
			n = n.getNext();
		}

		return n.getData();
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
		for(DoubleNode n = head; !isEmpty() && n.getNext() != null; n = n.getNext()) {
			//if the first node is not empty and the previous node isn't empty as well, the loop will continue
			if(head.getData().equals(anEntry)) {
				return true;
			}
		}
		return false; //entry was never found
	}

	@Override
	public Object[] toArray() {
		int size = getLength();
		DoubleNode n = head;
		Object[] result = new Object[size];
		
		for(int i = 0; i < size; i++) {
			result[i] = n.getData();
			n = n.getNext();
		}
		
		return result;
	}

	private class ListIteratorForDList implements ListIterator<T>, Iterator<T>{
		private DoubleNode nextNode; //first / current node
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
			prevNode = nextNode.getPrev();
			
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
				prevNode = nextNode.getPrev();
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
			return prevNode != null;
		}

		@Override
		public int nextIndex() {
			if(nextNode == null) {
				return index;
			}
			return index+1;
		}

		@Override
		public int previousIndex() {
			if(prevNode == null) {
				return index;
			}
			return index-1;
		}
	}

	private class DoubleNode {
		private T data;
		private DoubleNode next;
		private DoubleNode prev;

		public DoubleNode(T entry) {
			data = entry;
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
