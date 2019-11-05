package lab7DoublyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polygon {
	DoublyLinkedList<Line> polygon;

	public Polygon(String filename) {
		polygon = new DoublyLinkedList<>();
		try {
			Scanner scan = new Scanner(new File(filename));
			Double[] d = new Double[4];
			int count = 0; 
			while(scan.hasNext()) {
				String s = scan.next();
				d[count%4] = stringToDouble(s);
				if(count != 0 && count%4 == 0) {
					addLine(d);
					System.out.println(polygon.getLength());
				}
				count++;
			}
			
			scan.close();
		} catch(FileNotFoundException ex) {
			System.out.println("file was not found");
		}
	}
	
	private void addLine(Double[] array) { //is only suppose to take an array with a size of 4
		Point2D p1 = new Point2D(array[0], array[1]);
		Point2D p2 = new Point2D(array[2], array[3]);
		polygon.add(new Line(p1,p2));
	}
	
	
	private double stringToDouble(String s) {
		StringBuilder string = new StringBuilder(s);
		int size = string.length();
		for(int i = 0; i < size; i++) {
			Character c = string.charAt(i);
			if(c < '0' || c > '9') {
				string.deleteCharAt(i);
				i--;
				size = string.length();
			}
		}
		
		Double result = Double.parseDouble(string.toString());
		return result;
	}
	
	public DoublyLinkedList<Line> getLines() {
		return polygon;
	}

	public void reverse() {
		

	}

	public void display() {

		
	}
}
