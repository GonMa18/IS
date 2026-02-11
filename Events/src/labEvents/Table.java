package labEvents;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Table extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;

	// Coordenadas seleccionadas (para mostrarlas en el panel derecho)
	private int fila = -1;
	private int columna = -1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table(5);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Table(int num) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(num), BorderLayout.CENTER);
		contentPane.add(getPanel_1(), BorderLayout.EAST);
	}

	private JPanel getPanel(int num) {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(num, num, 0, 0));

			// Crear todas las casillas aquí (sin método extra)
			for (int i = 0; i < num * num; i++) {

				JLabel lbl = new JLabel();
				lbl.setOpaque(true);
				lbl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				lbl.setBackground(Color.DARK_GRAY);

				lbl.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						JLabel labelClicado = (JLabel) e.getComponent();

						// índice dentro del panel (orden del GridLayout)
						int index = panel.getComponentZOrder(labelClicado);

						fila = index / num;
						columna = index % num;

						// Pintar casilla seleccionada
						labelClicado.setBackground(Color.RED);

						// Actualizar etiqueta de coordenadas
						getLblNewLabel_1().setText("X:" + fila + " & Y:" + columna);
					}
				});

				panel.add(lbl);
			}
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(4, 1, 0, 0));
			panel_1.add(getLblNewLabel_1());
			panel_1.add(getBtnNewButton());
			panel_1.add(getBtnNewButton_1());
			panel_1.add(getBtnNewButton_2());
		}
		return panel_1;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
		}
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
		}
		return btnNewButton_2;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("X:?? & Y:??");
		}
		return lblNewLabel_1;
	}
}
