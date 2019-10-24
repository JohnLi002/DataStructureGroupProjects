package lab5CardLists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Test {
	public static void main(String[] args) {
		Pile p = new Pile();
		Card c = new Card("hearts", "ace");
		Card c2 = new Card("spades", "two");
		Card c3 = new Card("diamonds", "three");
		Card c4 = new Card("diamonds","four");
		Card c5 = new Card("Clubs", "five");
		Card c6 = new Card("Clubs", "six");
		Card c7 = new Card("Clubs", "seven");
		Card c8 = new Card("Clubs", "eight");
		


		p.add(c);
		p.add(c2);
		p.add(c3);
		p.add(c4);
		p.add(c5);
		p.add(c6);
		p.add(c7);
		p.add(c8);
		System.out.println(p.getLength());
		p.remove(c2);
		System.out.println(p.getLength());
		System.out.println(p.contains(c2));
		System.out.println(p.remove(c2));
		Card[] card = p.toArray();
		
		for(int i = 0; i < card.length; i++) {
			System.out.println(card[i].getRank());
		}
		p.shuffle();
		card = p.toArray();
		for(int i = 0; i < card.length; i++) {
			System.out.println(card[i].getRank());
		}
	}
}
