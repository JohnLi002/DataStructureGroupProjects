package project3Queues;

import java.util.Arrays;

public class Train {
	private int currentIndex;
	//private BagInterface<Passsenger> trainPassengers;
	private boolean goingForward; //if the direction is true, the direction is up, false if it is down
	private LinkedQueue<Passenger> passengers = new LinkedQueue<>();
	
	public Train(int startPosition, boolean direction) {
		currentIndex = startPosition;
		goingForward = direction;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	//this method will be the train moving from station to another
	public void trainMove() {
		if (goingForward) {
			currentIndex++;
		}
		else if (!goingForward) {
			currentIndex--;
		}
	}
	
	public void removePassengers(Station s) {
		if(passengers.isEmpty()) {
			return; //return instantly ends method
		} else {
			Passenger first = passengers.dequeue();
			while(first.getDestination().equals(s)) { //incase the passengers that need to leave are first
				if(passengers.isEmpty()) {
					return;
				} else {
					first = passengers.dequeue();
				}
			}
			
			passengers.enqueue(first);
			Passenger current = null;
			while(!passengers.getFront().equals(first)) {
				current = passengers.dequeue(); //takes out first passenger
				while(!passengers.isEmpty() && current.getDestination().equals(s)){ //if the next passenger has to leave
					current = passengers.dequeue(); //continues till the correct passenger is one is found
				}
				passengers.enqueue(current); //puts incorrect passenger back into queue;
			}
		}
	}
	
	public void print() { //prints out name of station and all passengers inside station
		System.out.println("----------------------");
		System.out.println("Passengers exiting:");
		System.out.println("" + '\t' + "Passengers:" + '\n');
		if (!passengers.isEmpty())
		{
			Passenger placeholder = passengers.getFront();
			Passenger temp;
			do{
				temp = passengers.dequeue();
				System.out.println(temp.toString());
				passengers.enqueue(temp);
			} while( !passengers.getFront().equals(placeholder) );
		}
		System.out.println("===================");
	}
	
	public LinkedQueue<Passenger> getPassengers() {
		return passengers;
	}

	public boolean goingForward() {
		// TODO Auto-generated method stub
		return goingForward;
	}
}
