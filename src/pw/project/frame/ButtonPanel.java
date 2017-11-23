package pw.project.frame;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public abstract class ButtonPanel extends JPanel {
	
	public ButtonPanel(String name) {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), name,
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setLayout(null);
	}
	
	protected abstract void initializeButtons(ActionListener actionListener);
}
