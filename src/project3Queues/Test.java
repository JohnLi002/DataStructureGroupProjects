package project3Queues;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test {
	public static void main(String[] args) {
		System.out.println("==============ROUTE CLASS=============");
		Route orangeLine = new Route("orange.txt");
		Train t1 = new Train(0, false);
		try {
			orangeLine.initializeStations();
			Station[] station = orangeLine.getStation();
			for(int i = 0; i < 17; i++) {
				t1.removePassengers(station[i]);
			}
			
			PrintWriter printer = new PrintWriter("trains.txt");
			for (int i = 0; i < 60; i++)
			{
				if ( i % 10 == 9)
				{
					orangeLine.initializeStations();
				}
				printer.println(orangeLine.travel(t1));
			}
			printer.close();
		} catch(FileNotFoundException ex) {
			System.out.println ("trains.txt not found");
		}
		
	}
}
