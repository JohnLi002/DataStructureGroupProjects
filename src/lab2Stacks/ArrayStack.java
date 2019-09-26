package lab2Stacks;

import java.util.EmptyStackException;

public class ArrayStack <T> implements StackInterface <T> {
	private T[] stackArray; //array to hold objects
	private int stackLength; //number of object in the array
	private int capacity; //number of objects an array can hold
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
		if(stackLength == capacity) {
			capacity *= 2;
		}
		stackArray[stackLength] = anEntry;
		stackLength++;
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
	public boolean isEmpty() { //checks to see if the Array in stackArray is empty
		for(int i = 0; i < stackLength; i++) {
			if(stackArray[i] != null) { //if there is something that is not null, then there is something so the method returns false
				return false;
			}
		}
		return true;
	}
	@Override
	public void clear() { //goes through array and turns everything into null
		for(int i = 0; i < stackLength; i++) {
			stackArray[i] = null;
		}
	}
}
