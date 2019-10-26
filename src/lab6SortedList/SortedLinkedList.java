package lab6SortedList;

public class SortedLinkedList <T extends Comparable <? super T>> extends LinkedList <T> implements SortedListInterface <T> {

	private ListInterface <T> list;

	public SortedLinkedList() {
		super();
	}

	public void addEntry(T newEntry){
		int newPosition = Math.abs(getPosition(newEntry)+1);
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


}
