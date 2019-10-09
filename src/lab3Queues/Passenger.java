package lab3Queues;

public class Passenger {
	public String id;
	public Station destination;
	
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
	
	public int getId() {
		return id;
	}
	
	public Station getDestination() {
		return destination;
	}
}
