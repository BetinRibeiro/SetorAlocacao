package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.Box;
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

import Bin.Endereco;
import Bin.Pessoa.Filiacao;
import Bin.Pessoa.Pessoa;
import Bin.Pessoa.Telefone;
import Persistence.*;

public class JFrmCadastroPessoa extends JDialog implements ActionListener {

	// Painel principal onde tudo é aberto aqui
	private JPanel contentPane;

	// Todas as caixas de texto são declaradas como globais
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtLougradouroNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtFone1;
	private JTextField txtCel;
	private JTextField txtCep;
	private JTextField txtEmail;
	private JTextField txtCargo;
	private JTextField txtNaturalidade;
	private JTextField txtNascionalidade;
	private JTextField txtMae;
	private JTextField txtObservação;
	private JTextField txtPai;

	// box's que carregam valores fixos nada aqui é carregado do banco de dados
	private JComboBox boxSexo;
	private JComboBox boxEscola;
	private JComboBox boxEstadoCivil;
	private JComboBox boxUfEnd;
	private JComboBox boxUfRg;

	// estrutura que carrega DATE
	private JDateChooser dtData;

	// instancia da classe dao que eu chamei de banco
	private Dao banco = new Dao();

	// esta variavel serve para formatar data do modo como colocamos no banco de
	// dados
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private JButton btnSalvarAlterar;
	private JButton btnCancelarDeletar;

	// esta variavel quando não esta nula obotão salvar fica com o nome Alterar
	// e faz uma pesquisa preenchendo os valores dos campos com os de uma pessoa
	// já cadastrada
	private Pessoa pessoaParaAlterar = null;

