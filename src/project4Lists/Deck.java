package project4Lists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Deck extends Pile{
	
	public Deck() {
		this(true);
	}
	
	public Deck(boolean b) {
		createDeck();
		if(b) {
			shuffle();
		}
	}

	public Card draw() {
		Card c = getFirstNode().getCard(); //gets the card at the top of the deck
		remove(c); //remove said pile
		return c;
	}
	
	public Card[] deal() {
		Card[] c = new Card[2];
		for(int i = 0; !isEmpty() && i < c.length; i++) {
			c[i] = draw();
		}
		return c;
	}
	
	private void createDeck() {
		for(Suite s : Suite.values()) { //creates a standards unique 52 deck of playing cards
			for(Rank r : Rank.values()) {
				add(new Card(s, r));
			}
		}
	}
	
	public void redo() {
		clear();
		createDeck();
		shuffle();
	}
}