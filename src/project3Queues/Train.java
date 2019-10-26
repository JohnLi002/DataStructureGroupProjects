package project3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

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
	public void trainMove(int max) {
		if(currentIndex == 0) {
			goingForward = true;
		} else if (currentIndex == max) {
			goingForward = false;
		}
		
		if (goingForward) {
			currentIndex++;
		}
		else if (!goingForward) {
			currentIndex--;
		}
	}

	public void addPassenger(Passenger p) {
		passengers.enqueue(p);
	}
	
	public String removePassengers(Station s) {
		String words = "";
		words+=("\n----------------------");
		words+=("\nTrain");
		words+=("\nPassengers Exiting:");
		words+=("\n" + '\t' + "Passengers:" + '\n');
		
		if(passengers.isEmpty()) {
			return words; //return instantly ends method
		} 
		
		Passenger first = passengers.dequeue();
		while(first.getDestination().equals(s)) { //in case the passengers that need to leave are first
			if(passengers.isEmpty()) {
				return words;
			} else {
				words+=("\n"+first);
				first = passengers.dequeue();
			}
		}

		passengers.enqueue(first);
		Passenger current = null;
		while(!passengers.getFront().equals(first)) {
			current = passengers.dequeue(); //takes out first passenger
			while(!passengers.isEmpty() && current.getDestination().equals(s)){ //if the next passenger has to leave
				words+=("\n" + current);
				current = passengers.dequeue(); //continues till the correct passenger is one is found
			}
			passengers.enqueue(current); //puts incorrect passenger back into queue;
		}
		return words;
	}

	public LinkedQueue<Passenger> getPassengers() {
		return passengers;
	}

	public boolean goingForward() {
		return goingForward;
	}
}
