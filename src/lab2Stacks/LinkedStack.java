package lab2Stacks;

public class LinkedStack <T> implements StackInterface <T>
{
	private Node firstNode;
	
	public LinkedStack()
	{
		firstNode = null;
	}
	public void push(T anEntry)
	{
		Node dataNode = new Node(anEntry);
		dataNode.setNext(topNode);
		topNode = dataNode;
	}
	public T pop()
	{
		return null;	// stub; to be implemented
	}
	public T peek()
	{
		return null;	// stub; to be implemented
	}
	
	@Override
	public boolean isEmpty()
	{
		return (topNode == null);
	};
	
	public void clear()
	{
		topNode = null;	// not a stub, but the code is very simple
	};
	
	private class Node
	{
		private T data;
		private Node next;
		
		public Node( )
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
