package project4Lists;

public class Game {
	private boolean PlayerFirst;
	private Player user;
	private Player computer;
	private Deck deck;
	
	public Game() {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck(true);
		startGame();
	}
	
	public Game(int score) {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck(true);
		startGame(score);
	}
	public Game(int userScore, int computerScore) {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck(true);
		startGame(userScore, computerScore);
	}
	
	/**
	 * Creates new player class for both computer and user. It comes with the assumption there is no score for
	 * either of them.
	 */
	private void startGame() {
		Hand h1 = new Hand(deck.deal());
		Hand h2 = new Hand(deck.deal());
		if(isPlayerFirst()) {
			user = new Player(h1,0,h1.getValue());
			computer = new Player(h2, 0, h2.getValue());
		} else {
			user = new Player(h2,0,h2.getValue());
			computer = new Player(h1, 0, h1.getValue());
		}
		
	}
	
	/**
	 * Creates new player class for both computer and user. It comes with the assumption there the score is only
	 * for the player
	 * @param score of user
	 */
	private void startGame(int score) {
		Hand h1 = new Hand(deck.deal());
		Hand h2 = new Hand(deck.deal());
		
		if(isPlayerFirst()) {
			user = new Player(h1, score, h1.getValue());
			computer = new Player(h2, 0, h2.getValue());
		} else {
			user = new Player(h2, score, h2.getValue());
			computer = new Player(h1, 0, h1.getValue());
		}
		
		computerAce();
	}
	
	/**
	 * Creates new player class for both computer and user. It takes in two ints for the player score and player
	 * computer
	 * 
	 * @param uScore score of user 
	 * @param cScore score of computer
	 */
	private void startGame(int uScore, int cScore) {
		Hand h1 = new Hand(deck.deal());
		Hand h2 = new Hand(deck.deal());
		if(isPlayerFirst()) {
			user = new Player(h1, uScore, h1.getValue());
			computer = new Player(h2, cScore, h2.getValue());
		} else {
			user = new Player(h2, uScore, h2.getValue());
			computer = new Player(h1, cScore, h1.getValue());
		}
	}
	
	/**
	 * In order to make sure that the computer works correctly, this methods turns an ace value into
	 * 11 to computer if an ace is found. This is in order to get a value as close to 21 as possible.
	 */
	private void computerAce() {
		if(computer.getNumAces() >= 1) {
			computer.addAceValue(true);
		}
	}
	
	/**
	 * Returns the hand value of the user. Although a person can use the getUser method and then the getHandValue()
	 * method to obtain the said values, this method serves as a simple shortcut.
	 * 
	 * @return the total card value of the user's hand
	 */
	public int getHandValue() { //i know that you could just get the user to get the player in order to get the value
		return user.getHandValue(); //but i feel that having a single method for that is better
	}
	
	/**
	 * Returns the hand value of the computer. Although a person can use the getComputer method and then
	 * the getHandValue() method to obtain the said values, this method serves as a simple shortcut.
	 * 
	 * @return the total card value of the computer's hand
	 */
	public int getComputerValue() {
		return computer.getHandValue();
	}
	
	/**
	 * In Blackjack, a player automatically loses if their hand value goes over 21. The method returns if the player
	 * has lost because of this rule
	 */
	public boolean overValue() {
		return (getHandValue() > 21); 
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

	public Player getComputer() {
		return computer;
	}

	public void setComputer(Player computer) {
		this.computer = computer;
	}
}
