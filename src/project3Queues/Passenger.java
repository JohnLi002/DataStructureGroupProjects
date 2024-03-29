package project3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

public class Passenger {
	private String id;
	private Station destination;
	
	public Passenger(String id, Station destination) {
		this.id = id;
		this.destination = destination;
	}
	public Passenger(Station destination) {
		this.destination = destination;
		this.id = "" + ((int)(Math.random()*10)) + ((int)(Math.random()*10))
			+ ((int)(Math.random()*10)) + ((int)(Math.random()*10)) + ((int)(Math.random()*10));
	}
	
	public String getId() {
		return id;
	}
	
	public Station getDestination() {
		return destination;
	}
	
	public String toString() {
		return "" + id + ", " + destination.getName();
	}
}
