package lab9Trees;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface QueueInterface <T> {
	
	public void enqueue (T newEntry); //adds the object newEntry to the back of the queue
	
    public T dequeue (); //gets rid of the object at the front of the queue and returns said removed object
    
    public T getFront(); //returns what is at the front of the queue
    
    public boolean isEmpty(); //checks and returns whether or not something is empty
    
    public void clear(); //clears everything
    
}
