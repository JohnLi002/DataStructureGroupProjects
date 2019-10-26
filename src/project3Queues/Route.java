package project3Queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Route {
	public static Station[] stations;

	public Route(String fileName) {
		//reads file 
		try(Scanner scan = new Scanner(new File(fileName));){
			stations = new Station[1];
			int temp = 0;
			while (scan.hasNextLine()) {
				if(temp >= stations.length) {
					stations = Arrays.copyOf(stations, stations.length + 1);
				}
				stations[temp] = new Station(scan.nextLine());
				temp++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void initializeStations() {
		for( Station eachStation : stations ) {
			int temp = (int)(Math.random()*16); //create random number which is also the number of passengers that will be added
			for(int i = 0; i < temp; i++) {
				eachStation.add( new Passenger(getRandomDestination(eachStation)) ); //use method to give Passenger random station
			}
		}
	}
	
	private Station getRandomDestination(Station origin) { //gives passenger a random destination
		Station dest;
		do {
			dest = stations[(int)(Math.random()*stations.length)]; //random station from array
		} while( dest.equals(origin) ); //makes sure that the destination and current station are different
		return dest;
	}
	
	public void print() {
		for(Station everyStation : stations) {
			everyStation.print();
			System.out.println();
		}
	}
	
	public String travel (Train t) {
		t.trainMove(stations.length);
		findAndDeletePassengers(t);
		String s = t.print() + stations[t.getCurrentIndex()].print();
		return s;
		//remove from train
		//add to Train(currStation)
		//currStation.addPassenger();
		//update current Index;
	}
	
	public void findAndDeletePassengers(Train t) {
		int i = t.getCurrentIndex();
		Passenger[] p = stations[i].toArray();
		LinkedQueue<Passenger> remove = new LinkedQueue<>();
		
		for(int ii = 0; ii < p.length; ii++) {
			if(passengerGetOn(t,p[ii])) {
				remove.enqueue(p[ii]);
			}
		}
		
		t.removePassengers(stations[i]);
		
		while(!remove.isEmpty()) {
			Passenger removed = remove.dequeue();
			stations[i].removePassenger(removed);
			t.addPassenger(removed);
		}
	}
	
	private Integer getIndex(Station s) {
		for(int i = 0; i < stations.length; i++) {
			if(stations[i].equals(s)) {
				return i;
			}
		}
		
		return null;
	}
	
	private boolean passengerGetOn(Train t, Passenger p) {
		int negPos = 1;
		if(!t.goingForward()) {//makes the final important number positive no matter what to make sure it is going in the right direction
			negPos = -1;
		}
		
		return negPos*(t.getCurrentIndex() - getIndex(p.getDestination())) > 0; //if going forward the passenger station will be greater
		//than where the train currently is at so the passenger must go on. If the train is going in reverse then the number should be 
		//negative which is why negPos is there
	}
	
	
	public Station[] getStation() {
		return stations;
	}
}
