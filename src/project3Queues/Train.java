package project3Queues;

public class Train {
	private int currentIndex;
	//private BagInterface<Passsenger> trainPassengers;
	private boolean direction;
	
	public Train(int startPosition, boolean direction) {
		currentIndex = startPosition;
		this.direction = direction;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	//this method will be the train moving from station to another
	public void trainMove() {
		if (direction) {
			currentIndex++;
		}
		else if (!direction) {
			currentIndex--;
		}
		
	}
}
