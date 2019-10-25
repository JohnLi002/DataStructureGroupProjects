package project3Queues;

public class Station {
	//queue of passengers
	private String name;
	private LinkedQueue<Passenger> passengers = new LinkedQueue<>();
	
	public Station(String s) {
		name = s;
	}
	
	public void add(Passenger anEntry) {
		passengers.enqueue(anEntry);
	}
	
	public String getName() {
		return name;
	}
	
	public void print() { //prints out name of station and all passengers inside station
		System.out.println("----------------------");
		System.out.println(name);
		System.out.println("Passengers Entering:");
		System.out.println("" + '\t' + "Passengers:" + '\n');
		if (!passengers.isEmpty()) {
			Passenger placeholder = passengers.getFront();
			Passenger temp;
			do {
				temp = passengers.dequeue();
				System.out.println(temp.toString());
				passengers.enqueue(temp);
			} while( !passengers.getFront().equals(placeholder) );
		}
		System.out.println("===================");
	}
}
