package project3Queues;

public class Train {
	private int currentIndex;
	//private BagInterface<Passsenger> trainPassengers;
	private boolean direction;
	private int maxTime = 0;
	
	public Train(int time) {
		maxTime = time;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	//this method will be the train moving from station to another
	public void trainMove(int transportTime) {
		int time = transportTime;
		
	}
}
