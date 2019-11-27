package lab9Trees;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface TreeInterface<T> {
	public T getRootData();
	public int getHeight();
	public int getNumberOfNodes();
	public boolean isEmpty();
	public void clear();
}
