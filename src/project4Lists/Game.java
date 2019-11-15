package project4Lists;

public class Game {
	private boolean PlayerFirst;
	private Player user;
	private Player computer;
	private Deck deck;
	
	public Game() {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck();
		startGame();
	}
	
	public Game(int score) {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck();
		startGame(score);
	}
	
	public Game(int userScore, int computerScore) {
		int result = (int) (Math.random() * 2);
		setPlayerFirst((result == 0));
		deck = new Deck();
		startGame(userScore, computerScore);
	}
	
	/**
	 * Restarts the game by shuffling deck and redistributing cards to both players
	 * 
	 * @param i is the ent that represents who won in the game. 1 is the player, 0 is a draw, any other num is a draw
	 */
	public void restart(int i) { //this method will restart the game
		deck.redo();
		if(i == 1) { //incomplete
			user.setScore(user.getScore() + 1);
		} else if(i == 0) {
			computer.setScore(computer.getScore() + 1);
		} //if the number is neither 1 or 0, then the result must be a draw. No one gets an increase to the score.
		Hand h1 = new Hand(deck.deal());
		Hand h2 = new Hand(deck.deal());
		user.restart(h1);
		computer.restart(h2);
	}
	
	/**
	 * Cards a card for the user
	 * 
	 * @return new user hand value
	 */
	public int drawCard() {
		user.addCard(deck.draw());
		
		return user.getHandValue();
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
		
		computerAce();
	}
	
	/**
	 * Creates new player class for both computer and user. It comes with the assumption there the score is only
	 * for the player
	 * 
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
		
		computerAce();
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
	 * Checks if the user is the winner
	 * 
	 * @return who has the bigger hand value after checking if the player's hand is over 21
	 */
	public boolean winner() {
		if(overValue()) {
			return false;
		}
		
		return user.getHandValue() > computer.getHandValue();
	}
	
	/**
	 * In Blackjack, a player automatically loses if their hand value goes over 21. The method returns if the player
	 * has lost because of this rule
	 * 
	 * @return whether or not the user has lost
	 */
	public boolean overValue() {
		return (getHandValue() > 21); 
	}
	
	/**
	 * returns the boolean PlayerFirst which dictates if the player goes first
	 * 
	 * @return boolean of whether or not the player goes first
	 */
	public boolean isPlayerFirst() {
		return PlayerFirst;
	}
	

	/**
	 * sets the current boolean of playerFirst with the one in the parameter
	 * 
	 * @param playerFirst the boolean to replace the current PlayerFirst
	 */
	public void setPlayerFirst(boolean playerFirst) {
		PlayerFirst = playerFirst;
	}

	/**
	 * returns the Player for user
	 * 
	 * @return user player
	 */
	public Player getUser() {
		return user;
	}

	/**
	 * sets the current user Player with the Player given in the parameter
	 * 
	 * @param user the player that will replace the user's Player within game
	 */
	public void setUser(Player user) {
		this.user = user;
	}

	/**
	 * returns computer
	 * 
	 * @return Player of computer
	 */
	public Player getComputer() {
		return computer;
	}

	/**
	 * sets the current computer Player with the Player given in the parameter
	 * 
	 * @param computer the player that will replace the computer's Player within game
	 */
	public void setComputer(Player computer) {
		this.computer = computer;
	}
	
	/**
	 * checks if the user has any aces in their hand
	 * 
	 * @return a boolean of if the player has any aces
	 */
	public boolean hasAces() {
		return user.getNumAces() > 0;
	}
}
