package pw.project.frame;

import java.awt.Font;

import javax.swing.JButton;

public final class MoveButton extends JButton {
	
	public MoveButton(String text) {
		super(text);
		setSize(90, 90);
		setFont(new Font("Tahoma", Font.PLAIN, 11));
	}

}
