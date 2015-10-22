package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class JPnlContrato extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JButton button;
	private JLabel lblLocatario;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button_1;
	private JLabel lblPrimeiroFiador;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton button_2;
	private JLabel lblSegundFiador;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblValorDoCalo;
	private JTextField textField_8;
	private JLabel lblValorDoAluguel;
	private JTextField textField_9;
	private JLabel label_4;
	private JTextField textField_10;
	private JLabel lblAtendenteResponsavel;
	private JTextField textField_11;
	private JTextField textField_12;
	private JButton button_3;
	private JButton btnGerarContrato;
	private JTextField textField_13;
	private JLabel lblContratoUtilizado;
	private JTextField textField_14;
	private JButton button_4;
	private JButton btnImprimirContrato;
	private JDateChooser dtInicio;
	private JDateChooser dtFinal;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAlterar;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	private JButton btnVisualizar;
	private JLabel lblContrato;

	/**
	 * Create the panel.
	 */
	public JPnlContrato() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 599, 548);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 37, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 37, 372, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(488, 36, 89, 23);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("Imovel ");
		lblNewLabel.setBounds(10, 10, 184, 14);
		panel.add(lblNewLabel);
		
		button = new JButton("Buscar");
		button.setBounds(488, 92, 89, 23);
		panel.add(button);
		
		lblLocatario = new JLabel("Locatario");
		lblLocatario.setBounds(10, 68, 468, 14);
		panel.add(lblLocatario);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 93, 86, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(106, 93, 372, 20);
		panel.add(textField_3);
		
		button_1 = new JButton("Buscar");
		button_1.setBounds(488, 148, 89, 23);
		panel.add(button_1);
		
		lblPrimeiroFiador = new JLabel("Primeiro Fiador ");
		lblPrimeiroFiador.setBounds(10, 124, 468, 14);
		panel.add(lblPrimeiroFiador);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 149, 86, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(106, 149, 372, 20);
		panel.add(textField_5);
		
		button_2 = new JButton("Buscar");
		button_2.setBounds(488, 204, 89, 23);
		panel.add(button_2);
		
		lblSegundFiador = new JLabel("Segund Fiador");
		lblSegundFiador.setBounds(10, 180, 468, 14);
		panel.add(lblSegundFiador);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 205, 86, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(106, 205, 372, 20);
		panel.add(textField_7);
		
		lblValorDoCalo = new JLabel("Valor do Imovel");
		lblValorDoCalo.setBounds(10, 246, 113, 14);
		panel.add(lblValorDoCalo);
		
		textField_8 = new JTextField();
		textField_8.setBounds(10, 275, 86, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		lblValorDoAluguel = new JLabel("Valor do Aluguel");
		lblValorDoAluguel.setBounds(106, 246, 86, 14);
		panel.add(lblValorDoAluguel);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(106, 275, 86, 20);
		panel.add(textField_9);
		
		label_4 = new JLabel("Valor do Cal\u00E7\u00E3o");
		label_4.setBounds(202, 246, 113, 14);
		panel.add(label_4);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(202, 275, 86, 20);
		panel.add(textField_10);
		
		lblAtendenteResponsavel = new JLabel("Atendente Responsavel ");
		lblAtendenteResponsavel.setBounds(10, 306, 468, 14);
		panel.add(lblAtendenteResponsavel);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(10, 331, 86, 20);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(106, 331, 372, 20);
		panel.add(textField_12);
		
		button_3 = new JButton("Buscar");
		button_3.setBounds(488, 330, 89, 23);
		panel.add(button_3);
		
		btnGerarContrato = new JButton("Salvar Contrato");
		btnGerarContrato.setBounds(10, 514, 130, 23);
		panel.add(btnGerarContrato);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(10, 390, 86, 20);
		panel.add(textField_13);
		
		lblContratoUtilizado = new JLabel("Contrato Utilizado");
		lblContratoUtilizado.setBounds(10, 365, 468, 14);
		panel.add(lblContratoUtilizado);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(106, 390, 372, 20);
		panel.add(textField_14);
		
		button_4 = new JButton("Buscar");
		button_4.setBounds(488, 389, 89, 23);
		panel.add(button_4);
		
		btnImprimirContrato = new JButton("Imprimir Contrato");
		btnImprimirContrato.setBounds(150, 514, 130, 23);
		panel.add(btnImprimirContrato);
		
		dtInicio = new JDateChooser(new java.util.Date());
		dtInicio.setBounds(83, 444, 122, 20);
		panel.add(dtInicio);
		
		dtFinal = new JDateChooser(new java.util.Date());
		dtFinal.setBounds(225, 444, 122, 20);
		panel.add(dtFinal);
		
		lblDataInicial = new JLabel("Data inicial");
		lblDataInicial.setBounds(83, 419, 113, 14);
		panel.add(lblDataInicial);
		
		lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setBounds(222, 421, 113, 14);
		panel.add(lblDataFinal);
		
		lblContrato = new JLabel("Contrato");
		lblContrato.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContrato.setBounds(233, 0, 201, 24);
		panel.add(lblContrato);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(619, 11, 446, 504);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(619, 536, 88, 23);
		add(btnAlterar);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(717, 536, 88, 23);
		add(btnFinalizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(815, 536, 96, 23);
		add(btnCancelar);
		
		btnVisualizar = new JButton("Visualizar");
		btnVisualizar.setBounds(921, 536, 96, 23);
		add(btnVisualizar);

	}

}
