package project5Trees;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class BinaryNode<T> implements BinaryNodeInterface<T>{
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode(T rootData) {
		this(rootData, null, null);
	}
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		leftChild = left;
		rightChild = right;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T newData) {
		data = newData;
	}
	
	public BinaryNode<T> getLeftChild(){
		return leftChild;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public BinaryNode<T> getRightChild(){
		return rightChild;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		this.leftChild = (BinaryNode<T>) leftChild;
		
	}

	@Override
	public int getHeight() {
		int leftHeight = 0, rightHeight = 0;
		if(leftChild!=null) {
			leftHeight = leftChild.getHeight();
		} 
		if (rightChild != null) {
			rightHeight = rightChild.getHeight();
		}
		return (1+Math.max(leftHeight, rightHeight));
	}

	@Override
	public int getNumberOfNodes() {
		int leftNodes = 0, rightNodes = 0;
		
		if(hasLeftChild()) {
			leftNodes = leftChild.getNumberOfNodes();
		}
		if(hasRightChild()) {
			rightNodes = rightChild.getNumberOfNodes();
		}
		return (1 + leftNodes + rightNodes);
	}

	@Override
	public BinaryNodeInterface<T> copy() {
		BinaryNode<T> copied = new BinaryNode<>(data);
		if(hasLeftChild()){
			copied.setLeftChild(leftChild.copy());
		}
		if(hasRightChild()) {
			copied.setRightChild(rightChild.copy());
		}
		return copied;
	}

	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		this.rightChild = (BinaryNode<T>) rightChild;
		
	}

	public boolean isLeaf () {
	   return (leftChild == null && rightChild == null);
	}
}