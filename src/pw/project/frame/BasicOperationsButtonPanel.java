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

		add(new MoveButton("FORWARD"));
		add(new MoveButton("UP"));
		add(new MoveButton("BACKWARD"));
		add(new MoveButton("LEFT"));
		add(new MoveButton("DÓŁ"));
		add(new MoveButton("RIGHT"));

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
