package lab6SortedList;


abstract class LinkedChainBase <T>{
	private Node firstNode;
	private int numberOfEntries;
	//getFirstNode, addFirstNode, removeFirstNode
	//getAfterNode, addAfterNode, removeAfterNode
	//getNodeAt

	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	public T getEntry(int givenPosition) {
		if(givenPosition<0 || givenPosition>= getLength())
			throw new IndexOutOfBoundsException();
		Node n = firstNode;
		for(int i = 0; i < givenPosition; i++) {
			n = n.getNext();
		}
		return n.getData();
	}

	public boolean contains(T anEntry) {
		return false;
	}

	public void clear() {
		firstNode = null;
		numberOfEntries = 0;
	}


	protected void intializeDataFields() {
		firstNode = null;
		numberOfEntries = 0;
	}

	protected Node getFirstNode() {
		return firstNode;
	}

	protected void addFirstNode(Node n) {
		n.setNext(firstNode);
		firstNode = n;
		numberOfEntries++;
	}

	protected void removeFirstNode() {
		if(isEmpty()) {
			throw new NullPointerException("no remove from empty chain");
		}

		firstNode = firstNode.getNext();
		numberOfEntries--;
	}

	protected final void addAfterNode (Node currNode, Node afterNode) {
		afterNode.setNext (currNode.getNext());
		currNode.setNext (afterNode);
		numberOfEntries ++;
	}

	public Object[] toArray() {
		Object[] result = new Object[numberOfEntries];
		int position = 0;

		for(Node currNode = firstNode; currNode != null; currNode.equals(currNode.getNext())){
			currNode = currNode.getNext();
			result[position++] = currNode.getData();
		}
		return result;
	}

	public void add(T newEntry) {
		Node toAdd = new Node(newEntry);

		if(isEmpty()) {
			addFirstNode(toAdd);
		} else {
			//Node last = getNodeAt(getLength() - 1);
			addAfterNode(toAdd);
		}
	}

	private void addAfterNode(Node toAdd) {
		// TODO Auto-generated method stub

	}

	protected final Node getNodeAt (int position) {
		if (position < 0 || position >= numberOfEntries)
			throw new IndexOutOfBoundsException("searching outside the chain");
		Node currNode = getFirstNode();
		for (int pos = 0; pos < position; pos ++)
			currNode = currNode.getNext();
		return currNode;
	}


	public void replace(int position, T newEntry) {
		if(position<0 || position>= getLength())
			throw new IndexOutOfBoundsException();
		if(isEmpty() || position < 0 || position >= numberOfEntries) { //the positions are 0 - (numberOfEntries - 1)
			throw new NullPointerException("no remove from empty chain");
		}

		Node n = firstNode;
		for(int ii = 0; ii < position; position++) {
			n = n.getNext();
		}

		n.setData(newEntry);

	}



	protected int getLength() {
		return numberOfEntries;
	}

	protected class Node {

		private T data;
		private Node next;

		protected Node(T dataPortion) {
			data = dataPortion;
			setNext(null);
		}

		public void setData(T newEntry) {
			data = newEntry;

		}

		public T getData(){
			return data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

}



