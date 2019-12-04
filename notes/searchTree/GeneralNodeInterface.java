package searchTree;

import java.util.Iterator;

public interface GeneralNodeInterface<T> {
	public T getData();
	public void setData(T data);
	public boolean isLeaf();
	public Iterator<GeneralNodeInterface<T>> childrenIterator();
	public void addChild(BinaryNodeInterface<T> child);
	
}
