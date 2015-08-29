package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class JPnlLocatarios extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPnlLocatarios() {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 1055, 550);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1035, 470);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(10, 520, 89, 23);
		panel.add(btnVerificar);
		
		JLabel lblLocatariosEmContrato = new JLabel("Locatarios em Contrato");
		lblLocatariosEmContrato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocatariosEmContrato.setBounds(10, 10, 196, 20);
		panel.add(lblLocatariosEmContrato);
	}
}
