package sortedList;

import list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {

	private Node firstNode;
	private int numberOfEntries;

	public LinkedList() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public void add(T newEntry) {
		numberOfEntries++;
		Node toInsert = new Node(newEntry);
		if(isEmpty()) {
			firstNode = toInsert;
		}
		else {
			Node curr = firstNode;
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(toInsert);
		}

	}

	@Override
	public void add(int newPosition, T newEntry) {
		if(newPosition < 0 || newPosition > numberOfEntries) {
			throw new IndexOutOfBoundsException();
		}
		numberOfEntries++;
		Node toInsert = new Node(newEntry);
		if(newPosition == 0) {
			toInsert.setNext(firstNode);
			firstNode = toInsert;
		}
		else {
			Node before = getNodeAt(newPosition-1);
			assert(before!=null);

			Node after = before.getNext();
			before.setNext(toInsert);
			toInsert.setNext(after);
		}
	}

	private Node getNodeAt(int position) {
		int count = 0;
		Node curr = firstNode;
		
		while(count < position) {
			curr = curr.getNext();
			count++;
		}
		
		return curr;
	}

	@Override
	public T remove(int givenPosition) {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		if(givenPosition < 0 || givenPosition >= numberOfEntries) {
			throw new IndexOutOfBoundsException();
		}
		
		T item;
		if(givenPosition == 0) {
			item = firstNode.getData();
			firstNode = firstNode.getNext();
		} else {
			Node before = getNodeAt(givenPosition - 1);
			Node current = before.getNext();
			item = current.getData();
			before.setNext(current.getNext());
		}
		numberOfEntries--;
		return item;
	}

	@Override
	public boolean remove(T anEntry) {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		Node prevNode = null;
		Node currNode = firstNode;
		while(currNode != null) {
			if(anEntry.equals(currNode.getData())) {
				if(prevNode == null) {
					firstNode = firstNode.getNext();
				} else {
					prevNode.setNext(currNode.getNext());
				}
				numberOfEntries--;
				return true;
			} else {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
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
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null);
	}

	@Override
	public boolean contains(T anEntry) {
		Node current = firstNode;
		while(current.getNext() != null) {
			if(current.getData().equals(anEntry)) {
				return true;
			} else {
				current = current.getNext();
			}
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
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




