package lab9Trees;

public interface BinaryNodeInterface<T> {
	public T getData();
	public void setData(T newData);
	public BinaryNodeInterface<T> getLeftChild();
	public BinaryNodeInterface<T> getRightChild();
	public boolean hasLeftChild();
	public boolean hasRightChild();
	public void setLeftChild(BinaryNodeInterface<T> leftChild);
	public void setRightChild(BinaryNodeInterface<T> rightChild);
	//. . . . .
	public boolean isLeaf();
	public int getHeight();
	public int getNumberOfNodes();
	public BinaryNodeInterface<T> copy();
}
