package pw.project.frame;

import java.awt.Font;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.swing.JButton;

public final class MoveButton extends JButton {
	Function<Point3D, Point3D> pointOperation;
	{
		pointOperation = point -> point;
		
		setSize(90, 90);
		setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	
	public MoveButton(String text) {
		super(text);
	}
	
	public MoveButton(String text, Function<Point3D, Point3D> pointOperation) {
		this.pointOperation = pointOperation;
	}
	
	public Point3D doPointOperation(Point3D point) {
		return pointOperation.apply(point);
	}

}
