package iterator;

import java.util.NoSuchElementException;

public class Alist2<T> implements ListInterface<T>{

	private T[] list;
	private int numberOfEntries;

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

	
	private enum Move{
		NEXT, PREV
	}
	
	private class ListIteratorForAList implements ListIteratorInterface<T>{
		private int cursor;
		private boolean isRemoveOrSetLegal;
		private Move lastMove;
		
		public ListIteratorForAList() {
			cursor = 0;
			isRemoveOrSetLegal = false;
		}

		public int previousIndex() {
			return (cursor-1);
		}

		public boolean hasNext() {
			return (cursor < numberOfEntries);
		}
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException("");
			}
			T item = list[cursor++];
			isRemoveOrSetLegal = true;
			return item;
		}

		public T previous() {
			if(!hasPrevious()){
				throw new NoSuchElementException("");
			}
			T item = list[cursor--];
			isRemoveOrSetLegal = true;
			return item;
		}

		public void add(T newEntry) {
			Alist2.this.add(cursor++, newEntry);
		}
		
		private boolean hasPrevious() {
			return false;
		}
		
		public void remove() {
			if(!isRemoveOrSetLegal) {
				throw new IllegalStateException("illegal call to remove: neither next nor previous was called");
			}
			if(lastMove == Move.NEXT) {
				Alist2.this.remove(--cursor);
			} else {
				Alist2.this.remove(cursor);
				isRemoveOrSetLegal = false;
			}
		}
		
		public void set(T newEntry) {
			if(!isRemoveOrSetLegal) {
				throw new IllegalStateException("illegal call to remove: neither next nor previous was called");
			}
			if(lastMove == Move.NEXT) {
				list[cursor-1] = newEntry;
			} else {
				list[cursor] = newEntry;
			}
			isRemoveOrSetLegal = false;
		}
	}
}


