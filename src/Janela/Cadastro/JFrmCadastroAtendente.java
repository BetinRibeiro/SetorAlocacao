package Janela.Cadastro;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Bin.Pessoa.Atendente;
import Bin.Pessoa.Telefone;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("serial")
public class JFrmCadastroAtendente extends JFrmCadastro {

	private JTextField txtId;
	private JTextField txtNumTelefone;
	private JTextField txtNome;

	String[] interesse = { "Contrato de Administração", "Contrado de Locação" };
	private Atendente atendenteParaAlterar = null;
	private JTextField txtNumeroCel;
	private JLabel lblNumeroCelular;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JPasswordField txtSenha;
	private JLabel lblSenha;
	private JPasswordField txtConfirmacao;
	private JLabel lblConfirmaoSenha;
	private JDateChooser dtCadastro;

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
	public JFrmCadastroAtendente(Object obj) {
		super(obj);
		setTitle("Cadastro de Atendente");

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 770, 220);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 10, 65, 20);
		panel.add(lblCodigo);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(10, 30, 90, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblDataCadastro = new JLabel("Data Cadastro");
		lblDataCadastro.setBounds(190, 10, 110, 20);
		panel.add(lblDataCadastro);

		dtCadastro = new JDateChooser(new java.util.Date());
		dtCadastro.setEnabled(false);
		dtCadastro.setBounds(190, 30, 110, 20);
		panel.add(dtCadastro);

		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 50, 180, 20);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 70, 370, 20);
		panel.add(txtNome);

		JLabel lblValorMaximo = new JLabel("Numero Celular");
		lblValorMaximo.setBounds(400, 50, 200, 20);
		panel.add(lblValorMaximo);

		txtNumTelefone = new JTextField();
		txtNumTelefone.setColumns(10);
		txtNumTelefone.setBounds(400, 70, 200, 20);
		panel.add(txtNumTelefone);

		txtNumeroCel = new JTextField();
		txtNumeroCel.setText("");
		txtNumeroCel.setColumns(10);
		txtNumeroCel.setBounds(400, 110, 200, 20);
		panel.add(txtNumeroCel);

		lblNumeroCelular = new JLabel("Numero Celular");
		lblNumeroCelular.setBounds(400, 90, 200, 20);
		panel.add(lblNumeroCelular);

		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 110, 370, 20);
		panel.add(txtEmail);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 90, 370, 20);
		panel.add(lblEmail);

		txtSenha = new JPasswordField();
		txtSenha.setText("");
		txtSenha.setColumns(10);
		txtSenha.setBounds(50, 170, 200, 20);
		panel.add(txtSenha);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 150, 200, 20);
		panel.add(lblSenha);

		lblConfirmaoSenha = new JLabel("Confirma\u00E7\u00E3o Senha");
		lblConfirmaoSenha.setBounds(300, 150, 200, 20);
		panel.add(lblConfirmaoSenha);

		txtConfirmacao = new JPasswordField();
		txtConfirmacao.setText("");
		txtConfirmacao.setColumns(10);
		txtConfirmacao.setBounds(300, 170, 200, 20);
		panel.add(txtConfirmacao);

		btnSalvarAlterar.setBounds(597, 240, 89, 23);
		btnCancelarDeletar.setBounds(696, 240, 89, 23);
		txtObservacao.setBounds(10, 240, 577, 23);

		setBounds(100, 100, 800, 310);
		setAlwaysOnTop(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

	}

	public void inserir(Object ob) {
		try {

			Atendente atendente = (Atendente) ob;
			txtId.setText(String.valueOf(atendente.getId()));
			txtNome.setText(String.valueOf(atendente.getNome()));
			txtNumTelefone.setText(String.valueOf(atendente.getTelefone()
					.getFone1()));
			txtNumeroCel.setText(String.valueOf(atendente.getTelefone()
					.getFone2()));
			txtEmail.setText(atendente.getEmail());
			txtSenha.setText(atendente.getSenha());
		} catch (Exception e) {
			// TODO
		}

	}

	public void salvar() {
		try {

			String confirmacao;
			Atendente atendente = new Atendente();
			if (atendenteParaAlterar != null) {
				System.out.println("Este id :" + txtId.getText());
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
		} catch (Exception e) {
			// TODO
		}
	}

	public void liberarAlteracao() {
		try {
			btnSalvarAlterar.setToolTipText("Salvar");
			txtEnable(true);
		} catch (Exception e) {
			// TODO
		}

	}

	public void limparTxt() {
		try {
			txtId.setText("");
			txtNome.setText("");
			txtNumTelefone.setText("");
			dtCadastro.setDate(new java.util.Date());
			txtObservacao
					.setText("Atendente das Visitas e Usuario(a) do Sistema");
		} catch (Exception e) {
			// TODO
		}

	}

	public void txtEnable(boolean valor) {
		try {
			txtNome.setEnabled(valor);
			txtNumTelefone.setEnabled(valor);
			// dtCadastro.setEnabled(valor);
			txtEmail.setEnabled(valor);
			txtSenha.setEnabled(valor);
			txtConfirmacao.setEnabled(valor);
			txtNumeroCel.setEnabled(valor);
		} catch (Exception e) {
			// TODO
		}

	}
}