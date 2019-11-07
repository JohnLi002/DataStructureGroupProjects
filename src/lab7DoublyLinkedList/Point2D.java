package lab7DoublyLinkedList;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */
public class Point2D {
	private double start;
	private double end;

	public Point2D(double x1, double y1) {
		start = x1;
		end = y1;
	}

	public double getStart() {
		return start;
	}

	public void setStart(double start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(double end) {
		this.end = end;
	}
	
	public boolean equals(Point2D p) {
		return(getStart() == p.getStart() && getEnd() == p.getEnd()); //compare the points to identify if they are equal
	}
	
	public void reverse() {
		double temp = start;
		start = end;
		end = temp;
	}
	public String toString() {
		return String.format("(%.2f, %.2f)", start,end);
	}
}
