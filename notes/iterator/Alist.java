package iterator;

import java.util.NoSuchElementException;

public class Alist<T> implements ListInterface <T>, Iterable <T> {
	private T[] list;
	private int numberOfEntries;
	private int capacity;
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		
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

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private class IteratorForAList implements Iterator<T> {
		int cursor;
		private boolean nextWasCalled;
		
		public IteratorForAList() {
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			return (cursor < numberOfEntries);
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			nextWasCalled = true;
			T item = list[cursor];
			cursor++;
			return item;
		}

		@Override
		public void remove() {
			// throw new UnsupportedOperatorionException();
			
			if(!nextWasCalled) {
				throw new IllegalStateException("attempt to call remove without call to next");
			}
			
		}
	}
	
}
