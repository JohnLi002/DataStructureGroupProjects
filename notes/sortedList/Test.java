package sortedList;

public class Test {
	public static void main(String[] args) {
		SortedList<String> a = new SortedList<>();
		
		a.addEntry("a");
		a.addEntry("b");
		a.addEntry("d");
		a.addEntry("c");
		Integer i = 1;
		System.out.println(a.getEntry(3));
		
	}
}
