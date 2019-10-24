package project3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

@SuppressWarnings("serial")
public class EmptyQueueException extends RuntimeException {

	public EmptyQueueException () {
		super ();
	}
	
	public EmptyQueueException (String info) {
		super (info);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
}
