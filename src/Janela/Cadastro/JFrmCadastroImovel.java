package Janela.Cadastro;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;


public class JFrmCadastroImovel extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	

	/**
	 * Create the frame.
	 */
	public JFrmCadastroImovel() {
		setTitle("Cadastro de Im\u00F3vel");
		setBounds(100, 100, 760, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);  
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 724, 381);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigoDoImovel = new JLabel("C\u00F3digo do Imovel");
		lblCdigoDoImovel.setBounds(10, 10, 130, 14);
		panel.add(lblCdigoDoImovel);
		
		JLabel lblProprietario = new JLabel("Proprietario");
		lblProprietario.setBounds(10, 55, 108, 14);
		panel.add(lblProprietario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 254, 704, 107);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRua = new JLabel("Rua e Numero");
		lblRua.setBounds(10, 10, 93, 14);
		panel_1.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 55, 46, 14);
		panel_1.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(390, 10, 46, 14);
		panel_1.add(lblCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(610, 10, 46, 14);
		panel_1.add(lblUf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(256, 55, 46, 14);
		panel_1.add(lblCep);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(10, 25, 370, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(10, 70, 235, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(390, 25, 210, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(255, 70, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(610, 25, 58, 20);
		panel_1.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 704, 118);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(167, 10, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblPontoForte = new JLabel("Ponto Forte");
		lblPontoForte.setBounds(442, 55, 208, 14);
		panel.add(lblPontoForte);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(10, 25, 130, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(167, 25, 263, 20);
		panel.add(comboBox_1);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 100, 69, 14);
		panel.add(lblDescrio);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setBounds(10, 70, 320, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setEnabled(false);
		btnPesquisar.setBounds(341, 69, 89, 23);
		panel.add(btnPesquisar);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(440, 70, 274, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JCheckBox chckbxIndisponivel = new JCheckBox("Indisponivel");
		chckbxIndisponivel.setEnabled(false);
		chckbxIndisponivel.setBounds(442, 24, 97, 23);
		panel.add(chckbxIndisponivel);
		
		JButton btnLiberar = new JButton("Liberar");
		btnLiberar.setBounds(348, 403, 89, 23);
		contentPane.add(btnLiberar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(447, 403, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(546, 403, 89, 23);
		contentPane.add(btnDeletar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(645, 403, 89, 23);
		contentPane.add(btnSair);
	}
}
