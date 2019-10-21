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
	
	public void shuffle() //one idea, create an array, shuffle said array and recreate deck using the current order of array
	{
		
		//	SHUFFLE DECK
	}

	@Override
	public void add(Card aCard) {
		DoubleNode newNode = new DoubleNode(aCard);
		if(numCards == 0) {
			firstNode = newNode;
			lastNode = newNode;
		}
		
		newNode.setPrev(firstNode);
		firstNode = newNode;
	}

	@Override
	public boolean remove(Card aCard) {
		if(contains(aCard)) {
			return false;
		} else if(firstNode.getCard().equals(aCard)) { //this means if the found card is the first card, easy shortcut
			firstNode = firstNode.getNext();
		}
		
		DoubleNode current = firstNode;
		for(int i = 0; i < numCards && current.getNext() != null; i++) { //this loop is not finished yet
			if(current.getNext().getNext() != null && current.getNext().getCard().equals(aCard)) {
				current.setNext(current.getNext().getNext());
				return true;
			} else if(i == numCards - 1 &&current.getNext().getCard().equals(aCard)) {
				
			}
		}
		
		return false;
	}

	@Override
	public boolean contains(Card aCard) {
		DoubleNode current = firstNode;
		for(int i = 0; i < numCards; i++) {
			if(current.getCard().equals(aCard)) {
				return true;
			}
			current = current.getPrev();
		}
		return false;
	}

	@Override
	public int getLength() {
		return numCards;
	}
}
