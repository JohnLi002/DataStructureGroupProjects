package project4Lists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class DoubleNode {
	private Card card;
	private DoubleNode next;
	private DoubleNode prev;
	
	public DoubleNode(Card newCard) {
		card = newCard;
	}
	
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public DoubleNode getNext() {
		return next;
	}
	public void setNext(DoubleNode next) {
		this.next = next;
	}
	public DoubleNode getPrev() {
		return prev;
	}
	public void setPrev(DoubleNode prev) {
		this.prev = prev;
	}
}
