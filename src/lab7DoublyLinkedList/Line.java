package lab7DoublyLinkedList;

public class Line {
	private Point2D start;
	private Point2D end;
	
	Line(double x1, double y1, double x2, double y2){
		start = new Point2D(x1,y1);
		end = new Point2D(x2,y2);
	}
	
	Line(Point2D s, Point2D e){
		start = s;
		end = e;
	}
	
	public Point2D getStart() {
		return start;
	}
	
	public void setStart(Point2D s) {
		start = s;
	}
	
	public Point2D getEnd() {
		return end;
	}
	
	public void setEnd(Point2D e) {
		end = e;
	}
	
	public void reverse() {
		Point2D temp = start;
		start = end;
		end = temp;
	}
	
	public boolean equals(Line l) {
		return (getStart().equals(l.getStart()) && getEnd().equals(l.getEnd()));
	}
	
	public String toString() {
		return String.format("[" + start + " , " + end + "]");
	}
}
