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
	
	public void shuffle() {
		Card[] deck = toArray();
		
		for(int i = numCards - 1; i >= 0; i--) {
			int random = (int) (Math.random() * i);
			Card temp = deck[random];
			deck[random] = deck[i];
			deck[i] = temp;
		}
		
		clear();
		for(int i = 0; i < deck.length; i++) {
			add(deck[i]);
		}
		
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
		numCards++;
	}

	@Override
	public boolean remove(Card aCard) {
		if(contains(aCard)) {
			return false;
		} else if(firstNode.getCard().equals(aCard)) { //this means if the found card is the first card, easy shortcut
			firstNode = firstNode.getNext();
		}
		
		DoubleNode current = firstNode;
		for(int i = 0; i < numCards; i++) { //this loop is not finished yet
			
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
	
	public Card[] toArray() {
		Card[] deck = new Card[numCards];
		DoubleNode current = firstNode;
		for(int i = 0; i < numCards; i++) {
			deck[1] = current.getCard();
			current = current.getNext();
		}
		
		return deck;
	}

	@Override
	public boolean isEmpty() {
		return numCards == 0;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		numCards = 0;
	}
}
