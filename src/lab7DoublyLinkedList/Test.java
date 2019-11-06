package lab7DoublyLinkedList;

public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.reverse();
		Object[] a = list.toArray();
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		Line l = new Line(1,2,3,4);
		Line l2 = new Line(1,2,3,5);
		System.out.println(l.equals(l2));
	}
}
