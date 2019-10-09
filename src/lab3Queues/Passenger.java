package lab3Queues;

public class Passenger {
	public int id;
	public Station destination;
	
	public Passenger(int id, Station destination)
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
