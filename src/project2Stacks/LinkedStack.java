package project2Stacks;

public class LinkedStack<T> implements StackInterface<T>{
	private Node topNode;
	
	public LinkedStack() {
		this(null);
	}
	
	public LinkedStack(T something) {
		topNode = something;
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
		public data;
		public next;
		
	}

}
