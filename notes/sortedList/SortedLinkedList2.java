package sortedList;

public class SortedLinkedList2 <T extends Comparable<? super T>> extends LinkedChainBase<T> implements SortedListInterface<T> {
	public SortedLinkedList2() {
		super();
	}
	
	@Override
	public void addEntry(T newEntry) {
		int position = getPosition(newEntry);
		
		if(position < 0) {
			position = -position - 1;
		}
		if(position == 0){
			//addFirstNode(newEntry);
		}else {
		Node before = getNodeAt(position - 1);
		//addAfterNode(before, newEntry);
		}
	}

	@Override
	public boolean removeEntry(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPosition(T newEntry) {
		int position = 0;
		Node curr = getFirstNode();
		
		while(curr != null && newEntry.compareTo(curr.getData())>0) {
			curr = curr.getNext();
		}
		if(curr == null || newEntry.compareTo(curr.getData()) < 0) {
			position = -position - 1;
		}
		return position;
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

}
