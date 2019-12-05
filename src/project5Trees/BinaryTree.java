package project5Trees;

/**
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */


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
		if(leftTree != null) {
			root.setLeftChild(leftTree.getRoot().copy());
		}
		if(rightTree != null) {
			root.setRightChild(rightTree.getRoot());
		}
	}

	private boolean isEmpty() {
		return root == null;
	}

	public BinaryNodeInterface<T> getRoot() {
		return (BinaryNodeInterface<T>) root;
	}

	public void setRoot(BinaryNode<T> node) {
		root = node;
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

		if(node.hasRightChild()) {
			outputNodeLeaves((BinaryNode<T>) node.getRightChild());
		}
	}

	@Override
	public BinaryNodeInterface<T> copy() {
		return root.copy();
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

	public Iterator<T> getPostOrderIterator(){
		return new PostOrderIterator();
	}

	public Iterator<T> getInorderIterator(){
		return new InorderIterator();
	}

	public Iterator<T> getLevelorderIterator(){
		return new LevelorderIterator();
	}

	private class PreorderIterator implements Iterator<T>{
		private Stack<BinaryNode<T>> nodeStack;

		public PreorderIterator (){
			if (root == null)
				throw new IllegalArgumentException (
						"No iteration on empty tree");

			nodeStack = new Stack <>();
			nodeStack.push (root);
		}

		@Override
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		@Override
		public T next() {
			BinaryNode <T> currNode = nodeStack.pop();
			T item = currNode.getData();
			if (currNode.hasRightChild())
				nodeStack.push(currNode.getRightChild());
			if (currNode.hasLeftChild())
				nodeStack.push(currNode.getLeftChild());
			return item;
		}

		@Override
		public void remove (){
			throw new UnsupportedOperationException();
		}
	}


	private class PostOrderIterator implements Iterator<T>{
		private Stack<BinaryNode<T>> nodeStack;

		public PostOrderIterator() {
			nodeStack = new Stack<>();
			addToStack (root);
		}

		private void addToStack (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
			BinaryNode <T> right = (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = (BinaryNode <T>)aNode.getLeftChild();
			nodeStack.push(aNode);
			addToStack (right);
			addToStack (left);
		}
		@Override
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		@Override
		public T next() {
			return nodeStack.pop().getData();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


	private class InorderIterator implements Iterator <T> {
		private Stack <BinaryNode<T>> nodeStack;

		public InorderIterator() {
			nodeStack = new Stack <> ();
			addToStack (root);
		}

		private void addToStack (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
			BinaryNode <T> right = (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = (BinaryNode <T>)aNode.getLeftChild();	
			addToStack (right);
			nodeStack.push(aNode);
			addToStack (left);
		}

		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		public T next() {
			return nodeStack.pop().getData();
		}

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

