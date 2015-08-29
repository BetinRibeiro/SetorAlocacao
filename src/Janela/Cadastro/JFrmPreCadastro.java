package Janela.Cadastro;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

import Persistence.Dao;

public class JFrmPreCadastro extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEnd;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtFone1;
	private JTextField txtCel;
	private Dao banco = new Dao();
	private ArrayList<Integer> listaCargo = new ArrayList<Integer>();
	private JComboBox boxCargo;
	private JComboBox boxSexo;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField txtCep;
	private JComboBox boxUf;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnCadastrar;
	

	/**
	 * Create the frame.
	 * 
	 * @param idFuncionario
	 */
	public JFrmPreCadastro() {
		setTitle("Pre Cadastro");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);  

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 614, 389);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(10, 10, 60, 20);
		panel.add(label);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(10, 30, 120, 20);
		panel.add(txtId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 55, 60, 20);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(10, 75, 360, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		String[] a = { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Viuvo(a)",
				"Separado(a)" };

		String[] b = { "Ensino fundamental incompleto",
				"Ensino fundamental completo", "Ensino médio incompleto",
				"Ensino médio completo", "Ensino superior incompleto",
				"Ensino superior completo", "Pós-graduação", "Mestrado",
				"Doutorado" };

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(391, 58, 71, 14);
		panel.add(lblSexo);

		String[] c = { "Masculino", "Feminino" };
		boxSexo = new JComboBox(c);
		boxSexo.setBounds(391, 75, 125, 20);
		panel.add(boxSexo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 152, 594, 185);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblRua = new JLabel("Endere\u00E7o");
		lblRua.setBounds(10, 10, 111, 14);
		panel_2.add(lblRua);

		txtEnd = new JTextField();
		txtEnd.setBounds(10, 30, 414, 20);
		panel_2.add(txtEnd);
		txtEnd.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(434, 10, 82, 14);
		panel_2.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 55, 92, 14);
		panel_2.add(lblCidade);

		txtBairro = new JTextField();
		txtBairro.setBounds(434, 30, 150, 20);
		panel_2.add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 75, 250, 20);
		panel_2.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone ");
		lblTelefone.setBounds(10, 106, 82, 14);
		panel_2.add(lblTelefone);

		txtFone1 = new JTextField();
		txtFone1.setColumns(10);
		txtFone1.setBounds(10, 126, 150, 20);
		panel_2.add(txtFone1);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(170, 106, 98, 14);
		panel_2.add(lblCelular);

		txtCel = new JTextField();
		txtCel.setColumns(10);
		txtCel.setBounds(170, 126, 150, 20);
		panel_2.add(txtCel);

		txtCep = new JTextField();
		txtCep.setText("");
		txtCep.setColumns(10);
		txtCep.setBounds(270, 75, 150, 20);
		panel_2.add(txtCep);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(270, 55, 82, 14);
		panel_2.add(lblCep);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(434, 55, 46, 14);
		panel_2.add(lblUf);
		String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ",
				"RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };

		boxUf = new JComboBox(uf);
		boxUf.setBounds(434, 75, 71, 20);
		panel_2.add(boxUf);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 101, 60, 20);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 121, 360, 20);
		panel.add(txtEmail);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		button = new JButton("Liberar");
		button.setBounds(122, 348, 89, 23);
		panel.add(button);
		
		button_1 = new JButton("Salvar");
		button_1.setBounds(317, 348, 89, 23);
		panel.add(button_1);
		
		button_2 = new JButton("Deletar");
		button_2.setBounds(416, 348, 89, 23);
		panel.add(button_2);
		
		button_3 = new JButton("Sair");
		button_3.setBounds(515, 348, 89, 23);
		panel.add(button_3);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(221, 348, 89, 23);
		panel.add(btnCadastrar);
		
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	


}
