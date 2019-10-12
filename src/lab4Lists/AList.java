package lab4Lists;

import java.util.Arrays;

public class AList<T> implements ListInterface <T>   {
	private T[] list;
	private int numberOfEntries;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;

	public AList( int capacity) {
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else
			checkCapacity (capacity);
		this.capacity = capacity;
		T[] temp = (T[]) new Object[capacity];
		list = temp;
		numberOfEntries = 0;
	}

	private void checkCapacity(int capacity2) {
		// TODO Auto-generated method stub

	}

	public AList () {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void add (T anEntry) {
		list[numberOfEntries] = anEntry;
		numberOfEntries ++;
		ensureCapacity();
	}

	private void ensureCapacity(){
		if (numberOfEntries >= capacity) {
			capacity *= 2;
			checkCapacity (capacity); // too big ?
			list = Arrays.copyOf(list, capacity);       
		}
	}


	@Override
	public Object [] toArray() {
		T[] result = (T[]) new Object[numberOfEntries];
		for (int idx = 0; idx < numberOfEntries; idx ++)
			result[idx] = list[idx];
		return result;
	}

	@Override
	public void add (int newPosition, T newEntry){
		if (newPosition < 0 || newPosition > numberOfEntries)
			throw new IndexOutOfBoundsException();
		makeRoom (newPosition);
		list[newPosition] = newEntry;
		numberOfEntries ++;
		ensureCapacity();
	}


	private void makeRoom (int newPosition){
		assert (newPosition >= 0 && newPosition <= numberOfEntries);
		for (int idx = numberOfEntries; idx > newPosition; idx --)
			list[idx] = list[idx-1];
	}


	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 0 && givenPosition < numberOfEntries);
		for (int index = givenPosition; index < numberOfEntries - 1; index ++){
			list[index] = list[index+1];
		}
	}
}
