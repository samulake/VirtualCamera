package pw.project.frame;

import java.util.ArrayList;
import java.util.List;

public class Cube {

	List<Point3D> points;

	public Cube(Point3D basePoint1, Point3D basePoint3, double plain, double height) {
		List<Point3D> points = new ArrayList<Point3D>();
		basePoint1.y = plain;
		basePoint3.y = plain;
		Point3D basePoint2, basePoint4;
		basePoint2 = new Point3D(basePoint3.x, plain, basePoint1.z);
		basePoint4 = new Point3D(basePoint1.x, plain, basePoint3.z);
		points.add(basePoint1);
		points.add(basePoint2);
		points.add(basePoint3);
		points.add(basePoint4);

		Point3D upperBasePoint1, upperBasePoint2, upperBasePoint3, upperBasePoint4;
		upperBasePoint1 = new Point3D(basePoint1);
		upperBasePoint1.y = plain + height;

		upperBasePoint2 = new Point3D(basePoint2);
		upperBasePoint2.y = plain + height;

		upperBasePoint3 = new Point3D(basePoint3);
		upperBasePoint3.y = plain + height;

		upperBasePoint4 = new Point3D(basePoint4);
		upperBasePoint4.y = plain + height;

		points.add(upperBasePoint1);
		points.add(upperBasePoint2);
		points.add(upperBasePoint3);
		points.add(upperBasePoint4);

		this.points = points;

	}
}
