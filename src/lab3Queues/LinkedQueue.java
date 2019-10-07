package lab3Queues;


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
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getFront(){
        if (isEmpty())
            throw new EmptyQueueException();
        return frontNode.getData();  
    }
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
