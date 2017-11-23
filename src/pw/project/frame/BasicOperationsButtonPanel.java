package pw.project.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class BasicOperationsButtonPanel extends ButtonPanel {
	
	private double translationStep = 10;

	public BasicOperationsButtonPanel(String name, ActionListener actionListener) {
		super(name);
		initializeButtons(actionListener);
	}
	
	protected void initializeButtons(ActionListener actionListener) {
		add(new MoveButton("FORWARD", Point3DOperationsFactory.translationByOZ(-translationStep)));
		add(new MoveButton("UP", Point3DOperationsFactory.translationByOY(translationStep)));
		add(new MoveButton("BACK", Point3DOperationsFactory.translationByOZ(translationStep)));
		add(new MoveButton("LEFT", Point3DOperationsFactory.translationByOX(translationStep)));
		add(new MoveButton("DOWN", Point3DOperationsFactory.translationByOY(-translationStep)));
		add(new MoveButton("RIGHT", Point3DOperationsFactory.translationByOX(-translationStep)));

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
