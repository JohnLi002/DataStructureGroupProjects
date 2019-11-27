package lab9Trees;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T> {
	public void setTree(T rootData);
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> fightTree);
}
