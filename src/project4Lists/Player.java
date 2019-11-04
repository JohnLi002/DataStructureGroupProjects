package project4Lists;

public class Player {
	private String name;
	private Hand hand;
	private int score; //how many victories so far?
	private int handValue; //total value in hand, may be redundant as Hand may already have it
	
	public Player() {
		this("",null,0,0); //currently a placeholder for now
	}
	
	public Player(String s, Hand h, int totalScore, int currentValue) {
		setName(s);
		setHand(h);
		setScore(totalScore);
		setHandValue(currentValue);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
}
