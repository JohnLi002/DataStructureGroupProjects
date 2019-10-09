package lab3Queues;

public class Station {
	private String name;
	private LinkedQueue<Passenger> passengers = new LinkedQueue<>();
	
	public Station(String s) {
		name = s;
	}
	
	public void fill() {
		
	}
	
	public void add( Passenger anEntry )
	{
		passengers.enqueue(anEntry);
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println("----------------------");
		System.out.println(name);
		System.out.println("" + '\t' + "Passengers:" + '\n');
		/*
		 * have a for loop where we print each passenger on its own line
		 */
	}
}
