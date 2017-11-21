package pw.project.frame;

public class Point2D {
	Double x, y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2D(Point2D point) {
		this(point.x, point.y);
	}
}
