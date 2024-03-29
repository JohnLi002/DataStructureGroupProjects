package project5Trees;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.util.Iterator;
import tree.TreeInterface;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T> {
	
	public boolean contains(T entry);
	public T getEntry(T entry);
	public T add(T newEntry);
	public T remove(T entry);
	public Iterator<T> getInorderIterator();
	
}
