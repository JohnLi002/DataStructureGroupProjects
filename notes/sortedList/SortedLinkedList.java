package sortedList;

public class SortedLinkedList <T extends Comparable<? super T>> extends LinkedList<T> implements SortedListInterface<T> {

	public SortedLinkedList() {
		super();
	}
	
	
	@Override
	public void addEntry(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeEntry(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPosition(T newEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
	public void add(T entry) {
		throw new UnsupportedOperationException();
	}
	
}
