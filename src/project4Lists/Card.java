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

	public Suite getSuite() {
		return suite;
	}

	public void setSuite(Suite suite) {
		this.suite = suite;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public boolean equals(Card c) {
		return (getSuite().equals(c.getSuite()) && getRank().equals(c.getRank()));
	}
	
	public String toString() {
		return getRank() + " OF " + getSuite();
	}
}
