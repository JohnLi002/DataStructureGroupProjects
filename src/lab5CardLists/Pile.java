package lab5CardLists;

public class Pile implements CardListInterface{
	private DoubleNode firstNode;
	private DoubleNode lastNode;
	private int numCards;
	
	public Pile() {
		firstNode = null;
		lastNode = null;
		numCards = 0;
	}
	
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
	
	public void shuffle()
	{
		//	SHUFFLE DECK
	}

	@Override
	public void add(Card aCard) {
		if(numCards == 0) {
			DoubleNode newNode = new DoubleNode(aCard);
			firstNode = newNode;
			lastNode = newNode;
		}
		
		
	}

	@Override
	public boolean remove(Card aCard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Card aCard) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}
}
