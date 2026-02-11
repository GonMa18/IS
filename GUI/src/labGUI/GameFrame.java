package labGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel East;
	private JPanel South;
	private JPanel Center;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JButton btnNewButton_4;
	private JPanel North;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.EAST);
		contentPane.add(getPanel_1_1(), BorderLayout.SOUTH);
		contentPane.add(getCenter(), BorderLayout.CENTER);
		contentPane.add(getPanel_2_1(), BorderLayout.NORTH);

	}
	private JPanel getPanel_1() {
		if (East == null) {
			East = new JPanel();
			East.setLayout(new GridLayout(0, 1, 0, 0));
			East.add(getRdbtnNewRadioButton());
			East.add(getRdbtnNewRadioButton_1());
			East.add(getRdbtnNewRadioButton_2());
			East.add(getRdbtnNewRadioButton_3());
		}
		return East;
	}
	private JPanel getPanel_1_1() {
		if (South == null) {
			South = new JPanel();
			South.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			South.add(getBtnNewButton());
			South.add(getBtnNewButton_1());
			South.add(getBtnNewButton_2());
			South.add(getBtnNewButton_3());
		}
		return South;
	}
	private JPanel getCenter() {
		if (Center == null) {
			Center = new JPanel();
			Center.setLayout(new GridLayout(0, 2, 0, 0));
			Center.add(getPanel_2());
			Center.add(getPanel_1_2());
		}
		return Center;
	}
	private JPanel getPanel_2() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(10, 10, 0, 0));
			for (int i = 0; i < 100; i++) panel.add(new JButton("@"+i));
		}
		return panel;
	}
	private JPanel getPanel_1_2() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(10, 10, 0, 0));
			for (int i = 0; i < 100; i++) panel_1.add(new JButton("#"+i));
		}
		return panel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("B1");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("B2");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("B3");
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("B4");
		}
		return btnNewButton_3;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("R1");
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("R2");
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("R3");
		}
		return rdbtnNewRadioButton_2;
	}
	private JRadioButton getRdbtnNewRadioButton_3() {
		if (rdbtnNewRadioButton_3 == null) {
			rdbtnNewRadioButton_3 = new JRadioButton("R3");
		}
		return rdbtnNewRadioButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("New button");
		}
		return btnNewButton_4;
	}
	private JPanel getPanel_2_1() {
		if (North == null) {
			North = new JPanel();
			North.add(getLblNewLabel());
		}
		return North;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Game");
		}
		return lblNewLabel;
	}
}
