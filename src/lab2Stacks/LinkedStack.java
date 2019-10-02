package lab2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.util.EmptyStackException;

public class LinkedStack <T> implements StackInterface <T>
{
	private Node topNode; //top node is the first Node but for a stack, top is the first Node

	public LinkedStack() {
		topNode = null;
	}
	public void push(T anEntry) {
		Node dataNode = new Node(anEntry);
		dataNode.setNext(topNode);
		topNode = dataNode;
	}
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();
		T outData = topNode.getData();
		topNode = topNode.getNext();
		return outData;
	}
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return  topNode.getData();
	}

	@Override
	public boolean isEmpty() {
		return (topNode == null);
	}

	public void clear() {
		topNode = null;	// not a stub, but the code is very simple
	}

	private class Node {
		private T data;
		private Node next;

		public Node()
		{
			this (null);
		}
		public Node(T anEntry)
		{
			data = anEntry;
			next = null;
		}
		public void setData (T dataPortion)
		{
			data = dataPortion;
		}
		public T getData()
		{
			return data;
		}
		public void setNext(Node nextNode)
		{
			next = nextNode;
		}
		public Node getNext()
		{
			return next;
		}
	} // END Node
} // END LinkedStack
