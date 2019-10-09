package lab3Queues;

public class TestQueue {
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.getFront());
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
		queue.clear();
		System.out.println(queue.isEmpty());
		
		System.out.println("==============ROUTE CLASS=============");
		
		Route orangeLine = new Route("orange.txt");
		orangeLine.initializeStations();
		orangeLine.print();
	}
}
