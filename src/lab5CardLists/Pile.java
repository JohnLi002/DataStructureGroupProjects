package lab5CardLists;

public class Pile implements PileInterface{
	private DoubleNode firstNode;
	private DoubleNode lastNode;
	private int numCards;
	
	public DoubleNode getFirstNode() {
		return firstNode;
	}
	
	public void setFirstNode(DoubleNode firstNode) {
		this.firstNode = firstNode;
	}
	
	public DoubleNode getLastNode() {
		return lastNode;
	}
	
	public void setLastNode(DoubleNode lastNode) {
		this.lastNode = lastNode;
	}
	
	public int getNumCards() {
		return numCards;
	}
	
	public void setNumCards(int numCards) {
		this.numCards = numCards;
	}
}
