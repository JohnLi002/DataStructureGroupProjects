package lab3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public interface QueueInterface <T> {
    public void enqueue (T newEntry);
    public T dequeue ();
    public T getFront();
    public boolean isEmpty();
    public void clear();
}
