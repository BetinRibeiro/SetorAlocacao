package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Bin.Pessoa.Atendente;
import Bin.Pessoa.Telefone;
import Persistence.Dao;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

public class JFrmCadastroAtendente extends JDialog implements ActionListener,
		Cadastravel {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNumTelefone;
	private JTextField txtNome;
	private JDateChooser dtCadastro;

	String[] interesse = { "Contrato de Administração", "Contrado de Locação" };
	private JButton btnSalvarAlterar;
	private JButton btnCancelarDeletar;
	private JButton btnVisita;
	private Atendente atendenteParaAlterar = null;
	private Dao banco = new Dao();
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField txtObservacao;
	private JTextField txtNumeroCel;
	private JLabel lblNumeroCelular;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JPasswordField txtSenha;
	private JLabel lblSenha;
	private JPasswordField txtConfirmacao;
	private JLabel lblConfirmaoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadastroAtendente dialog = new JFrmCadastroAtendente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadastroAtendente(Atendente atendente) {
		setTitle("Cadastro de Atendente");
		setBounds(100, 100, 350, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 47, 314, 270);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 10, 65, 20);
		panel.add(lblCodigo);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(10, 30, 84, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		txtNumTelefone = new JTextField();
		txtNumTelefone.setColumns(10);
		txtNumTelefone.setBounds(10, 110, 135, 20);
		panel.add(txtNumTelefone);

		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 50, 147, 20);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 70, 287, 20);
		panel.add(txtNome);

		JLabel lblValorMaximo = new JLabel("Numero Celular");
		lblValorMaximo.setBounds(10, 90, 108, 20);
		panel.add(lblValorMaximo);

		dtCadastro = new JDateChooser(new java.util.Date());
		dtCadastro.setEnabled(false);
		dtCadastro.setBounds(191, 30, 106, 20);
		panel.add(dtCadastro);

		JLabel lblDataCadastro = new JLabel("Data Cadastro");
		lblDataCadastro.setBounds(191, 10, 106, 20);
		panel.add(lblDataCadastro);

		btnCancelarDeletar = new JButton("Cancelar");
		btnCancelarDeletar.setBounds(208, 224, 89, 23);
		panel.add(btnCancelarDeletar);

		btnSalvarAlterar = new JButton("Salvar");
		btnSalvarAlterar.setBounds(109, 224, 89, 23);
		panel.add(btnSalvarAlterar);

		btnVisita = new JButton("Visita");
		btnVisita.setBounds(10, 224, 89, 23);
		panel.add(btnVisita);

		txtNumeroCel = new JTextField();
		txtNumeroCel.setText("");
		txtNumeroCel.setColumns(10);
		txtNumeroCel.setBounds(155, 110, 135, 20);
		panel.add(txtNumeroCel);

		lblNumeroCelular = new JLabel("Numero Celular");
		lblNumeroCelular.setBounds(155, 90, 108, 20);
		panel.add(lblNumeroCelular);

		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 152, 287, 20);
		panel.add(txtEmail);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 132, 147, 20);
		panel.add(lblEmail);

		txtSenha = new JPasswordField();
		txtSenha.setText("");
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 193, 135, 20);
		panel.add(txtSenha);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 173, 108, 20);
		panel.add(lblSenha);

		txtConfirmacao = new JPasswordField();
		txtConfirmacao.setText("");
		txtConfirmacao.setColumns(10);
		txtConfirmacao.setBounds(155, 193, 135, 20);
		panel.add(txtConfirmacao);

		lblConfirmaoSenha = new JLabel("Confirma\u00E7\u00E3o Senha");
		lblConfirmaoSenha.setBounds(155, 173, 108, 20);
		panel.add(lblConfirmaoSenha);

		txtObservacao = new JTextField();
		txtObservacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtObservacao.setEnabled(false);
		txtObservacao.setBounds(10, 11, 314, 20);
		contentPane.add(txtObservacao);
		txtObservacao.setColumns(10);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		limparTxt();

		// quando a atendente for nula será para cadastrar uma atendente quando
		// ela
		// não for quer dizer que será feita uma alteração da atendente que foi
		// passada como parametro para isso temos mudar o texto do
		// btnSalvarAlterar para alterar, e ele vai ter uma função de
		// desbloquear as caixas de texto serão bloqueadas, nem sempre a
		// atendente
		// quer fazer uma alteração as vezes quer só consultar os dados
		if (atendente != null) {

			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setToolTipText("Deletar");
			inserir(atendente);
			txtEnable(false);
		}

		// aqui vou adicionar um observador dos botões para que quando um deles
		// for clicado a ação dele seja enviada para o metodo actionPerformed
		btnCancelarDeletar.addActionListener(this);
		btnSalvarAlterar.addActionListener(this);
		atendenteParaAlterar = atendente;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Alterar":
			liberarAlteracao();
			btnSalvarAlterar.setText("Salvar");
			btnCancelarDeletar.setText("Cancelar");
			break;
		case "Salvar":
			salvar();
			
			break;
		case "Cancelar":
			dispose();
			break;
		case "Novo":
			txtEnable(true);
			limparTxt();
			btnSalvarAlterar.setText("Salvar");
			btnCancelarDeletar.setText("Cancelar");
			break;
		case "Deletar":
			int op = JOptionPane.showConfirmDialog(contentPane,
					"Deseja realmente deletar?");
			System.out.println(op);
			if (op == 0) {
				JOptionPane.showMessageDialog(contentPane,
						"Você não tem autorização!");
			}
			break;

		default:
			break;
		}

	}

	@Override
	public void inserir(Object ob) {
		Atendente atendente = (Atendente) ob;
		txtId.setText(String.valueOf(atendente.getId()));
		txtNome.setText(String.valueOf(atendente.getNome()));
		txtNumTelefone.setText(String.valueOf(atendente.getTelefone()
				.getFone1()));
		txtNumeroCel
				.setText(String.valueOf(atendente.getTelefone().getFone2()));
		txtEmail.setText(atendente.getEmail());
		txtSenha.setText(atendente.getSenha());

	}

	@Override
	public void salvar() {
		String confirmacao;
		Atendente atendente = new Atendente();
		if (atendenteParaAlterar != null) {
			System.out.println("Este id :"+txtId.getText());
			atendente.setId(Integer.parseInt(txtId.getText()));
		}
		atendente.setNome(txtNome.getText());
		Telefone fone = new Telefone();
		fone.setFone1(Integer.parseInt(txtNumTelefone.getText()));
		fone.setFone2(Integer.parseInt(txtNumeroCel.getText()));

		atendente.setTelefone(fone);
		atendente.setEmail(txtEmail.getText());
		atendente.setSenha(String.valueOf(txtSenha.getPassword()));
		confirmacao = String.valueOf(txtConfirmacao.getPassword());
		System.out.println(" = - = " + atendente.getId());
		
		if (confirmacao.equalsIgnoreCase(atendente.getSenha())) {
			

			if (atendenteParaAlterar != null) {
				banco.salvarOuAtualizarObjeto(atendente);
				JOptionPane.showMessageDialog(contentPane,
						"atendente salvo com sucesso!");
				dispose();
			} else {
				banco.salvarObjeto(atendente);
				txtId.setText(String.valueOf(atendente.getId()));
				JOptionPane.showMessageDialog(contentPane,
						"atendente salvo com sucesso!");
			}

			if (!txtId.getText().equalsIgnoreCase("")) {

			}
			txtEnable(false);
			btnCancelarDeletar.setToolTipText("Novo");
			btnSalvarAlterar.setText("Alterar");

		} else {
			JOptionPane
					.showMessageDialog(
							contentPane,
							"A confirmação da senha não bate \n janela será fechada por motivo de segurança.");
			dispose();
		}
	}

	@Override
	public void liberarAlteracao() {
		btnSalvarAlterar.setToolTipText("Salvar");
		txtEnable(true);

	}

	@Override
	public void limparTxt() {
		txtId.setText("");
		txtNome.setText("");
		txtNumTelefone.setText("");
		dtCadastro.setDate(new java.util.Date());
		txtObservacao.setText("Atendente das Visitas e Usuario(a) do Sistema");

	}

	@Override
	public void txtEnable(boolean valor) {
		txtNome.setEnabled(valor);
		txtNumTelefone.setEnabled(valor);
		// dtCadastro.setEnabled(valor);
		txtEmail.setEnabled(valor);
		txtSenha.setEnabled(valor);
		txtConfirmacao.setEnabled(valor);
		txtNumeroCel.setEnabled(valor);

	}
}