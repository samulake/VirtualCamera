package pw.project.frame;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import static pw.project.frame.VirtualCameraPointOperations.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class VirtualCameraFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private Screen screenPanel;
	JPanel basicDirectionButtonPanel = new JPanel();

	private ActionListener pointOperationListener = event -> {
		if (event.getSource() instanceof JButton) {
			JButton source = (JButton) event.getSource();
			screenPanel.cubes.stream().map(cube -> moveCube.apply(operationsMap.get(source.getParent().getName() + " " + source.getText()), cube))
					.collect(Collectors.toList());
			screenPanel.validate();
			screenPanel.repaint();
		}
	};

	public VirtualCameraFrame() {
		getContentPane().setLayout(null);

		screenPanel = new Screen();
		screenPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(0, 128, 0)));
		screenPanel.setBounds(10, 10, 942, 671);
		getContentPane().add(screenPanel);

		basicDirectionButtonPanel = new BasicOperationsButtonPanel(pointOperationListener);
		getContentPane().add(basicDirectionButtonPanel);
		basicDirectionButtonPanel.setLocation(985, 10);
		
		
		JPanel rotationButtonPanel = new JPanel();
		rotationButtonPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Obrót",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		rotationButtonPanel.setBounds(985, 273, 304, 184);
		getContentPane().add(rotationButtonPanel);
		rotationButtonPanel.setLayout(null);
		rotationButtonPanel.setName("Obrót");

		JButton button = new MoveButton("GÓRA");
		button.setBounds(110, 16, 80, 75);
		rotationButtonPanel.add(button);
		button.addActionListener(pointOperationListener);

		JButton button_1 = new MoveButton("LEWO");
		button_1.setBounds(6, 102, 80, 75);
		rotationButtonPanel.add(button_1);
		button_1.addActionListener(pointOperationListener);

		JButton button_2 = new MoveButton("DÓ£");
		button_2.setBounds(110, 102, 80, 75);
		rotationButtonPanel.add(button_2);
		button_2.addActionListener(pointOperationListener);

		JButton button_3 = new MoveButton("PRAWO");
		button_3.setBounds(217, 102, 80, 75);
		rotationButtonPanel.add(button_3);
		button_3.addActionListener(pointOperationListener);

		JPanel inclinationButtonPanel = new JPanel();
		inclinationButtonPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Przekrzywienie",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inclinationButtonPanel.setBounds(986, 513, 194, 98);
		getContentPane().add(inclinationButtonPanel);
		inclinationButtonPanel.setLayout(null);
		inclinationButtonPanel.setName("Przekrzywienie");

		JButton inclinationLeftButton = new MoveButton("LEWO");
		inclinationLeftButton.setBounds(6, 16, 80, 75);
		inclinationButtonPanel.add(inclinationLeftButton);
		inclinationLeftButton.addActionListener(pointOperationListener);
		inclinationLeftButton.addActionListener(pointOperationListener);

		JButton inclinationRightButton = new MoveButton("PRAWO");
		inclinationRightButton.setBounds(110, 16, 80, 75);
		inclinationButtonPanel.add(inclinationRightButton);
		inclinationRightButton.addActionListener(pointOperationListener);

		JPanel zoomButtonPanel = new JPanel();
		zoomButtonPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Zoom",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		zoomButtonPanel.setBounds(1192, 513, 87, 172);
		getContentPane().add(zoomButtonPanel);
		zoomButtonPanel.setLayout(null);
		zoomButtonPanel.setName("Zoom");

		JButton zoomPlus = new MoveButton("+");
		zoomPlus.setBounds(6, 16, 75, 75);
		zoomButtonPanel.add(zoomPlus);
		zoomPlus.setFont(new Font("Tahoma", Font.PLAIN, 33));
		zoomPlus.addActionListener(pointOperationListener);

		JButton zoomMinus = new MoveButton("-");
		zoomMinus.setBounds(6, 90, 75, 75);
		zoomButtonPanel.add(zoomMinus);
		zoomMinus.setFont(new Font("Tahoma", Font.PLAIN, 40));
		zoomMinus.addActionListener(pointOperationListener);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Virtual camera");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VirtualCameraFrame frame = new VirtualCameraFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
