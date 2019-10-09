package lab3Queues;

public class Passenger {
	public String id;
	public Station destination;
	
	public Passenger(String id, Station destination)
	{
		this.id = id;
		this.destination = destination;
	}
	
	public int getId() {
		return id;
	}
	
	public Station getDestination() {
		return destination;
	}
}
