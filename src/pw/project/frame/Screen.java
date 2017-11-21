package pw.project.frame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Screen extends JPanel{

	private static final long serialVersionUID = 1462982808179852065L;
	List<Cube> cubes;
    
    {
    	cubes = new ArrayList<>();
    	cubes.add(new Cube(new Point3D(100, 100, 1000), new Point3D(200, 200, 1200), 100, 200));
    	cubes.add(new Cube(new Point3D(200, 200, 2000), new Point3D(300, 300, 1200), 100, 100));
      	cubes.add(new Cube(new Point3D(-400, 200, 2000), new Point3D(-300, 300, 1200), 100, 100));
      	cubes.add(new Cube(new Point3D(-400, 200, 800), new Point3D(-300, 300, 1100), 100, 100));
        
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
    	super.paintComponent(graphics);
        cubes.stream().forEach(cube -> {
        	List<Point2D> points = Rzut.rzut(cube);
        	draw(graphics, points);
        });
        
    }
    
    public void draw(Graphics graphics, List<Point2D> points) {
    	Double screenMiddleX = (double) (this.getWidth()/2);
    	Double screenMiddleY = (double) (this.getHeight()/2);
    	Graphics2D graphics2D = (Graphics2D) graphics;
    	Point2D previousUpperBasePoint = new Point2D(points.get(4));
		Point2D previousLowerBasePoint = new Point2D(points.get(0));
		graphics2D.drawLine(
			previousUpperBasePoint.x.intValue() + screenMiddleX.intValue(), 
			previousUpperBasePoint.y.intValue() + screenMiddleY.intValue(),
			previousLowerBasePoint.x.intValue() + screenMiddleX.intValue(),
			previousLowerBasePoint.y.intValue() + screenMiddleY.intValue()
		);
		for (int i = 5; i < points.size(); i++) {
			Point2D upperBasePoint = new Point2D(points.get(i));
			Point2D lowerBasePoint = new Point2D(points.get(i - 4));
			graphics.drawLine(
				upperBasePoint.x.intValue() + screenMiddleX.intValue(),
				upperBasePoint.y.intValue() + screenMiddleY.intValue(),
				lowerBasePoint.x.intValue() + screenMiddleX.intValue(),
				lowerBasePoint.y.intValue() + screenMiddleY.intValue()
			);
			graphics.drawLine(
				previousUpperBasePoint.x.intValue() + screenMiddleX.intValue(), 
				previousUpperBasePoint.y.intValue() + screenMiddleY.intValue(), 
				upperBasePoint.x.intValue() + screenMiddleX.intValue(), 
				upperBasePoint.y.intValue() + screenMiddleY.intValue()
			);
			graphics.drawLine(
				previousLowerBasePoint.x.intValue() + screenMiddleX.intValue(), 
				previousLowerBasePoint.y.intValue() + screenMiddleY.intValue(), 
				lowerBasePoint.x.intValue() + screenMiddleX.intValue(), 
				lowerBasePoint.y.intValue() + screenMiddleY.intValue()
			);
			previousUpperBasePoint = new Point2D(upperBasePoint);
			previousLowerBasePoint = new Point2D(lowerBasePoint);
		}
		graphics.drawLine(
			points.get(7).x.intValue() + screenMiddleX.intValue(),
			points.get(7).y.intValue() + screenMiddleY.intValue(), 
			points.get(4).x.intValue() + screenMiddleX.intValue(), 
			points.get(4).y.intValue() + screenMiddleY.intValue()
		);
		graphics.drawLine(
			points.get(3).x.intValue() + screenMiddleX.intValue(),
			points.get(3).y.intValue() + screenMiddleY.intValue(), 
			points.get(0).x.intValue() + screenMiddleX.intValue(), 
			points.get(0).y.intValue() + screenMiddleY.intValue()
		);
	}
}
