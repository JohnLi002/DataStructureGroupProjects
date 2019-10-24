package lab5CardLists;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface CardListInterface {
	public void add(Card aCard);
//	....<other methods>
	public Card remove(Card aCard);
	public boolean contains(Card aCard);
	public int getLength();
	public boolean isEmpty();
	public void clear();
	
	
}
