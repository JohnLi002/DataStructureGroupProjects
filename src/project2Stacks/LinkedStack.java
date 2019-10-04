package project2Stacks;

public class LinkedStack<T> implements StackInterface<T>{
	private Node topNode;
	
	public LinkedStack() {
		this(null);
	}
	
	public LinkedStack(T firstNode) {
		topNode = new Node(firstNode);
	}
	
	
	@Override
	public void push(T anEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return (topNode == null);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	private class Node{
		public T data;
		public Node next;
		
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
	}

}
