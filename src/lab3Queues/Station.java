package lab3Queues;

public class Station {
	public String name;
	public LinkedQueue<Passenger> passengers = new LinkedQueue<>();
	
	public Station(String s) {
		name = s;
	}
}
