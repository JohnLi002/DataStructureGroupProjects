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

		for(int i = numCards - 1; i >= 0; i--) { //goes backwards, swapping card locations
			int random = (int) (Math.random() * i); //get random numbers
			Card temp = deck[random]; //saves object from random location
			deck[random] = deck[i]; //changes object in the random location with the one in the i location
			deck[i] = temp; //i location now has random object
		}

		clear(); //clears old pile
		for(int i = 0; i < deck.length; i++) { //replaces the pile with the brand new shuffled deck order
			add(deck[i]);
		}
	}

	@Override
	public void add(Card aCard) {
		DoubleNode newNode = new DoubleNode(aCard);
		if(numCards == 0) { //if there is no previous objects, the new card is both the front and back
			firstNode = newNode;
			lastNode = newNode;
		}
		//otherwise the card is added to the top (first node)
		newNode.setPrev(firstNode); 
		firstNode = newNode;
		numCards++;
	}

	@Override
	public Card remove(Card aCard) {
		if(!contains(aCard)) { //if the object is not found, then null is returned.
			return null; 
		} else if(firstNode.getCard().equals(aCard)) { //this means if the found card is the first card, easy shortcut
			Card removedCard = firstNode.getCard();
			firstNode = firstNode.getPrev();
			return removedCard;
		} else if(lastNode.getCard().equals(aCard)) { //is card is found in the last node
			Card removedCard = lastNode.getCard();
			lastNode = lastNode.getNext();
			return removedCard;
		} else { //is none of the other options are found, then the object must be somewhere in the middle
			DoubleNode current = firstNode;
			DoubleNode removedNode = null;

			for(int i = 0; i < numCards; i++) { //this loop is not finished yet
				if(current.getPrev().getCard().equals(aCard)) {
					removedNode = current.getPrev();
					current.setPrev(removedNode.getPrev()); //the one that is set is the once right after;
				}
			}
			return removedNode.getCard();
		}
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
