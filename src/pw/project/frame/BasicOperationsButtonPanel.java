package pw.project.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class BasicOperationsButtonPanel extends JPanel {

	public BasicOperationsButtonPanel(ActionListener actionListener) {
		setName("Basic");
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), getName(),
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		add(new MoveButton("FORWARD", Point3DOperationsFactory.translationByOZ(-20)));
		add(new MoveButton("UP", Point3DOperationsFactory.translationByOY(20)));
		add(new MoveButton("BACK", Point3DOperationsFactory.translationByOZ(20)));
		add(new MoveButton("LEFT", Point3DOperationsFactory.translationByOX(20)));
		add(new MoveButton("DOWN", Point3DOperationsFactory.translationByOY(-20)));
		add(new MoveButton("RIGHT", Point3DOperationsFactory.translationByOX(-20)));

		setLayout(null);

		int buttonsPerRow = 3;
		int startX = 10, startY = 20;
		int locationX = startX, locationY = startY;

		if (getComponentCount() > 0) {
			setSize(
					startX * 2 + getComponent(0).getWidth() * buttonsPerRow,
					startY * 2 + getComponent(0).getHeight()
							* (getComponentCount() % 3 == 0
									? getComponentCount() / 3
									: getComponentCount() / 3 + 1));
		}
		for (int i = 0; i < getComponentCount(); i++) {
			Component component = getComponent(i);

			if (component instanceof MoveButton) {
				JButton button = (MoveButton) component;
				button.addActionListener(actionListener);
				button.setLocation(locationX, locationY);
				locationX = locationX += button.getWidth();
				if (locationX + button.getWidth() > getWidth()) {
					locationX = startX;
					locationY += button.getHeight();
				}
			}
		}

	}
}
