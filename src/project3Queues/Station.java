package project3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.util.Arrays;

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
	
	public Passenger[] toArray() {
		Passenger[] p;
		if(passengers.isEmpty()) {
			p = new Passenger[0];
			return p;
		} else {
			p = new Passenger[1];
		    p[0] = passengers.dequeue();
		    passengers.enqueue(p[0]);
		}
		
		int i = 1;
		while(!passengers.getFront().equals(p[0])) {
			p = Arrays.copyOf(p, p.length + 1); //expands array and adds new stuff if there are stuff that needs to be added
			p[i] = passengers.dequeue();
			passengers.enqueue(p[i]);
			i++;
		}
		
		return p;
	}
	
	public void removePassenger(Passenger p) {
		if(passengers.isEmpty()) {
			return; //return instantly ends method
		} else {
			Passenger first = passengers.dequeue();
			if(first.equals(p)) {
				return;
			}
			
			Passenger current = passengers.dequeue();
			while(!passengers.isEmpty() && !passengers.getFront().equals(first)) {
				if(!passengers.isEmpty() && current.equals(p)) { //this is activates the removed passenger was taken out, end method
					return;
				}
				passengers.enqueue(current); //puts incorrect passenger back into queue;
				current = passengers.dequeue(); //takes out first passenger
			}
		}
	}
	
	public void print() { //prints out name of station and all passengers inside station
		String s = "";
		s+=("\n----------------------");
		s+=("\n"+name);
		s+=("\nPassengers Entering:");
		s+=("\n" + '\t' + "Passengers:" + '\n');
		if (!passengers.isEmpty()) {
			Passenger placeholder = passengers.getFront();
			Passenger temp;
			do {
				temp = passengers.dequeue();
				s+=("\n"+temp.toString());
				passengers.enqueue(temp);
			} while( !passengers.getFront().equals(placeholder) );
		}
		s+=("\n===================");
		System.out.println(s);
	}
	
}
