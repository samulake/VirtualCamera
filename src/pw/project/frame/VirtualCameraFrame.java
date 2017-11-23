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
		if (event.getSource() instanceof MoveButton) {
			MoveButton source = (MoveButton) event.getSource();
			screenPanel.cubes.stream().map(cube -> moveCube.apply(source.getPointOperation(), cube))
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
		rotationButtonPanel.setName("Rotation");
		rotationButtonPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), rotationButtonPanel.getName(),
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		rotationButtonPanel.setBounds(985, 273, 304, 184);
		getContentPane().add(rotationButtonPanel);
		rotationButtonPanel.setLayout(null);
		

		JButton button = new MoveButton("UP", Point3DOperationsFactory.rotateVertical(true));
		button.setBounds(110, 16, 80, 75);
		rotationButtonPanel.add(button);
		button.addActionListener(pointOperationListener);

		JButton button_1 = new MoveButton("LEFT", Point3DOperationsFactory.rotateHorizontal(true));
		button_1.setBounds(6, 102, 80, 75);
		rotationButtonPanel.add(button_1);
		button_1.addActionListener(pointOperationListener);

		JButton button_2 = new MoveButton("DOWN", Point3DOperationsFactory.rotateVertical(false));
		button_2.setBounds(110, 102, 80, 75);
		rotationButtonPanel.add(button_2);
		button_2.addActionListener(pointOperationListener);

		JButton button_3 = new MoveButton("RIGHT", Point3DOperationsFactory.rotateHorizontal(false));
		button_3.setBounds(217, 102, 80, 75);
		rotationButtonPanel.add(button_3);
		button_3.addActionListener(pointOperationListener);

		JPanel inclinationButtonPanel = new JPanel();

		inclinationButtonPanel.setName("Tilt");
		inclinationButtonPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), inclinationButtonPanel.getName(),
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inclinationButtonPanel.setBounds(986, 513, 194, 98);
		getContentPane().add(inclinationButtonPanel);
		inclinationButtonPanel.setLayout(null);

		JButton inclinationLeftButton = new MoveButton("LEFT", Point3DOperationsFactory.tiltOnSide(true));
		inclinationLeftButton.setBounds(6, 16, 80, 75);
		inclinationButtonPanel.add(inclinationLeftButton);
		inclinationLeftButton.addActionListener(pointOperationListener);
		inclinationLeftButton.addActionListener(pointOperationListener);

		JButton inclinationRightButton = new MoveButton("RIGHT", Point3DOperationsFactory.tiltOnSide(false));
		inclinationRightButton.setBounds(110, 16, 80, 75);
		inclinationButtonPanel.add(inclinationRightButton);
		inclinationRightButton.addActionListener(pointOperationListener);

		JPanel zoomButtonPanel = new JPanel();

		zoomButtonPanel.setName("Zoom");
		zoomButtonPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), zoomButtonPanel.getName(),
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		zoomButtonPanel.setBounds(1192, 513, 87, 172);
		getContentPane().add(zoomButtonPanel);
		zoomButtonPanel.setLayout(null);

		JButton zoomPlus = new MoveButton("+", Point3DOperationsFactory.zoom(5));
		zoomPlus.setBounds(6, 16, 75, 75);
		zoomButtonPanel.add(zoomPlus);
		zoomPlus.setFont(new Font("Tahoma", Font.PLAIN, 33));
		zoomPlus.addActionListener(pointOperationListener);

		JButton zoomMinus = new MoveButton("-", Point3DOperationsFactory.zoom(-5));
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
