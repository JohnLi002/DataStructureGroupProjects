package lab3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Route {
	public Station[] stations = new Station[17]; //17 because that is the number of stations in the orange.txt file
	
	public Route(String fileName) {
		//reads file 
		try(Scanner scan = new Scanner(new File(fileName));){
			int temp = 0;
			while (scan.hasNextLine()) {
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
}
