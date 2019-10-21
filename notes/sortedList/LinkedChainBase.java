package sortedList;

abstract class LinkedChainBase <T>{
	private Node firstNode;
	private int numberOfEntries;
	
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
}



