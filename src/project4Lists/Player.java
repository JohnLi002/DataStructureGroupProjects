package project4Lists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Player {
	private Hand hand;
	private int score; //how many victories so far?
	private int handValue; //total value in hand, may be redundant as Hand may already have it
	
	public Player() {
		this(null,0,0); //currently a placeholder for now
	}
	
	public Player(Hand h, int totalScore, int currentValue) {
		setHand(h);
		setScore(totalScore);
		setHandValue(currentValue);
	}
	
	/**
	 * An ace can either be 1 or 11. This method either adds 10 or subtracts 10 from the total handValue based on the
	 * boolean given in the parameter
	 * 
	 * @param b a boolean that will dictate if the value of hand should be subtracted or not
	 */
	public void addAceValue(boolean b) {
		if(b) {
			handValue += 10;
		} else {
			handValue -= 10;
		}
	}
	
	/**
	 * Adds a card to the player's hand
	 * 
	 * @param c Card to be added to player's hand
	 */
	public void addCard(Card c) {
		hand.addCard(c);
		handValue += hand.getValueCard(c); //adds so that the current value of ace is kept
	}
	
	
	/**
	 * returns the hand of the player
	 * 
	 * @return player's Hand
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * Sets the current hand to the hand given in the parameter
	 * 
	 * @param hand the Hand to replace the current Hand for player
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	/**
	 * Returns the score of the player. The score is the number of victories that te player has.
	 * 
	 * @return the score of the player.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the current score of the player to the score given in parameter
	 * 
	 * @param score an int that will replace the player's current score.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Returns the total value of the cards within the payer's hand
	 * 
	 * @return the total value of the cards in the Player's hand
	 */
	public int getHandValue() {
		return handValue;
	}

	/**
	 * Allows the handValue to be set to the handValue said in the parameter
	 * 
	 * @param handValue the int that will replace the handValue fo the player
	 */
	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}
	
	/**
	 * Returns the number of aces in the Player's hand
	 * 
	 * @return number of aces in the Player's Hand
	 */
	public int getNumAces() {
		return hand.getNumAces();
	}
	
	public void restart(Hand h) {
		hand = h;
		handValue = hand.getValue();
	}
	
	/**
	 * returns string of the hand as well as the score and hand value
	 * 
	 * @return returns the string of the hand
	 */
	public String toString() {
		String s = String.format("Score: %d%nHand Value: %d%n%s", score, handValue, hand.toString());
		return s;
	}
}
