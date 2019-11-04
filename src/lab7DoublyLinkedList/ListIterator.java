package lab7DoublyLinkedList;

public interface ListIterator <T> extends Iterator <T> {
	// hasNext() and next() inherited from Iterator

	/** Returns the previous element in the list and moves the cursor 
	 * position backwards. 
	 * This method may be called repeatedly to iterate through the list 
	 * backwards, or intermixed with calls to next() to go back and forth.
	 * (Note that alternating calls to next and previous will return the 
	 * same element repeatedly.)
	 * @return the previous element in the list
	 * @throws NoSuchElementException - if the iteration has no previous 
	 * element	
	 */
	public T previous();

	/** Returns true if this list iterator has more elements when 
	 * traversing the list in the reverse direction. (In other words, 
	 * returns true if previous() would return an element rather than
	 * throwing an exception.)
	 * @return true if the list iterator has more elements when 
	 * traversing the list in the reverse direction
	 */
	public boolean hasPrevious();

	/** Returns the index of the element that would be returned by a 
	 * subsequent call to next(). (Returns list size if the list iterator
	 * is at the end of the list.)
	 * @return the index of the element that would be returned by a 
	 * subsequent call to next, or list size if the list iterator is at
	 * the end of the list
	 */
	public int nextIndex();

	/** Returns the index of the element that would be returned by a 
	 * subsequent call to previous(). (Returns -1 if the list iterator is
	 * at the beginning of the list.)
	 * @return the index of the element that would be returned by a        
	 * subsequent call to previous, or -1 if the list iterator is at the 
	 * beginning of the list
	 */
	public int previousIndex();
}

