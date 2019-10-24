package project3Queues;

public class Test {
	public static void main(String[] args) {
		System.out.println("==============ROUTE CLASS=============");
		Route orangeLine = new Route("orange.txt");
		orangeLine.initializeStations();
		orangeLine.print();
	}
}
