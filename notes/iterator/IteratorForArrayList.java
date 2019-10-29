package iterator;

private class IteratorForArrayList {
	private int cursor;
	private boolean nextWasCalled = false;
	public IteratorForArrayList() {
		cursor = 0;
	}
	public boolean hasNext() {
		return (cursor < getLength());
	}
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException("no iteration after the list");
		}
		T item = list[cursor++];
		nextWasCalled = true;
		return item;
	}
	public void remove() {
		//throw new UnsupportedOperationException("remove is not supported");
		if(!nextWasCalled) {
			throw new IllegalStateException("illegal call to remove without next");
		}
		nextWasCalled = false;
	}
}
