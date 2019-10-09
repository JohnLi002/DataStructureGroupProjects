package lab3Queues;

public class Passenger {
	private String id;
	private Station destination;
	
	public Passenger(String id, Station destination)
	{
		this.id = id;
		this.destination = destination;
	}
	public Passenger(Station destination)
	{
		this.destination = destination;
		this.id = "" + ((int)Math.random()*10) + ((int)Math.random()*10)
			+ ((int)Math.random()*10) + ((int)Math.random()*10) + ((int)Math.random()*10);
	}
	
	public String getId() {
		return id;
	}
	
	public Station getDestination() {
		return destination;
	}
	
	public String toString() {
		String s = String.format("%d, %s", id, destination.getName());
		
		return s;
	}
}
