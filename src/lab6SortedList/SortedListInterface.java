package lab6SortedList;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface SortedListInterface <T extends Comparable <? super T> > {
	public void addEntry(T newEntry);
	public boolean removeEntry(T anEntry);
	public int getPosition(T newEntry);
	
	// the following methods are the same as ADT List methods.
	public T getEntry(int givenPosition);
	public boolean contains(T anEntry);
	public T remove (int givenPosition);
	public void clear();
	public int getLength();
	public boolean isEmpty();
	public Object [] toArray();
}
