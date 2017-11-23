package pw.project.frame;

import java.awt.Font;
import java.util.function.Function;

import javax.swing.JButton;

public final class MoveButton extends JButton {
	private Function<Point3D, Point3D> pointOperation;
	
	{
		pointOperation = point -> point;
		
		setSize(90, 90);
		setFont(new Font("Tahoma", Font.PLAIN, 11));
	}
	
	public MoveButton(String text) {
		super(text);
	}
	
	public MoveButton(String text, Function<Point3D, Point3D> pointOperation) {
		super(text);
		this.pointOperation = pointOperation;
	}

	public Point3D doPointOperation(Point3D point) {
		return pointOperation.apply(point);
	}

	public void setPointOperation(Function<Point3D, Point3D> pointOperation) {
		this.pointOperation = pointOperation;
	}

	public Function<Point3D, Point3D> getPointOperation() {
		return pointOperation;
	}
	
}
