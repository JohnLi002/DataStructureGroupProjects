package lab5CardLists;

public class Test {
	public static void main(String[] args) {
		Pile p = new Pile();
		Card c = new Card("hearts", "ace");
		Card c2 = new Card("spades", "two");
		Card c3 = new Card("diamonds", "three");
		Card c4 = new Card("diamonds","four");
		Card c5 = new Card("Clubs", "five");
		p.add(c);
		p.add(c2);
		p.add(c3);
		p.add(c4);
		p.add(c5);
		System.out.println(p.getLength());
		p.remove(c2);
		System.out.println(p.getLength());
		System.out.println(p.contains(c2));
	}
}
