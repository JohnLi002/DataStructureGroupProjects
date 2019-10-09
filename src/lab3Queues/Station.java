package lab3Queues;

public class Station {
	public String name;
	private LinkedQueue<Passenger> passengers = new LinkedQueue<>();
	
	public Station(String s) {
		name = s;
	}
	
	public void fill() {
		
	}
}
