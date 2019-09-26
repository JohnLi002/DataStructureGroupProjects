package lab2Stacks;

import java.util.EmptyStackException;

public class ArrayStack <T> implements StackInterface <T> {
	private T[] stackArray;
	private int stackLength;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 50;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		capacity = size;
		stackArray = (T[]) new Object[capacity];
	}
	
	@Override
	public void push(T anEntry) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public T pop() { //removes and returns the very top of the stack
		if(isEmpty()) {
			throw new EmptyStackException();
		}

		T outData = stackArray[stackLength - 1];
		stackArray[stackLength - 1] = null;  
		stackLength--;
		return outData;
	}
	@Override
	public T peek() { //simply returns the very top of the stack
		if(isEmpty()) {
			throw new EmptyStackException();
		}

		T outData = stackArray[stackLength - 1];
		return outData;
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
}
