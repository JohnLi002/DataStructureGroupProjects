package project4Lists;

public class Deck extends Pile{

	
	public Deck() {
		this(false);
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

	private void createDeck() {
		for(Suite s : Suite.values()) { //creates a standards unique 52 deck of playing cards
			for(Rank r : Rank.values()) {
				add(new Card(s, r));
			}
		}
	}
}