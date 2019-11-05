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
}
