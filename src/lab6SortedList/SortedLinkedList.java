package lab6SortedList;

import sortedList.LinkedList;

public class SortedLinkedList <T extends Comparable <? super T> >extends LinkedList <T> implements SortedListInterface <T> {	
	public SortedLinkedList () {
		super ();
	}

	public void addEntry(T newEntry){
		int newPosition = getPosition (newEntry);
		if (newPosition < 0)
			newPosition = -newPosition - 1;
		super.add (newPosition, newEntry);        
	}

	public boolean removeEntry (T anEntry){
		boolean result = false;
		int position = getPosition (anEntry);
		if (position >= 0){
			super.remove (position);
			result = true;
		}	
		return result;
	}

	public int getPosition( T anEntry){
		int position = 0;
		int length = super.getLength();
		while (position < length && anEntry.compareTo(super.getEntry(position))> 0)
			position ++;
		if (position == length || (anEntry.compareTo(super.getEntry(position))) < 0)
			position = -1 - position;
		return position;
	}

}
