package pw.project.frame;

import java.util.function.Function;

public class Point3DOperationsFactory {
	public static double rotateStep = 5;
	public static double zoomStep = 5;
	
	private Point3DOperationsFactory() {}

	public static Function<Point3D, Point3D> translationByOX(double translationStep) {
		return point -> {
			point.x += translationStep;
			return point;
		};
	}

	public static Function<Point3D, Point3D> translationByOY(double translationStep) {
		return point -> {
			point.y += translationStep;
			return point;
		};
	}

	public static Function<Point3D, Point3D> translationByOZ(double translationStep) {
		return point -> {
			point.z += translationStep;
			return point;
		};
	}

	public static Function<Point3D, Point3D> rotateHorizontal(boolean rotateLeft) {
		double coefficient = rotateLeft ? -1 : 1;
		double radians = coefficient * rotateStep * Math.PI/180;
		return point -> {
			point.x = point.x * Math.cos(radians) - point.z * Math.sin(radians);
			point.z = point.x * Math.sin(radians) + point.z * Math.cos(radians);
			return point;
		};
	}
	
	public static Function<Point3D, Point3D> rotateVertical(boolean rotateUp) {
		double coefficient = rotateUp ? -1 : 1;
		double radians = coefficient * rotateStep * Math.PI/180;
		
		return point -> {
			point.y = point.y * Math.cos(radians) - point.z * Math.sin(radians);
			point.z = point.y * Math.sin(radians) + point.z * Math.cos(radians);
			return point;
		};
	}
	
	public static Function<Point3D, Point3D> tiltOnSide(boolean tiltLeft) {
		double coefficient = tiltLeft ? 1 : -1;
		double radians = coefficient * rotateStep * Math.PI/180;
		
		return point -> {
			point.x = point.x * Math.cos(radians) + point.y * Math.sin(radians);
			point.y = -1*point.x * Math.sin(radians) + point.y * Math.cos(radians);
			return point;
		};
	}
	
	public static Function<Point3D, Point3D> zoom(double zoomStep) {
		
		return point -> {
			Rzut.d += zoomStep;
			return point;
		};
	}
}