package lab7DoublyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polygon {
	DoublyLinkedList<Line> polygon;
	
	public Polygon(String filename) {
		try {
			Scanner scan = new Scanner(new File(filename));
			
			
			scan.close();
		} catch(FileNotFoundException ex) {
			
		}
	}

	public DoublyLinkedList<Line> getLines() {
		return polygon;
	}

	public void reverse() {
		polygon.reverse();
		
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}
}
