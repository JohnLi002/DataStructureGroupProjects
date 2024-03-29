package lab7DoublyLinkedList;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.Scanner;

public class PolygonTesting {

	public static void main(String[] args) {
		String filename = "polygon.txt";
			
		Polygon p = new Polygon(filename);
		DoublyLinkedList <Line> lines = p.getLines();
		lab7DoublyLinkedList.ListIterator<Line> it = lines.getIterator();
		
		Line prevLine = it.next();
		Line firstLine = prevLine;
		Line currLine, gapLine;
       /* the following piece is used in the bonus part
		* while (it.hasNext()) {
		*	currLine = it.next();
		* gapLine = Polygon.fillGap (prevLine, currLine);
		*  insert this line in the list 
		*
		* }
		* This piece is for bonus part
		* gapLine = Polygon.fillGap (prevLine, firstLine);
		* insert this line in the list 
		*/	
		it = lines.getIterator();
		while (it.hasNext())
			System.out.println (it.next());

		System.out.println ("======Now backwards======");
		while (it.hasPrevious())
			System.out.println (it.previous());
		
		System.out.println ("======Reverse======");	
		p.reverse();
		p.display();
		}
		
}