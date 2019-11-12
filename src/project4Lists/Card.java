package project4Lists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Card {
	private Suite suite;
	private Rank rank;
	
	public Card(String s, String r) {
		setSuite(Suite.valueOf(s.toUpperCase()));
		setRank(Rank.valueOf(r.toUpperCase()));
	}
	
	public Card(Suite s, Rank r) {
		suite = s;
		rank = r;
	}

	/**
	 * Simply returns what is the enem Suite of this card
	 * 
	 * @return returns the suite of this card
	 */
	public Suite getSuite() {
		return suite;
	}
	
	/**
	 * Sets the suite of this card to the suite given in the parameters
	 * 
	 * @param suite Suite to be set
	 */
	public void setSuite(Suite suite) {
		this.suite = suite;
	}
	
	/**
	 * Simply returns what is the enem Rank of this card
	 * 
	 * @return returns the rank of this card
	 */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Sets the rank of this card to the rank given in the parameters
	 * 
	 * @param rank Rank to be set
	 */
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	/**
	 * Returns whether or not this card and the other card given in the param are the same
	 * 
	 * @param c the other card being compared
	 * @return boolean of whether or not the two cards are the same.
	 */
	public boolean equals(Card c) {
		return (getSuite().equals(c.getSuite()) && getRank().equals(c.getRank()));
	}
	
	/**
	 * returns the card in a string format
	 * 
	 * @return returns the string of this card
	 */
	public String toString() {
		return getRank() + " OF " + getSuite();
	}
}
