package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Bin.Captacao.Captacao;
import Persistence.Dao;

import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JFrmCaptacao extends JDialog implements ActionListener,Cadastravel {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNumTelefone;
	private JTextField txtNome;
	private JTextField txtValorMed;
	private JDateChooser dtCadastro;

	String[] interesse = { "Contrato de Administração", "Contrado de Locação" };
	private JButton btnSalvarAlterar;
	private JButton btnCancelarDeletar;
	private JButton btnVisita;
	private Captacao captacaoParaAlterar=null;
	private JTextArea txtDescricao;
	private JComboBox boxInteresse;
	private Dao banco=new Dao();
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField txtObservacao;
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
		setBounds(100, 100, 350, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 47, 314, 415);
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
		txtNumTelefone.setBounds(10, 150, 135, 20);
		panel.add(txtNumTelefone);

		 boxInteresse = new JComboBox(interesse);
		boxInteresse.setBounds(10, 110, 287, 20);
		panel.add(boxInteresse);

		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 50, 147, 20);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 70, 287, 20);
		panel.add(txtNome);

		JLabel lblValorMaximo = new JLabel("Numero Telefone");
		lblValorMaximo.setBounds(10, 130, 108, 20);
		panel.add(lblValorMaximo);

		JLabel lblTipo = new JLabel("Interesse");
		lblTipo.setBounds(10, 90, 84, 20);
		panel.add(lblTipo);

		dtCadastro = new JDateChooser(new java.util.Date());
		dtCadastro.setEnabled(false);
		dtCadastro.setBounds(191, 30, 106, 20);
		panel.add(dtCadastro);

		JLabel lblDataCadastro = new JLabel("Data Cadastro");
		lblDataCadastro.setBounds(191, 10, 106, 20);
		panel.add(lblDataCadastro);

		JLabel lblValorMaximo_1 = new JLabel("Valor M\u00E9dio");
		lblValorMaximo_1.setBounds(162, 130, 108, 20);
		panel.add(lblValorMaximo_1);

		txtValorMed = new JTextField();
		txtValorMed.setColumns(10);
		txtValorMed.setBounds(162, 150, 135, 20);
		panel.add(txtValorMed);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 190, 287, 178);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 287, 178);
		panel_1.add(scrollPane);

		 txtDescricao = new JTextArea();
		txtDescricao
				.setText("Localiza\u00E7\u00E3o: \r\n\r\nPrefer\u00EAncia:\r\n\r\n");
		scrollPane.setViewportView(txtDescricao);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 170, 108, 20);
		panel.add(lblDescrio);

		 btnCancelarDeletar = new JButton("Cancelar");
		btnCancelarDeletar.setBounds(208, 379, 89, 23);
		panel.add(btnCancelarDeletar);

		 btnSalvarAlterar = new JButton("Salvar");
		btnSalvarAlterar.setBounds(109, 379, 89, 23);
		panel.add(btnSalvarAlterar);

		 btnVisita = new JButton("Visita");
		btnVisita.setBounds(10, 379, 89, 23);
		panel.add(btnVisita);
		
		txtObservacao = new JTextField();
		txtObservacao.setEnabled(false);
		txtObservacao.setBounds(10, 11, 314, 20);
		contentPane.add(txtObservacao);
		txtObservacao.setColumns(10);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		limparTxt();

		// quando a captacao for nula será para cadastrar uma captacao quando ela
		// não for quer dizer que será feita uma alteração da captacao que foi
		// passada como parametro para isso temos mudar o texto do
		// btnSalvarAlterar para alterar, e ele vai ter uma função de
		// desbloquear as caixas de texto serão bloqueadas, nem sempre a captacao
		// quer fazer uma alteração as vezes quer só consultar os dados
		if (captacao != null) {

			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setToolTipText("Deletar");
			inserir(captacao);
			txtEnable(false);
		}

		// aqui vou adicionar um observador dos botões para que quando um deles
		// for clicado a ação dele seja enviada para o metodo actionPerformed
		btnCancelarDeletar.addActionListener(this);
		btnSalvarAlterar.addActionListener(this);
		captacaoParaAlterar = captacao;

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
			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setText("Novo");
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
		Captacao captacao = (Captacao) ob;
			txtId.setText(String.valueOf(captacao.getId()));
			txtNome.setText(String.valueOf(captacao.getNome()));
			txtNumTelefone.setText(String.valueOf(captacao.getTelefone()));
			txtDescricao.setText(String.valueOf(captacao.getDescricao()));
			txtValorMed.setText(String.valueOf(captacao.getValorMedio()));
			txtObservacao.setText(String.valueOf(captacao.getDescricao()));
			
			dtCadastro.setDate(captacao.getDataCadastro());
			
			boxInteresse.setSelectedItem(captacao.getInteresse());
			

		
	}

	@Override
	public void salvar() {
			Captacao captacao = new Captacao();
			if (captacaoParaAlterar != null) {
				System.out.println(txtId.getText());
				captacao.setId(Integer.parseInt(txtId.getText()));
			}
			captacao.setNome(txtNome.getText());
			captacao.setInteresse(String.valueOf(boxInteresse.getSelectedItem()));
			captacao.setTelefone(txtNumTelefone.getText());
			captacao.setValorMedio(Float.parseFloat(txtValorMed.getText().replace(",", ".")));
			captacao.setDataCadastro(Date.valueOf(df.format(dtCadastro.getDate())));
			captacao.setObservacao("NÃO AGENDOU VISITA");
			captacao.setDescricao(txtDescricao.getText());

			if (captacaoParaAlterar != null) {
				banco.salvarOuAtualizarObjeto(captacao);
				JOptionPane.showMessageDialog(contentPane,
						"captacao salva com sucesso!");
				dispose();
			} else {
				banco.salvarObjeto(captacao);
				txtId.setText(String.valueOf(captacao.getId()));
				txtObservacao.setText(captacao.getObservacao());
				JOptionPane.showMessageDialog(contentPane, "captacao salva com sucesso!");
			}
			
			
			if (!txtId.getText().equalsIgnoreCase("")) {

			}
			txtEnable(false);
			btnCancelarDeletar.setToolTipText("Novo");

		
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
			boxInteresse.setSelectedIndex(0);
			txtNumTelefone.setText("");
			txtValorMed.setText("0,00");
			dtCadastro.setDate(new java.util.Date());
			txtDescricao.setText("Localiza\u00E7\u00E3o: \r\n\r\nPrefer\u00EAncia:\r\n\r\n");
			txtObservacao.setText("");

		
	}

	@Override
	public void txtEnable(boolean valor) {
			txtNome.setEnabled(valor);
			txtNumTelefone.setEnabled(valor);
//			dtCadastro.setEnabled(valor);
			txtValorMed.setEnabled(valor);
			boxInteresse.setEnabled(valor);
			txtDescricao.setEnabled(valor);
		
	}
}