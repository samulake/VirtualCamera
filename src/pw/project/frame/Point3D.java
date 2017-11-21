package pw.project.frame;

public class Point3D extends Point2D{
    Double z;
    
    public Point3D(double x, double y, double z) {
    	super(x,y);
        this.z = z;
    }
    
    public Point3D(Point3D point) {
    	super(point.x, point.y);
    	this.z = point.z;
    }
}
