package lab6SortedList;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import sortedList.LinkedList;

public class SortedLinkedList <T extends Comparable <? super T> >extends LinkedList <T> implements SortedListInterface <T> {	
	public SortedLinkedList () {
		super ();
	}

	public void addEntry(T needEntry){
		int newPosition = getPosition(needEntry);
		if(newPosition < 0)
			newPosition = newPosition+1;
		super.add(newPosition, needEntry);
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

	public int getPosition(T newEntry) {
		int position = 0;
		while(position < getLength() && newEntry.compareTo(getEntry(position)) > 0){
			if(newEntry.compareTo(getEntry(position)) == 0){
				return position;
			}
			position++;
		}
		
		if(position == getLength()) {
			return position;
		}
		return position;
	}

}
