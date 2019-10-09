package lab3Queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Route {
	public Station[] stations;
	
	private Station getRandomDestination(Station origin)
	{
		Station dest;
		do
		{
			dest = stations[(int)(Math.random()*stations.length)];
		}while( !dest.equals(origin) );
		return dest;
	}
	
	public Route(String fileName) {
		//read file 
		try(Scanner scan = new Scanner(new File("" + fileName));){
			int temp = 0;
			while (scan.hasNextLine())
			{
				stations[temp] = new Station(scan.nextLine());
				temp++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializeStations() {
		//for each statement generate a random number 0-15
		//for each passenger numbers, create new passenger
		//add it to queue
		for( Station eachStation : stations )
		{
			for(int i = 0; i < ((int)Math.random()*16); i++)
			{
				eachStation.add( new Passenger(getRandomDestination(eachStation)) );
			}
		}
	}
	
	public void print()
	{
		for(Station everyStation : stations) {
			everyStation.print();
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		//	CONSIDER DELETING MAIN
		//	FOR "MAIN" LOOK TO TestQueue.java
	}
}
