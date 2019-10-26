package project3Queues;

public class Test {
	public static void main(String[] args) {
		System.out.println("==============ROUTE CLASS=============");
		Route orangeLine = new Route("orange.txt");
		Train t1 = new Train(0, false);
		
		orangeLine.initializeStations();
		Station[] station = orangeLine.getStation();
		for(int i = 0; i < 17; i++) {
			
		}
		t1.removePassengers(station[0]);
		orangeLine.print();
		t1.print();
	}
}
