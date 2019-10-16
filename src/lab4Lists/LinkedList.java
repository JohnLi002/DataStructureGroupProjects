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
		Node toInsert = new Node(newEntry);
		if(isEmpty()) {
			firstNode = toInsert;
		} else {
			Node curr = firstNode;
			while(curr.getNext() != null) {
				curr = curr.getNext();
			}
			curr.setNext(toInsert);
		}
		numberOfEntries++;
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
	public T remove (int givenPosition){
		if (isEmpty()) {
			throw new NullPointerException();
		} 
		if (givenPosition < 0 || givenPosition >= getLength()) {
			throw new IndexOutOfBoundsException();
		}
		T dataItem = firstNode.getData();
		numberOfEntries--;
		if (givenPosition == 0)
			firstNode = firstNode.getNext();
		else {
			int idx = 0;
			Node nextNode = firstNode;
			for (Node currNode = firstNode; nextNode != null; currNode = nextNode) {
				idx ++;
				nextNode = currNode.getNext();
				if (idx == givenPosition ){ // nextNode is to be removed 
					assert (nextNode != null);
					dataItem = nextNode.getData();
					currNode.setNext(nextNode.getNext());
					break;
				} 
			}
		}
		return dataItem;
	}

	@Override
	public boolean remove(T anEntry) {
		if(numberOfEntries == 0) {
			throw new NullPointerException();
		}
		if(firstNode.getData().equals(anEntry)) {
			firstNode = firstNode.getNext();
			return true;
		}
		Node nextNode = firstNode;
		
		for (Node currNode = firstNode; nextNode != null; currNode = nextNode) {
			nextNode = currNode.getNext();
			if (nextNode.getData().equals(anEntry)){ // nextNode is to be removed 
				assert (nextNode != null);
				currNode.setNext(nextNode.getNext());
				numberOfEntries--;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}

	@Override
	public T replace(int givenPosition, T newEntry) { //is the positions 0 - 1 - 2 or 1 - 2 - 3
		Node current = firstNode;

		for(int i = 0; i <= givenPosition; i++) {
			if(i == givenPosition) {
				T result = current.getData();
				current.setData(newEntry);
				return result;
			}

			current = current.getNext();
		}
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		Node current = firstNode;

		for(int i = 0; i < givenPosition; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	@Override
	public int getLength() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	@Override
	public boolean contains(T anEntry) {
		Node current = firstNode;
		while(current.getNext() != null) {
			if(firstNode.getData().equals(anEntry)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[numberOfEntries];

		for(int i = 0; i < getLength(); i++) {
			array[i] = getEntry(i);
		}
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
