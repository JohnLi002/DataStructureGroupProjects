package lab3Queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Route {
	public static Station[] stations;
	
	public Route(String fileName) {
		//rade file 
		try(Scanner scan = new Scanner(new File("orange.txt"));){
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initiallizeStations() {
		//for each statement generate a random number 0-15
		//for each passenger numbers, create new passenger
		//add it to queue
	}
	
	public static void main(String[] args) {
		
		
		
		
	}
}
