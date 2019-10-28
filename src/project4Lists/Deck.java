package project4Lists;

public class Deck extends Pile{
	
	public Deck() {
		createDeck();
	}
	
	private void createDeck() {
		for(Suite s : Suite.values()) {
			for(Rank r : Rank.values()) {
				super.add(new Card(s.toString(), r.toString()));
			}
		}
		
	}
}
