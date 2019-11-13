package project4Lists;

public class Hand extends Pile{	
	private int numAces;
	
	public Hand(Card[] cards) {
		setNumAces(0);
		for(Card card : cards) {
			addCard(card);
		}
	}
	
	/**
	 * Takes in the next card to be added to Hand
	 * 
	 * @param c the Card to be added
	 */
	public void addCard(Card c) {
		add(c);
		if(c.getRank().equals(Rank.ACE)) { //makes sure the number of aces are correct
			numAces++;
		}
	}
	
	/**
	 * Takes every card in hand and puts it into an array to be returned
	 * 
	 * @return returns cards in Hand in a Array format
	 */
	
	public Card[] getHand() {
		Card[] c =  new Card[getNumCards()];
		
		for(int i= 0; i < c.length; i++) {
			c[i] = getLastNode().getCard(); //takes the first card
			remove(c[i]); //removes said card
		}
		
		for(Card cards: c) { //adds back all cards taken out
			add(cards);
		}
		
		return c;
	}
	
	/**
	 * Looks at the value of every card in Hand and returns the total value
	 * 
	 * @return returns the total value of all cards in Hand
	 */
	public int getValue() {
		int result = 0;
		Card[] c = getHand();
		
		for(Card cards: c) {
			result += getValueCard(cards);
		}
		
		return result;
	}
	
	/**
	 * Looks at the Rank of the given card and returns a value based on the rank of the given card
	 * 
	 * @param c Card that is given to get the value of
	 * @return returns value of a card
	 */
	public int getValueCard(Card c) {
		Rank r = c.getRank();
		switch (r) {
			case ACE:
				return 1; //ACE can be either 1 or 11, user chooses whether to use one or eleven in the game
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			case SIX:
				return 6;
			case SEVEN:
				return 7;
			case EIGHT:
				return 8;
			case NINE:
				return 9;
			default: //The rank must be either TEN, JACK, KING, or QUEEN who all have the same value;
				return 10;
		}
	}
	
	/**
	 * Returns what is the number of aces that is within this hand
	 * 
	 * @return returns the number of aces in this Hand
	 */
	public int getNumAces() {
		return numAces;
	}
	
	/**
	 * Replaces the int numAces with the new int given in the parameter
	 * 
	 * @param numAces the new number of aces
	 */
	public void setNumAces(int n) {
		this.numAces = n;
	}
	
	public String toString() {
		Card[] c = toArray();
		String s = "[";
		for(int i = 0; i < c.length; i++) {
			s += c[i].toString();
			if(i != c.length - 1) {
				s += "; ";
			}
		}
		
		s += "]";
		
		return s;
	}
}
