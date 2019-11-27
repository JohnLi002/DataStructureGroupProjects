package searchTree;

import sortedList.SortedListInterface;

public class SortedTreeList<T extends Comparable<? super T>> implements SortedListInterface<T> {

	private BinarySearchTree<T> tree;
	
	public SortedTreeList() {
		
	}
	
	public boolean getLeft() {
		return left;
	}
	
	@Override
	public void addEntry(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeEntry(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPosition(T newEntry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int givenPosition) {
		if(isEmpty()) {
			return null;
		}
		
		MoveInfo move = MoveInfo();
		BinaryNode<T> currNode = getRoot();
		T rootData();
		int comparison;
		
		do {
			rootData = move.getCurrent().getData();
			comparison = entry.compareTO(rootData);
			if(comparison > 0) {
				move.setMovement(currNode);
				currNode = currNode.getRightChild();
				move.setCurrent(currNode);
				move.setRight();
			}
			if(comparison < 0) {
				move.setParent(currNode);
			}
		}
	}
	
	public T remove(T entry) {
		boolean hasLeft = currNode.hasLeftChild();
		boolean hasRight = currNode.hasRightChild();
		if(!hasLeft) {
			resetChild(move, currNode.getRightChild());
		} else if(!hasRight) {
			resetChild(move, currNode.getLeftChild())
		} else {
			
		}
		
		
	}

	@Override
	public void clear() {
		tree = null;
	}

	@Override
	public int getLength() {
		return tree.getHeight();
	}

	@Override
	public boolean isEmpty() {
		return tree == null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
