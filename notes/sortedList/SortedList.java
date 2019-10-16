package sortedList;

public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T>{
	private LinkedList<T> list;
	public SortedList(){
		list = new LinkedList<T>();
	}
	public T getEntry(int position){
		return list.getEntry(position);
	}
	@Override
	public boolean contains(T entry){
		return list.contains(entry);
	}
	public void clear(){
		list.clear();
	}
	public void addEntry(T needEntry){
		int newPosition = getPosition(needEntry);
		if(newPosition < 0)
			newPosition = -newPosition-1;
		list.add(newPosition, needEntry);
	}

	@Override
	public boolean removeEntry(T anEntry) {
		int position = getPosition(anEntry);
		if(position < 0)
				return false;
		remove(position);
		return true;
	}
	@Override
	public int getPosition(T newEntry) {
		int position = 0;
		
		while(position < getLength() && newEntry.compareTo(getEntry(position)) > 0){
			position++;
			if(newEntry.compareTo(getEntry(position)) == 0){
				return position;
			}
		}
		return (-position-1);
	}
	
	//				  n(n+1)
	// 1+2+3+...+n = --------
	//                   2
	
	//                       n(n+1)(2n+1)
	//1^2+2^2+3^2+...+n^2 = --------------
	//                          6
	
	//						(   n(n+1)   )^2
	//1^3+2^3+3^3+...+n^3 = (------------)
	//                      (    2       )
	
	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* Efficiency Stuff?
	 * 
	 *              | ArrayImplementataion | LinkedImplementation
	 * getPosition  |          O(n)        |         O(n^2)
	 * getEntry     |          O(n)        |         O(n)
	 * addEntry     |          O(n)        |         O(n^2)
	 * removeEntry  |          O(n)        |         O(n^2)
	 * contains     |          O(n)        |         O(n) 
	 * removes(pos) |          O(n)        |         O(n)
	 * clear        |          O(n)        |         O(n)             
	 * isEmpty      |          O(1)        |         O(1)
	 * toArray      |          O(n)        |         O(n)
	 */
	
	
	
	
}