package lab6SortedList;

import sortedList.LinkedList;

public class SortedLinkedList <T extends Comparable <? super T>>extends LinkedList <T> implements SortedListInterface <T> {
	private LinkedList<T> list;
	
	public SortedLinkedList () {
		super ();
	}

	public void addEntry(T newEntry){
		int newPosition = getPosition (newEntry);
		if (newPosition < 0)
			newPosition = -newPosition - 1;
		list.add (newPosition, newEntry);        
	}


	public boolean removeEntry (T anEntry){
		boolean result = false;
		int position = getPosition (anEntry);
		if (position >= 0){
			list.remove (position);
			result = true;
		}	
		return result;
	}

	public int getPosition( T anEntry){
		int position = 0;
		int length = list.getLength();

		while (position < length && 
				anEntry.compareTo (list.getEntry(position))> 0)
			position ++;
		if (position == length ||
				(anEntry.compareTo(list.getEntry(position))) < 0)
			position = -1 - position;
		return position;
	}


	public T getEntry(int givenPosition){
		return list.getEntry(givenPosition);
	}

	public boolean contains (T anEntry){
		return list.contains(anEntry);
	}

	public T remove (int givenPosition){
		return list.remove(givenPosition);
	}

	public void clear(){
		list.clear();
	}

	public int getLength(){
		return list.getLength();
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	public Object[] toArray(){
		return list.toArray();
	}


}
