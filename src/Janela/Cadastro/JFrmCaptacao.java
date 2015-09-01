package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Bin.Captacao.Captacao;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class JFrmCaptacao extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_1;
	private JDateChooser dtData;
	
	String[] interesse = {"Contrato de Administração","Contrado de Locação"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCaptacao dialog = new JFrmCaptacao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCaptacao(Captacao captacao) {
		setTitle("Capta\u00E7\u00E3o de Clientes");
		setBounds(100, 100, 350, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 314, 415);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 10, 65, 20);
		panel.add(lblCodigo);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(10, 30, 84, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 150, 135, 20);
		panel.add(textField_3);
		
		JComboBox comboBox = new JComboBox(interesse);
		comboBox.setBounds(10, 110, 287, 20);
		panel.add(comboBox);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 50, 147, 20);
		panel.add(lblNomeCompleto);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 70, 287, 20);
		panel.add(textField_2);
		
		JLabel lblValorMaximo = new JLabel("Valor Minimo");
		lblValorMaximo.setBounds(10, 130, 108, 20);
		panel.add(lblValorMaximo);
		
		JLabel lblTipo = new JLabel("Interesse");
		lblTipo.setBounds(10, 90, 84, 20);
		panel.add(lblTipo);
		
		
		dtData = new JDateChooser(new java.util.Date());
		dtData.setEnabled(false);
		dtData.setBounds(191, 30, 106, 20);
		panel.add(dtData);
		
		JLabel lblDataCadastro = new JLabel("Data Cadastro");
		lblDataCadastro.setBounds(191, 10, 106, 20);
		panel.add(lblDataCadastro);
		
		JLabel lblValorMaximo_1 = new JLabel("Valor Maximo");
		lblValorMaximo_1.setBounds(162, 130, 108, 20);
		panel.add(lblValorMaximo_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 150, 135, 20);
		panel.add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 190, 287, 178);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 287, 178);
		panel_1.add(scrollPane);
		
		JTextArea txtrLocalizao = new JTextArea();
		txtrLocalizao.setText("Localiza\u00E7\u00E3o: \r\n\r\nPrefer\u00EAncia:\r\n\r\n");
		scrollPane.setViewportView(txtrLocalizao);
		
		JLabel label = new JLabel("Valor Minimo");
		label.setBounds(10, 170, 108, 20);
		panel.add(label);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(208, 379, 89, 23);
		panel.add(btnCancelar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(109, 379, 89, 23);
		panel.add(btnSalvar);
		
		JButton button = new JButton("Salvar");
		button.setBounds(10, 379, 89, 23);
		panel.add(button);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

	}
}
