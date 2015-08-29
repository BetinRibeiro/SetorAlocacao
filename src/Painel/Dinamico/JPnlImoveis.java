package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class JPnlImoveis extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public JPnlImoveis() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JPanel panelAgendamento = new JPanel();
		panelAgendamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAgendamento.setBounds(10, 10, 1055, 295);
		add(panelAgendamento);
		panelAgendamento.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 1035, 205);
		panelAgendamento.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(10, 257, 89, 23);
		panelAgendamento.add(btnVerificar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 385, 1050, 145);
		panelAgendamento.add(panel);
		
		JLabel lblListaDeAgendamentos = new JLabel("Lista de Imoveis n\u00E3o Ocupados");
		lblListaDeAgendamentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDeAgendamentos.setBounds(10, 10, 324, 20);
		panelAgendamento.add(lblListaDeAgendamentos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 320, 1055, 240);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 1035, 160);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnContrato = new JButton("Contrato");
		btnContrato.setBounds(10, 210, 89, 23);
		panel_1.add(btnContrato);
		
		JLabel lblListaDePendencias = new JLabel("Lista de Imoveis Ocupados");
		lblListaDePendencias.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaDePendencias.setBounds(10, 11, 324, 20);
		panel_1.add(lblListaDePendencias);
		
		JButton button = new JButton("Verificar");
		button.setBounds(109, 210, 89, 23);
		panel_1.add(button);
		
	}
}
