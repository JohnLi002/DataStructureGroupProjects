package project2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>{
	private Node topNode;
	
	public LinkedStack() {
		topNode = null;
	}
	
	@Override
	public void push(T anEntry) {
		Node newNode = new Node(anEntry);
		newNode.setNext(topNode);
		topNode = newNode;
	}

	/**
	 * replace topNode with the next node. Also returns the previous data and
	 */
	@Override
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T oldData = topNode.getData();
		topNode = topNode.getNext();
		
		return oldData;
	}

	/**
	 * return the data of the topNode
	 */
	@Override
	public T peek() {
		return topNode.getData();
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
		topNode = null;
	}
	
	private class Node{
		private T data;
		private Node next;
		
//this constructor is never used
//		Node(){ 
//			data = null;
//			next = null;
//		}
		
		Node(T entry){
			data = entry;
			next = null;
		}
		
//this method is never used
//		public void setData(T entry) {
//			data = entry;
//		}
		
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
