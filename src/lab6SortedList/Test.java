package lab6SortedList;



public class Test {
	public static void main(String[] args) {
		Message m1 = new Message("hey, my name is tony");
		Object[] p1 = m1.encode();
		System.out.println(m1.getPacket());
		
	}
}
