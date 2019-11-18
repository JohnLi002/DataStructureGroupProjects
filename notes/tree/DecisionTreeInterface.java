package tree;

public interface DecisionTreeInterface<T> extends BinaryTreeInterface<T> {
	public T getCurrentData();
	public void setCurrentData(T newData);
}
