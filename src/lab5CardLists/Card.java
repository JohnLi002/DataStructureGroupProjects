package lab5CardLists;

public class Card {
	private Suite suite;;
	private Rank rank;
	
	public Card(String suite, String rank) {
		this.setSuite(Suite.valueOf(suite.toUpperCase()));
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
	
	
}
