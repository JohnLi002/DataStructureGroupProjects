package iteratorDoubleLinkedList;

import java.util.NoSuchElementException;

/*
import java.util.ListIterator;
import java.util.NoSuchElementException;
*/

public class DoubleLinkedList<T> {


	private DoubleNode head;
	private DoubleNode tail;
	private int numberOfEntries;
	
	public DoubleLinkedList(){
		
	}
	
	
	
	private class ListIteratorForDList implements ListIterator<T>{
		private DoubleNode nextNode;
		private DoubleNode prevNode;
		private int index;
		
		public ListIteratorForDList() {
			nextNode = head;
			index = 0;
		}
		
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			T item = nextNode.getData();
			nextNode = nextNode.getNext();
			return item;
		}
		
		public boolean hasNext() {
			return nextNode != null;
		}
		
		public void add(T entry) {
			DoubleNode insert = new DoubleNode(entry);
			insert.setNext(nextNode);
			nextNode.setPrev(insert);
			if(nextNode != head){
				DoubleNode prevNode = nextNode.getPrev();
			}
			prevNode.setNext(insert);
			
			
		}
		
		public void previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if(nextNode == null) {
				nextNode = tail;
			} else {
				nextNode = nextNode.getPrev();
			}
		}
		
		public boolean hasPrevious() {
			return nextNode != head;
		}
	
		}
		private class DoubleNode {
			private T data;
			private DoubleNode next;
			private DoubleNode prev;
			
			public DoubleNode(T entry) {
				T data = entry;
			}
			public T getData() {
				return data;
			}
			public void setData(T item) {
				data = item;
			}
			public DoubleNode getNext() {
				return next;
			}
			public void setNext(DoubleNode next) {
				this.next = next;
			}
			public DoubleNode getPrev() {
				return prev;
			}
			public void setPrev(DoubleNode prev) {
				this.prev = prev;
			}
		}


		
	}
	
	

	
	
	

