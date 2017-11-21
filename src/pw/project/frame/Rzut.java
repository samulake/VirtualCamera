package pw.project.frame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rzut {

    public static int d = 800;
    public static int e = 200;
    
	public static List<Point2D> rzut(Cube cube) {
        Iterator<? extends Point2D> iterator = cube.points.iterator();
        List<Point2D> points = new ArrayList<Point2D>();
        while(iterator.hasNext()) {
        	Point3D point = (Point3D) iterator.next();
            points.add(getPoint(point));
        }
        
        
        return points;
    }
    
    public static Point2D getPoint(Point3D point3D) {
    	if(point3D.z == 0)
    		point3D.z++;
        double x = ((point3D.x + e) * d)/point3D.z;
        double y = (point3D.y * d)/ point3D.z; 
        return new Point2D(x, y);
    }
}
