package lab4Lists;

import java.util.Arrays;

public class AList<T> implements ListInterface <T>   {
	private T[] list;
	private int numberOfEntries;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 10000;


	public AList () {
		this(DEFAULT_CAPACITY);
	}
	
	public AList(int capacity) {
		if (capacity <= DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		else
			checkCapacity (capacity);
		this.capacity = capacity;
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[this.capacity];
		list = temp;
		numberOfEntries = 0;
	}

	private void checkCapacity(int capacity2) {
		if(capacity > MAX_CAPACITY)
			throw new RuntimeException();
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
		@SuppressWarnings("unchecked")
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
		T removed = list[givenPosition];
		list[givenPosition] = null;
		removeGap(givenPosition);
		numberOfEntries--;
		return removed;
	}

	@Override
	public boolean remove(T anEntry) {
		for(int i = 0; i < numberOfEntries; i++) {
			if(list[i].equals(anEntry)) {
				list[i] = null;
				removeGap(i);
				numberOfEntries--;
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		for(int i =0; i < capacity; i++) {
			list[i] = null;
		}
		numberOfEntries = 0;

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		if(!isEmpty() && givenPosition > numberOfEntries-1) {
			throw new RuntimeException();
		}else {
			T result = list[givenPosition];
			list[givenPosition] = newEntry;
			return result;
		}
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return list[givenPosition];
	}

	@Override
	public int getLength() {
		
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	@Override
	public boolean contains(T anEntry) {
		for(int i = 0; i < numberOfEntries; i++) {
			if(list[i].equals(anEntry)) {
				return true;
			}
		}
		
		return false;
	}
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 0 && givenPosition < numberOfEntries);
		for (int index = givenPosition; index < numberOfEntries - 1; index ++){
			list[index] = list[index+1];
		}
	}
}
