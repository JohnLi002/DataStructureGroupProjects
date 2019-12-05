package project5Trees;

import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Iterator;

public class BinaryTree<T> implements BinaryNodeInterface<T>{

	private BinaryNode<T> root;

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}

	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	public void setTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		initializeTree(rootData, leftTree, rightTree);
	}

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<>(rootData);
		if(leftTree != null && !leftTree.isEmpty()) {
			root.setLeftChild(leftTree.getRoot());
		}
		if(rightTree != null && !rightTree.isEmpty()) {
			if(rightTree == leftTree) {
				root.setRightChild(rightTree.getRoot().copy());
			} else {

			}
		}
	}
	
	public void setRoot(BinaryNode<T> node) {
		root = node;
	}
	
	private boolean isEmpty() {
		return root == null;
	}

	protected BinaryNodeInterface<T> getRoot() {
		return root;
	}


	@Override
	public T getData() {
		return root.getData();
	}

	public T getRootData() {
		return root.getData();
	}

	@Override
	public BinaryNodeInterface<T> getLeftChild() {
		return root.getLeftChild();
	}



	@Override
	public BinaryNodeInterface<T> getRightChild() {
		return root.getRightChild();
	}

	@Override
	public boolean hasLeftChild() {
		return root.hasLeftChild();
	}

	@Override
	public boolean hasRightChild() {
		return root.hasRightChild();
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		root.setLeftChild(leftChild);
	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		root.setRightChild(rightChild);
	}

	@Override
	public int getHeight() {
		return root.getHeight();
	}

	@Override
	public int getNumberOfNodes() {
		if(isEmpty()) {
			return 0;
		}
		return root.getNumberOfNodes();
	}

	@Override
	public BinaryNodeInterface<T> copy() {
		BinaryNode<T> result = (BinaryNode<T>) root.copy();
		return result;
	}


	@Override
	public void setData(T newData) {
		root.setData(newData);
	}

	@Override
	public boolean isLeaf() {
		return (!(root.hasLeftChild()) && !(root.hasRightChild()));
	}
	
	public Iterator<T> getPreorderIterator(){
		return new PreorderIterator();
	}
	
	public Iterator<T> getInorderIterator(){
		return new InorderIterator();
	}
	
	public Iterator<T> getLevelorderIterator(){
		return new LevelorderIterator();
	}
	
	private class PreorderIterator implements Iterator<T>{
		private Stack<BinaryNode<T>> nodeStack;

		public PreorderIterator() {
			nodeStack = new Stack<>();
			nodeStack.push(root);
		}

		@Override
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			BinaryNode <T> currNode = nodeStack.pop();
			T item = currNode.getData();
			if (currNode.hasRightChild())
				nodeStack.push(currNode.getRightChild());
			if (currNode.hasLeftChild())
				nodeStack.push(currNode.getLeftChild());
			return item;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public class InorderIterator implements Iterator<T>{

		private Stack<BinaryNode<T>> nodeStack;

		public InorderIterator() {
			addToStack(root);
		}

		private void addToStack(BinaryNode<T> node) {
			if(node.hasRightChild()) {
				addToStack(node.getRightChild());
			}

			nodeStack.push(node);

			if(node.hasLeftChild()) {
				addToStack(node.getLeftChild());
			}
		}

		@Override
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		@Override
		public T next() {
			return nodeStack.pop().getData();
		}

		public void outputLeaves() {
			outputNodeLeaves(root);
		}

		public void outputNodeLeaves(BinaryNode<T> node) {
			if(node.isLeaf()) {
				System.out.print(node.getData());
			}
			if(node.hasLeftChild()) {
				outputNodeLeaves((BinaryNode<T>) node.getLeftChild());
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public class LevelorderIterator  implements Iterator<T>{
		private LinkedQueue<BinaryNode<T>> nodeQueue;

		public LevelorderIterator() {
			nodeQueue = new LinkedQueue<>();
			nodeQueue.enqueue(root);
		}

		@Override
		public boolean hasNext() {
			return !(nodeQueue.isEmpty());
		}

		@Override
		public T next() {
			BinaryNode<T> n = nodeQueue.dequeue();
			
			if(n.hasLeftChild()) {
				nodeQueue.enqueue(n.getLeftChild());
			}
			if(n.hasRightChild()) {
				nodeQueue.enqueue(n.getRightChild());
			}
			return n.getData();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
