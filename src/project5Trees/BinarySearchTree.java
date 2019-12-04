package project5Trees;


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
		return getRoot().getData();
	}

	@Override
	public int getHeight() {
		return getRoot().getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		return getRoot().getNumberOfNodes();
	}

	@Override
	public boolean isEmpty() {
		return getRoot() == null;
	}

	@Override
	public void clear() {
		setRoot(null);
	}



	@Override
	public T remove(T entry) {	
		T result;
		if (isEmpty())
			return null;
		
		MoveInfo move = new MoveInfo ();
		BinaryNode <T> currNode = (BinaryNode<T>) getRoot();
		T rootData;
		int comparison;
		do {
			rootData = move.getCurrent().getData();
			comparison = entry.compareTo (rootData);
			if (comparison > 0 ) { // move to the right
				move.setParent(currNode);
				currNode = currNode.getRightChild();
				move.setCurrent(currNode);
				move.setRight ();
			}
			if (comparison < 0) { // move to the left
				move.setParent(currNode);
				currNode = currNode.getLeftChild();
				move.setCurrent(currNode);
				move.setLeft();
			}				
		} while (comparison != 0 && currNode != null);

		if (currNode == null) // no match
			return null;
		assert (comparison == 0);
		result = currNode.getData();

		boolean hasLeft = currNode.hasLeftChild();
		boolean hasRight = currNode.hasRightChild();
		if (!hasLeft ) { // hasRight or leaf
			resetChild (move, currNode.getRightChild());
		} else if (!hasRight) {
			resetChild (move, currNode.getLeftChild());		
		} else { // two children
			BinaryNode <T> toRemove = currNode;
			move.setParent(currNode);
			currNode = currNode.getLeftChild();
			move.setLeft();
			move.setCurrent(currNode);
			while (currNode.hasRightChild()) {
				move.setRight();
				move.setParent(currNode);
				currNode = currNode.getRightChild();
				move.setCurrent(currNode);
			}
			toRemove.setData(currNode.getData());
			resetChild (move, currNode.getLeftChild());
		}
		return result;
	}

	private void resetChild (MoveInfo move, BinaryNode <T> child){
		BinaryNode <T> parent = move.getParent();
		if (parent == null ) // root: the only node with no parent
			setRoot (child);
		else if (move.getLeft())
			parent.setLeftChild (child);
		else
			parent.setRightChild (child);	
	}


	
	private class MoveInfo {
		private BinaryNode <T> parent;
		private BinaryNode <T> current;
		private boolean left;

		public MoveInfo () {
			parent = null;
			current = (BinaryNode<T>) getRoot ();
			left = true;
		}	
		public void setParent (BinaryNode<T> parent) {
			this.parent = parent;
		}	
		public BinaryNode <T> getParent () {
			return parent;
		}	
		public void setCurrent (BinaryNode<T> node) {
			current = node;		
		}	
		public BinaryNode <T> getCurrent () {
			return current;
		}		
		public void setLeft () {
			left = true;
		}		
		public void setRight () {
			left = false;
		}		
		public boolean getLeft () {
			return left;
		}	
	}

}
