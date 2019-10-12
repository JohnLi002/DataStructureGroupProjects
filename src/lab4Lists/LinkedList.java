package lab4Lists;

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
		firstNode = null;
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
	
	private class Node {
		private T data;
		private Node next;

		public Node( ) {
			this (null);
		}
		public Node(T anEntry) {
			data = anEntry;
			next = null;
		}

		public void setData (T dataPortion) {
			data = dataPortion;
		}
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
