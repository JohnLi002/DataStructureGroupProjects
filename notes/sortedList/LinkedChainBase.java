package sortedList;

abstract class LinkedChainBase <T>{
	private Node firstNode;
	private int numberOfEntries;
	//getFirstNode, addFirstNode, removeFirstNode
	//getAfterNode, addAfterNode, removeAfterNode
	//getNodeAt
	
	public boolean isEmpty() {
		return numberOfEntries == 0;
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
	
	protected void addAfterNode(Node curr, Node toAdd) {
		toAdd.setNext(curr.getNext());
		curr.setNext(toAdd);
		numberOfEntries++;
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

	Node getNodeAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void replace(int position, T newEntry) {
		if(position<0 || position>= getLength())
			throw new IndexOutOfBoundsException();
		
	}
	
	
	
	private int getLength() {
		return numberOfEntries;
	}

	protected class Node {
		
		private T data;
		private Node next;
		
		protected Node(T dataPortion) {
			data = dataPortion;
			setNext(null);
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



