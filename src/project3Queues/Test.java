package project3Queues;

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
			
			orangeLine.print();
			t1.print();
			PrintWriter printer = new PrintWriter("trains.txt");
			printer.println(orangeLine.travel(t1));
			printer.close();
		} catch(FileNotFoundException ex) {
			System.out.println ("trains.txt not found");
		}
		
	}
}
