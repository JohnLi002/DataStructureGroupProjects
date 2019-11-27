package searchTree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

	public BinarySearchTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		super(rootData, leftTree, rightTree);
	}
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		throw new UnsupportedOperationException();
	}

	public T getEntry(T entry) {
		return findEntry(getRoot(), entry);
	}

	private T findEntry(BinaryNodeInterface<T> node, T entry) {
		if(node == null)
			return null;
		
		T rootEntry = node.getData();
		int comparison = entry.compareTo(rootEntry);
		
		if(comparison == 0) {
			return rootEntry;
		} else if(comparison < 0) {
			return findEntry(node.getLeftChild(), entry);
		} else {
			return findEntry(node.getRightChild(),entry);
		}
	}

	@Override
	public boolean contains(T entry) {
		return (getEntry(entry) != null);
	}

	public T getEntryIterative(T entry) {
		BinaryNode<T> currNode = (BinaryNode<T>) getRoot();
		if(currNode == null) {
			return null;
		}
		
		T rootEntry = currNode.getData();
		int comparison;
		
		do {
			rootEntry = currNode.getData();
			comparison = entry.compareTo(rootEntry);
			if(comparison == 0) {
				return rootEntry;
			} else if(comparison < 0) {
				currNode = currNode.getLeftChild();
			} else {
				currNode = currNode.getRightChild();
			}
		} while(currNode != null);
		
		return null;
	}
	
	@Override
	public T add(T newEntry) {
		if(isEmpty()) {
			setRoot(new BinaryNode<T>(newEntry));
			return null;
		} else {
			return addEntry((BinaryNode<T>) getRoot(), newEntry);
		}
	}
	
	

	private T addEntry(BinaryNode<T> node, T newEntry) {
		assert(node != null);
		T rootEntry = node.getData();
		int comparison = newEntry.compareTo(rootEntry);
		if(comparison == 0) {
			node.setData(newEntry);
			return rootEntry;
		} else if(comparison < 0) {
			if(node.hasLeftChild()) {
				return addEntry(node.getLeftChild(), newEntry);
			} else {
				node.setLeftChild(new BinaryNode<T>(newEntry));
			}
		} else {
			if(node.hasRightChild()) {
				return addEntry(node.getRightChild(), newEntry);
			} else {
				node.setRightChild(node);
			}
		}
		
		return rootEntry;
	}
	
	@Override
	public T getRootData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	

	@Override
	public T remove(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public iterator.Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
