package lab7DoublyLinkedList;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add(2,"5");
		System.out.println(list.getEntry(3));
		
	}
}
