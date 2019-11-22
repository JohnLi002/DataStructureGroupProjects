package lab9Trees;

import java.util.NoSuchElementException;
import java.util.Stack;

import iterator.Iterator;
import lab2Stacks.ArrayStack;
import project3Queues.LinkedQueue;

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



	private boolean isEmpty() {
		return root == null;
	}



	private BinaryNodeInterface<T> getRoot() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public BinaryNodeInterface<T> getRightChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLeftChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOFNodes() {
		if(isEmpty()) {
			return 0;
		}
		return root.getNumberOFNodes();
	}

	@Override
	public BinaryNodeInterface<T> copy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private  class PreorderIterator implements Iterator<T>{
		private Stack<BinaryNode<T>> nodeStack;
		
		public PreorderIterator() {
			nodeStack.push(root);
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (!nodeStack.isEmpty());
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return null;
		}
		

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	}
}
