package lab5CardLists;

public class Card {
	private Suite suite;
	private Rank rank;
	
	public Card(String s, String r) {
		setSuite(Suite.valueOf(s.toUpperCase()));
		setRank(Rank.valueOf(r.toUpperCase()));
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
}