	// Lista de strings que preenchem os boxs
	String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA",
			"MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO",
			"RR", "RS", "SC", "SE", "SP", "TO" };

	String[] orgao = { "ABNC", "CGPI/DUREX/DPF", "CGPI", "CGPMAF", "CNIG",
			"CNT", "COREN ", "CORECON", "CRA ", "CRAS", "CRB", "CRC ", "CRE ",
			"CREA ", "CRECI", "CREFIT", "CRF ", "CRM", "CRN", "CRO ", "CRP ",
			"CRPRE ", "CRQ ", "CRRC ", "CRMV ", "CSC ", "CTPS ", "DIREX ",
			"DPMAF", "DPT ", "DST ", "FGTS ", "FIPE ", "FLS ", "GOVGO ",
			"I CLA", "IFP ", "IGP ", "IICCECF/RO", "IIMG", "IML", "IPC", "IPF",
			"MAE ", "MEX ", "MMA", "OAB", "OMB ", "PCMG ", "PMMG ",
			"POF ou DPF", "POM", "SDS", "SNJ", "SECC", "SEJUSP", "SES ou EST",
			"SESP", "SJS", "SJTC", "SJTS", "SPTC", "SSP" };
	String[] escolaridade = { "Ensino fundamental incompleto",
			"Ensino fundamental completo", "Ensino médio incompleto",
			"Ensino médio completo", "Ensino superior incompleto",
			"Ensino superior completo", "Pós-graduação", "Mestrado",
			"Doutorado" };
	String[] estadoCivil = { "Solteiro(a)", "Casado(a)", "Divorciado(a)",
			"Viuvo(a)", "Separado(a)" };
	String[] sexo = { "Masculino", "Feminino" };

	private JComboBox boxUFNaturali;

	private JComboBox boxOrgaoExpedidor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
					JFrmCadastroPessoa frame = new JFrmCadastroPessoa(null);
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("betin");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param idFuncionario
	 */
	public JFrmCadastroPessoa(Pessoa pessoa) {
		setTitle("Cadastro de Pessoa");
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 775, 399);
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

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(10, 100, 60, 20);
		panel.add(lblRg);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(380, 55, 60, 20);
		panel.add(lblCpf);

		JLabel lblDataNasc = new JLabel("Data Nasc");
		lblDataNasc.setBounds(10, 150, 75, 20);
		panel.add(lblDataNasc);

		dtData = new JDateChooser(new java.util.Date());
		dtData.setBounds(10, 170, 140, 20);
		panel.add(dtData);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setBounds(380, 150, 83, 20);
		panel.add(lblEstadoCivil);

		JLabel lblEscolaridade = new JLabel("Escolaridade");
		lblEscolaridade.setBounds(380, 100, 83, 20);
		panel.add(lblEscolaridade);

		txtNome = new JTextField();
		txtNome.setBounds(10, 75, 360, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(10, 120, 203, 20);
		panel.add(txtRg);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(380, 75, 203, 20);
		panel.add(txtCpf);

		boxEstadoCivil = new JComboBox(estadoCivil);
		boxEstadoCivil.setBounds(380, 170, 203, 20);
		panel.add(boxEstadoCivil);

		boxEscola = new JComboBox(escolaridade);
		boxEscola.setBounds(380, 120, 203, 20);
		panel.add(boxEscola);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(593, 150, 71, 20);
		panel.add(lblSexo);

		boxSexo = new JComboBox(sexo);
		boxSexo.setBounds(593, 170, 166, 20);
		panel.add(boxSexo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 200, 60, 20);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setText("");
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 220, 248, 20);
		panel.add(txtEmail);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		boxEscola.setSelectedIndex(3);

		JLabel lblCargo = new JLabel("Cargo Profiss\u00E3o");
		lblCargo.setBounds(160, 150, 147, 20);
		panel.add(lblCargo);

		txtCargo = new JTextField();
		txtCargo.setText("");
		txtCargo.setColumns(10);
		txtCargo.setBounds(160, 170, 210, 20);
		panel.add(txtCargo);

		JLabel lblNaturalidade = new JLabel("Natural de:");
		lblNaturalidade.setBounds(268, 200, 222, 20);
		panel.add(lblNaturalidade);

		txtNaturalidade = new JTextField();
		txtNaturalidade.setText("");
		txtNaturalidade.setColumns(10);
		txtNaturalidade.setBounds(268, 220, 245, 20);
		panel.add(txtNaturalidade);

		JLabel lblOrgo = new JLabel("Org\u00E3o exp.");
		lblOrgo.setBounds(224, 100, 83, 14);
		panel.add(lblOrgo);

		boxOrgaoExpedidor = new JComboBox(orgao);
		boxOrgaoExpedidor.setBounds(223, 120, 84, 20);
		panel.add(boxOrgaoExpedidor);

		txtNascionalidade = new JTextField("Brasileiro");
		txtNascionalidade.setColumns(10);
		txtNascionalidade.setBounds(593, 220, 166, 20);
		panel.add(txtNascionalidade);

		JLabel lblNascionalidade = new JLabel("Nascionalidade");
		lblNascionalidade.setBounds(593, 200, 203, 20);
		panel.add(lblNascionalidade);

		JLabel lblRua = new JLabel("Endere\u00E7o");
		lblRua.setBounds(10, 250, 111, 14);
		panel.add(lblRua);

		txtLougradouroNumero = new JTextField();
		txtLougradouroNumero.setBounds(10, 265, 360, 20);
		panel.add(txtLougradouroNumero);
		txtLougradouroNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(380, 295, 82, 14);
		panel.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setBounds(380, 310, 203, 20);
		panel.add(txtBairro);
		txtBairro.setColumns(10);

		txtCep = new JTextField();
		txtCep.setBounds(380, 265, 203, 20);
		panel.add(txtCep);
		txtCep.setText("");
		txtCep.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(380, 245, 82, 14);
		panel.add(lblCep);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 295, 92, 14);
		panel.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 310, 289, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);

		boxUfEnd = new JComboBox(uf);
		boxUfEnd.setBounds(309, 310, 60, 20);
		panel.add(boxUfEnd);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(309, 295, 60, 14);
		panel.add(lblUf);

		JLabel lblTelefone = new JLabel("Telefone ");
		lblTelefone.setBounds(594, 60, 82, 14);
		panel.add(lblTelefone);

		txtFone1 = new JTextField();
		txtFone1.setBounds(593, 75, 166, 20);
		panel.add(txtFone1);
		txtFone1.setColumns(10);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(593, 105, 98, 14);
		panel.add(lblCelular);

		txtCel = new JTextField();
		txtCel.setBounds(593, 120, 166, 20);
		panel.add(txtCel);
		txtCel.setColumns(10);

		JLabel lblNomeDoPai = new JLabel("Nome do Pai");
		lblNomeDoPai.setBounds(10, 341, 165, 20);
		panel.add(lblNomeDoPai);

		txtPai = new JTextField();
		txtPai.setColumns(10);
		txtPai.setBounds(10, 361, 370, 20);
		panel.add(txtPai);

		JLabel lblNomeDaMe = new JLabel("Nome da M\u00E3e");
		lblNomeDaMe.setBounds(390, 341, 120, 20);
		panel.add(lblNomeDaMe);

		txtMae = new JTextField();
		txtMae.setColumns(10);
		txtMae.setBounds(390, 361, 369, 20);
		panel.add(txtMae);

		boxUFNaturali = new JComboBox(uf);
		boxUFNaturali.setBounds(523, 220, 60, 20);
		panel.add(boxUFNaturali);

		JLabel lblUfCidade = new JLabel("UF Cidade");
		lblUfCidade.setBounds(523, 205, 60, 14);
		panel.add(lblUfCidade);

		boxUfRg = new JComboBox(uf);
		boxUfRg.setBounds(310, 120, 60, 20);
		panel.add(boxUfRg);

		JLabel lblUfOrgo = new JLabel("UF Org\u00E3o");
		lblUfOrgo.setBounds(310, 100, 60, 14);
		panel.add(lblUfOrgo);

		btnSalvarAlterar = new JButton("Salvar");
		btnSalvarAlterar.setBounds(597, 422, 89, 23);
		contentPane.add(btnSalvarAlterar);

		btnCancelarDeletar = new JButton("Cancelar");
		btnCancelarDeletar.setBounds(696, 422, 89, 23);
		contentPane.add(btnCancelarDeletar);

		txtObservação = new JTextField();
		txtObservação.setColumns(10);
		txtObservação.setBounds(10, 422, 577, 23);
		contentPane.add(txtObservação);

		limparTxt();

		// quando a pessoa for nula será para cadastrar uma pessoa quando ela
		// não for quer dizer que será feita uma alteração da pessoa que foi
		// passada como parametro para isso temos mudar o texto do
		// btnSalvarAlterar para alterar, e ele vai ter uma função de
		// desbloquear as caixas de texto serão bloqueadas, nem sempre a pessoa
		// quer fazer uma alteração as vezes quer só consultar os dados
		if (pessoa != null) {

			btnSalvarAlterar.setText("Alterar");
			inserirPessoa(pessoa);
			txtEnable(false);
		}

		// aqui vou adicionar um observador dos botões para que quando um deles
		// for clicado a ação dele seja enviada para o metodo actionPerformed
		btnCancelarDeletar.addActionListener(this);
		btnSalvarAlterar.addActionListener(this);

	}

	private void inserirPessoa(Pessoa pessoa) {
		txtNome.setText(pessoa.getNome());
		txtRg.setText(String.valueOf(pessoa.getRg()));
		txtCpf.setText(String.valueOf(pessoa.getCpf()));
		txtLougradouroNumero.setText(pessoa.getEnd().getLougradouro());
		txtBairro.setText(pessoa.getEnd().getBairro());
		txtCidade.setText(pessoa.getEnd().getCidade());
		txtFone1.setText(String.valueOf(pessoa.getTelefone().getFone1()));
		txtCel.setText(String.valueOf(pessoa.getTelefone().getFone2()));
		txtCep.setText(pessoa.getEnd().getCep());
		txtEmail.setText(pessoa.getEmail());
		txtCargo.setText(pessoa.getCargo());
		txtNaturalidade.setText(pessoa.getNaturalidade());
		txtNascionalidade.setText(pessoa.getNascionalidade());
		txtMae.setText(pessoa.getFiliacao().getNomeMae());
		txtObservação.setText(pessoa.getObservacao());
		txtPai.setText(pessoa.getFiliacao().getNomePai());
		boxEscola.setSelectedItem(pessoa.getEscolaridade());
		boxEstadoCivil.setSelectedItem(pessoa.getEstadoCivil());
		boxSexo.setSelectedItem(pessoa.getSexo());
		boxUfEnd.setSelectedItem(pessoa.getEnd().getUf());
		boxUfRg.setSelectedItem(pessoa.getUfrg());
		boxUFNaturali.setSelectedItem(pessoa.getUfNaturalidade());
		boxOrgaoExpedidor.setSelectedItem(pessoa.getOrgaoEspedidor());

	}

	private void txtEnable(boolean valor) {
		txtNome.setEnabled(valor);
		txtRg.setEnabled(valor);
		txtCpf.setEnabled(valor);
		txtLougradouroNumero.setEnabled(valor);
		txtBairro.setEnabled(valor);
		txtCidade.setEnabled(valor);
		txtFone1.setEnabled(valor);
		txtCel.setEnabled(valor);
		txtCep.setEnabled(valor);
		txtEmail.setEnabled(valor);
		txtCargo.setEnabled(valor);
		txtNaturalidade.setEnabled(valor);
		txtNascionalidade.setEnabled(valor);
		txtMae.setEnabled(valor);
		txtObservação.setEnabled(valor);
		txtPai.setEnabled(valor);
		boxEscola.setEnabled(valor);
		boxEstadoCivil.setEnabled(valor);
		boxSexo.setEnabled(valor);
		boxUfEnd.setEnabled(valor);
		boxUfRg.setEnabled(valor);
		boxUFNaturali.setEnabled(valor);
		boxOrgaoExpedidor.setEditable(valor);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Alterar":
			liberarAlteracao();
			break;
		case "Salvar":
			salvar();
			break;
		case "Cancelar":
			limparTxt();
			break;
		case "Deletar":
			int op = JOptionPane.showConfirmDialog(contentPane,
					"Deseja realmente deletar?");
			System.out.println(op);
			if (op == 0) {
				// TODO agora podemos deletar ainda não esta implementada
			}
			break;

		default:
			break;
		}

	}

	private void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(txtNome.getText());
		pessoa.setRg(Long.valueOf(txtRg.getText()));
		pessoa.setCpf(Long.valueOf(txtCpf.getText()));
		pessoa.setEmail(txtEmail.getText());
		pessoa.setCargo(txtCargo.getText());
		pessoa.setNaturalidade(txtNaturalidade.getText());
		pessoa.setNascionalidade(txtNascionalidade.getText());
		pessoa.setObservacao(txtObservação.getText());
		
		Endereco endereco = new Endereco();
		endereco.setBairro(txtBairro.getText());
		endereco.setCep(txtCep.getText());
		endereco.setCidade(txtCidade.getText());
		endereco.setLougradouro(txtLougradouroNumero.getText());
		endereco.setUf(String.valueOf(boxUfEnd.getSelectedItem()));
		
		pessoa.setEnd(endereco);
		
		Telefone telefone = new Telefone();
		telefone.setFone1(Long.parseLong(txtFone1.getText()));
		telefone.setFone2(Long.parseLong(txtCel.getText()));
		
		pessoa.setTelefone(telefone);
		
		Filiacao filiacao = new Filiacao();
		filiacao.setNomeMae(txtMae.getText());
		filiacao.setNomePai(txtPai.getText());
		
		pessoa.setFiliacao(filiacao);
		pessoa.setEscolaridade(String.valueOf(boxEscola.getSelectedItem()));
		pessoa.setEstadoCivil(String.valueOf(boxEstadoCivil.getSelectedItem()));
		pessoa.setSexo(String.valueOf(boxSexo.getSelectedItem()));
		pessoa.setUfrg(String.valueOf(boxUfRg.getSelectedItem()));
		pessoa.setUfNaturalidade(String.valueOf(boxUFNaturali.getSelectedItem()));
		pessoa.setOrgaoEspedidor(String.valueOf(boxOrgaoExpedidor.getSelectedItem()));
		
		
		banco.salvarObjeto(pessoa);
		JOptionPane.showMessageDialog(contentPane, "Pessoa salva com sucesso!");
		
		
		
	}

	private void liberarAlteracao() {
		btnSalvarAlterar.setToolTipText("Salvar");
		txtEnable(true);

	}

	private void limparTxt() {
		txtNome.setText("");
		txtRg.setText("");
		txtCpf.setText("");
		txtLougradouroNumero.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtFone1.setText("");
		txtCel.setText("");
		txtCep.setText("");
		txtEmail.setText("");
		txtCargo.setText("");
		txtNaturalidade.setText("");
		txtNascionalidade.setText("Brasileiro(a)");
		txtMae.setText("");
		txtObservação.setText("");
		txtPai.setText("");
		boxEscola.setSelectedIndex(4);
		boxEstadoCivil.setSelectedIndex(0);
		boxSexo.setSelectedIndex(0);
		boxUfEnd.setSelectedIndex(5);
		boxUfRg.setSelectedIndex(5);
		boxUFNaturali.setSelectedIndex(5);
		boxOrgaoExpedidor.setSelectedIndex(62);

	}
}
