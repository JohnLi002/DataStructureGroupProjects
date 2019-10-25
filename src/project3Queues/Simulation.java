package project3Queues;

import java.util.Scanner;
public class Simulation {
	public static int runTimeMinutes = 60;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Route orangeLine = new Route("orange.txt");
		
		Train t1 = new Train(0, false);
		Train t2 = new Train(10, true);
		
		//	HOW TIME PASSES
		//	Also must remember what 
		for (int i = 0; i <= runTimeMinutes; i++) {
			//every 10 minutes fill stations with passengers
			if (runTimeMinutes % 10 == 0) {
				orangeLine.initializeStations();
			}
			
		}
		
		scan.close();
	}
}
