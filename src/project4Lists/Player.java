package project4Lists;

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

	public void addAceValue(boolean b) {
		if(b) {
			handValue += 10;
		} else {
			handValue -= 10;
		}
	}
	
	public void addCard(Card c) {
		hand.addCard(c);
		handValue = hand.getValue();
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHandValue() {
		return handValue;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}
	
	public int getNumAces() {
		return hand.getNumAces();
	}
}
