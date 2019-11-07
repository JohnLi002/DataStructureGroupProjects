package lab7DoublyLinkedList;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */
public class Test {
	public static void main(String[] args) {
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.add("1");
		list.add("2");
		list.reverse();
		Object[] a = list.toArray();
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		Polygon p = new Polygon("polygonTest.txt");
		p.display();
		p.reverse();
		System.out.println();
		p.display();
		
	}
}
