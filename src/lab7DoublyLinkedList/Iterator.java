package lab7DoublyLinkedList;
/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface Iterator<T> {
	/** Returns true if the iteration has more elements.
	 * (In other words, returns true if next would
	 * return an element rather than throwing an exception.)
	 * @return true if the iteration has more elements, false otherwise
	 */
	public boolean hasNext();

	/** Returns the next element in the iteration.
	 * @return the next element in the iteration
	 * @throws NoSuchElementException if the iteration has no more elements
	 */
	public T next();
}
