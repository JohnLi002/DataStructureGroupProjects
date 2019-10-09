package lab3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class LinkedQueue <T> implements QueueInterface <T> {
	private Node frontNode;
	private Node backNode;

	public LinkedQueue () {
		frontNode = null;
		backNode = null;
	}

	@Override
	public void enqueue (T newEntry){
		Node newNode = new Node (newEntry);
		if (isEmpty()) 
			frontNode = newNode;     
		else
			backNode.setNext(newNode);
		backNode = newNode;   
	}


	@Override
	public T dequeue (){
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		
		T front = frontNode.getData();
		frontNode = frontNode.getNext();
		
		if (frontNode == null) { // happens when only one entry was in the queue, so only one node is in the chain
			backNode = null;
		}
		return front;

	}

	@Override
	public T getFront(){
		if (isEmpty())
			throw new EmptyQueueException();
		return frontNode.getData();  
	}

	@Override
	public boolean isEmpty() {
		return (frontNode == null && backNode == null); //checks to make sure both front and back nodes are empty
	}

	@Override
	public void clear() {
		frontNode = null;
		backNode = null;

	}

	private class Node{
		private T data;
		private Node next;

		Node(){
			data = null;
			next = null;
		}

		Node(T entry){
			data = entry;
			next = null;
		}

		public void setData(T entry) {
			data = entry;
		}

		public T getData() {
			return data;
		}

		public void setNext(Node n) {
			next = n;
		}

		public Node getNext() {
			return next;
		}
	}

}
