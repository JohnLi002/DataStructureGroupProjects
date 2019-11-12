package project4Lists;

public class Game {
	private boolean PlayerFirst;
	private Player user;
	private Player computer;
	private Deck deck;
	
	public Game(String s) {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck(true);
		startGame();
	}
	
	private void startGame() {
		Hand h1 = new Hand(deck.deal());
		Hand h2 = new Hand(deck.deal());
		if(isPlayerFirst()) {
			user = new Player(h1,0,h1.getValue());
		}
	}

	public boolean isPlayerFirst() {
		return PlayerFirst;
	}

	public void setPlayerFirst(boolean playerFirst) {
		PlayerFirst = playerFirst;
	}

	public Player getUser() {
		return user;
	}

	public void setUser(Player user) {
		this.user = user;
	}

	public Dealer getComputer() {
		return computer;
	}

	public void setComputer(Dealer computer) {
		this.computer = computer;
	}
}
