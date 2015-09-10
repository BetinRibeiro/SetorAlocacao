package Janela.Cadastro;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import Bin.Endereco;
import Bin.Imovel.Caracteristica;
import Bin.Imovel.Escritura;
import Bin.Imovel.Imovel;
import Bin.Pessoa.Pessoa;
import Janela.Lista.JFrmListaPessoa;
import Persistence.Dao;

public class JFrmCadastroImovel extends JDialog implements ActionListener
		 {

	/**
	 * 
	 */
	// ainda não sei exatamente para que ser isso, pesquisei por alto mais não
	// entendi muito
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// caixas de texto declaradas de globalmente
	private JTextField txtLougradouro;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtId;
	private JTextField txtCodImovel;
	private JTextField txtIdProprietario;
	private JTextField txtNomeProprietario;
	private JTextField txtNumeroEscritura;
	private JTextField txtNomeCartorio;
	private JTextField txtCidadeCartorio;
	private JTextField txtInformacoesAlocacao;
	private JTextArea txtInformacoesCaracteristica;

	private JComboBox boxFinalidade;
	private JComboBox boxTipo;
	private JComboBox boxSuites;
	private JComboBox boxGaragens;
	private JComboBox boxBanheiros;
	private JComboBox boxComodos;

	private JComboBox boxUFEndereco;
	private JComboBox boxUfCartorio;

	private JCheckBox chckbxDisponvel;
	private JButton btnCancelarDeletar;
	private JButton btnSalvarAlterar;
	private JButton btnBuscar;

	private Imovel imovelParaAlterar = null;

	private Dao banco = new Dao();

	String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA",
			"MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO",
			"RR", "RS", "SC", "SE", "SP", "TO" };
	String[] tipo = { "Apartamento", "Casa", "Comercial", "Sala Comercial",
			"Terreno", "Cadas em Condominio", "Ponto Comercial", "Duplex",
			"Loteamento", "Repasse", "Lote em Condominio" };

	String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	String[] finalidade = { "Locação", "Venda" };
	private JTextField txtValor;
	private JTextField txtValorAluguel;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					JFrmCadastroImovel frame = new JFrmCadastroImovel(null);
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
	 */
	public JFrmCadastroImovel(Imovel imovel) {
		setTitle("Cadastro de Im\u00F3vel");
		setBounds(100, 100, 775, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 735, 406);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCdigoDoImovel = new JLabel("C\u00F3digo Imovel");
		lblCdigoDoImovel.setBounds(10, 10, 130, 14);
		panel.add(lblCdigoDoImovel);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(10, 25, 93, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblCdigoIdentificadorImovel = new JLabel("Identificador ");
		lblCdigoIdentificadorImovel.setBounds(113, 10, 123, 14);
		panel.add(lblCdigoIdentificadorImovel);

		txtCodImovel = new JTextField();
		txtCodImovel.setColumns(10);
		txtCodImovel.setBounds(113, 25, 99, 20);
		panel.add(txtCodImovel);

		txtIdProprietario = new JTextField();
		txtIdProprietario.setEnabled(false);
		txtIdProprietario.setColumns(10);
		txtIdProprietario.setBounds(10, 115, 70, 20);
		panel.add(txtIdProprietario);

		txtNomeProprietario = new JTextField();
		txtNomeProprietario.setEnabled(false);
		txtNomeProprietario.setColumns(10);
		txtNomeProprietario.setBounds(90, 115, 312, 20);
		panel.add(txtNomeProprietario);

		JLabel lblNomeDoProprietario = new JLabel("Nome do Proprietario");
		lblNomeDoProprietario.setBounds(90, 100, 146, 14);
		panel.add(lblNomeDoProprietario);

		JLabel lblCdigoDoProprietario = new JLabel("C\u00F3digo ");
		lblCdigoDoProprietario.setBounds(10, 100, 68, 14);
		panel.add(lblCdigoDoProprietario);

		txtNumeroEscritura = new JTextField();
		txtNumeroEscritura.setColumns(10);
		txtNumeroEscritura.setBounds(10, 70, 130, 20);
		panel.add(txtNumeroEscritura);

		JLabel lblNumeroDaEscritura = new JLabel("Numero da Escritura");
		lblNumeroDaEscritura.setBounds(10, 55, 130, 14);
		panel.add(lblNumeroDaEscritura);

		txtNomeCartorio = new JTextField();
		txtNomeCartorio.setColumns(10);
		txtNomeCartorio.setBounds(150, 71, 222, 20);
		panel.add(txtNomeCartorio);

		JLabel lblNomeDoCartorio = new JLabel("Nome do Cartorio");
		lblNomeDoCartorio.setBounds(150, 56, 130, 14);
		panel.add(lblNomeDoCartorio);

		txtCidadeCartorio = new JTextField();
		txtCidadeCartorio.setColumns(10);
		txtCidadeCartorio.setBounds(382, 70, 260, 20);
		panel.add(txtCidadeCartorio);

		JLabel lblCidadeDoCartorio = new JLabel("Cidade do Cartorio");
		lblCidadeDoCartorio.setBounds(382, 55, 130, 14);
		panel.add(lblCidadeDoCartorio);

		boxUfCartorio = new JComboBox(uf);
		boxUfCartorio.setBounds(665, 70, 60, 20);
		panel.add(boxUfCartorio);

		JLabel lblUf = new JLabel("UF cartorio");
		lblUf.setBounds(655, 55, 70, 14);
		panel.add(lblUf);

		txtLougradouro = new JTextField();
		txtLougradouro.setBounds(10, 161, 392, 20);
		panel.add(txtLougradouro);
		txtLougradouro.setColumns(10);

		JLabel lblRua = new JLabel("Lougradrouro e Numero");
		lblRua.setBounds(10, 145, 226, 14);
		panel.add(lblRua);

		txtCidade = new JTextField();
		txtCidade.setBounds(10, 205, 210, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 190, 46, 14);
		panel.add(lblCidade);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(242, 190, 46, 14);
		panel.add(lblCep);

		txtCep = new JTextField();
		txtCep.setBounds(241, 205, 161, 20);
		panel.add(txtCep);
		txtCep.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(412, 160, 245, 20);
		panel.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(412, 145, 70, 14);
		panel.add(lblBairro);

		boxUFEndereco = new JComboBox(uf);
		boxUFEndereco.setBounds(667, 160, 58, 20);
		panel.add(boxUFEndereco);

		JLabel lblUfEndereo = new JLabel("UF Endere\u00E7o");
		lblUfEndereo.setBounds(655, 145, 70, 14);
		panel.add(lblUfEndereo);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(411, 115, 89, 20);
		panel.add(btnBuscar);

		JLabel lblSuites = new JLabel("Banheiros");
		lblSuites.setBounds(385, 232, 60, 14);
		panel.add(lblSuites);

		JLabel lblGaragens = new JLabel("Quartos");
		lblGaragens.setBounds(315, 232, 60, 14);
		panel.add(lblGaragens);

		JLabel lblComodos = new JLabel("Garagem");
		lblComodos.setBounds(245, 232, 60, 14);
		panel.add(lblComodos);

		boxComodos = new JComboBox(numeros);
		boxComodos.setBounds(245, 247, 60, 20);
		panel.add(boxComodos);

		boxGaragens = new JComboBox(numeros);
		boxGaragens.setBounds(315, 247, 60, 20);
		panel.add(boxGaragens);

		boxSuites = new JComboBox(numeros);
		boxSuites.setBounds(385, 247, 60, 20);
		panel.add(boxSuites);

		JLabel lblBanheiros = new JLabel("Sala");
		lblBanheiros.setBounds(455, 232, 60, 14);
		panel.add(lblBanheiros);

		boxBanheiros = new JComboBox(numeros);
		boxBanheiros.setBounds(455, 247, 60, 20);
		panel.add(boxBanheiros);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 278, 715, 117);
		panel.add(scrollPane);

		txtInformacoesCaracteristica = new JTextArea();
		txtInformacoesCaracteristica
				.setText("Tamanho : m\u00B2\r\n\r\n\u00C1rea costruida: m\u00B2\r\n\r\n\r\n\r\n");
		scrollPane.setViewportView(txtInformacoesCaracteristica);

		JLabel lblInformaesComplementares = new JLabel(
				"Informa\u00E7\u00F5es Complementares");
		lblInformaesComplementares.setBounds(10, 250, 173, 14);
		panel.add(lblInformaesComplementares);

		boxTipo = new JComboBox(tipo);
		boxTipo.setBounds(222, 25, 174, 20);
		panel.add(boxTipo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(222, 10, 60, 14);
		panel.add(lblTipo);

		boxFinalidade = new JComboBox(finalidade);
		boxFinalidade.setBounds(406, 25, 198, 20);
		panel.add(boxFinalidade);

		JLabel lblFinalizadade = new JLabel("Finalizadade");
		lblFinalizadade.setBounds(406, 10, 106, 14);
		panel.add(lblFinalizadade);

		chckbxDisponvel = new JCheckBox("Dispon\u00EDvel");
		chckbxDisponvel.setBounds(610, 24, 97, 23);
		panel.add(chckbxDisponvel);

		txtValor = new JTextField();
		txtValor.setText("");
		txtValor.setColumns(10);
		txtValor.setBounds(510, 115, 90, 20);
		panel.add(txtValor);

		JLabel lblValorImovel = new JLabel("Valor Imovel");
		lblValorImovel.setBounds(510, 100, 93, 14);
		panel.add(lblValorImovel);

		txtValorAluguel = new JTextField();
		txtValorAluguel.setText("");
		txtValorAluguel.setColumns(10);
		txtValorAluguel.setBounds(612, 115, 90, 20);
		panel.add(txtValorAluguel);

		JLabel lblValorAluguel = new JLabel("Valor Aluguel");
		lblValorAluguel.setBounds(612, 100, 93, 14);
		panel.add(lblValorAluguel);
		
		JComboBox comboBox = new JComboBox(numeros);
//		comboBox.setSelectedIndex(0);
		comboBox.setBounds(525, 247, 60, 20);
		panel.add(comboBox);
		
		JLabel lblQuintal = new JLabel("Quintal");
		lblQuintal.setBounds(525, 232, 60, 14);
		panel.add(lblQuintal);
		
		JComboBox comboBox_1 = new JComboBox(numeros);
//		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(595, 247, 60, 20);
		panel.add(comboBox_1);
		
		JLabel lblCozinha = new JLabel("Cozinha");
		lblCozinha.setBounds(595, 232, 60, 14);
		panel.add(lblCozinha);
		
		JComboBox comboBox_2 = new JComboBox(numeros);
//		comboBox_2.setSelectedIndex(0);
		comboBox_2.setBounds(665, 247, 60, 20);
		panel.add(comboBox_2);
		
		JLabel lblSuits = new JLabel("Suits");
		lblSuits.setBounds(665, 232, 60, 14);
		panel.add(lblSuits);

		btnCancelarDeletar = new JButton("Cancelar");
		btnCancelarDeletar.setBounds(656, 428, 89, 23);
		contentPane.add(btnCancelarDeletar);

		txtInformacoesAlocacao = new JTextField();
		txtInformacoesAlocacao.setEnabled(false);
		txtInformacoesAlocacao.setColumns(10);
		txtInformacoesAlocacao.setBounds(10, 428, 537, 23);
		contentPane.add(txtInformacoesAlocacao);

		btnSalvarAlterar = new JButton("Salvar");
		btnSalvarAlterar.setBounds(557, 428, 89, 23);
		contentPane.add(btnSalvarAlterar);
		limparTxt();

		// quando a Imovel for nula será para cadastrar uma Imovel quando ela
		// não for quer dizer que será feita uma alteração da Imovel que foi
		// passada como parametro para isso temos mudar o texto do
		// btnSalvarAlterar para alterar, e ele vai ter uma função de
		// desbloquear as caixas de texto serão bloqueadas, nem sempre a Imovel
		// quer fazer uma alteração as vezes quer só consultar os dados
		if (imovel != null) {

			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setToolTipText("Deletar");
			inserir(imovel);
			txtEnable(false);
		}

		// aqui vou adicionar um observador dos botões para que quando um deles
		// for clicado a ação dele seja enviada para o metodo actionPerformed
		btnCancelarDeletar.addActionListener(this);
		btnSalvarAlterar.addActionListener(this);
		btnBuscar.addActionListener(this);
		imovelParaAlterar = imovel;
	}

	public void inserir(Object ob) {
		Imovel imovel = (Imovel) ob;
		txtValor.setText(String.valueOf(imovel.getValor()).replace(",", "."));
		txtValorAluguel.setText(String.valueOf(imovel.getValorAluguel())
				.replace(",", "."));
		txtLougradouro.setText(imovel.getEnd().getLougradouro());
		txtBairro.setText(imovel.getEnd().getBairro());
		txtCidade.setText(imovel.getEnd().getCidade());
		txtCep.setText(imovel.getEnd().getCep());
		txtId.setText(String.valueOf(imovel.getId()));
		txtCodImovel.setText(imovel.getCodImovel());
		txtIdProprietario.setText(String.valueOf(imovel.getProprietario()
				.getId()));
		txtNomeProprietario.setText(imovel.getProprietario().getNome());
		txtNumeroEscritura.setText(String.valueOf(imovel.getEscritura()
				.getNumeroEscritura()));
		txtNomeCartorio.setText(imovel.getEscritura().getNomeCartorio());
		txtCidadeCartorio.setText(imovel.getEscritura().getCidadeCartorio());
		txtInformacoesAlocacao.setText(imovel.getInformacoesComplementares());
		txtInformacoesCaracteristica.setText(imovel.getCaracteristicas()
				.getInformacaoes());

		boxFinalidade.setSelectedItem(imovel.getFinalidade());
		boxTipo.setSelectedItem(imovel.getTipo());
		boxSuites.setSelectedItem(imovel.getTipo());
		boxGaragens.setSelectedItem(imovel.getCaracteristicas()
				.getNumeroGaragens());
		boxBanheiros.setSelectedItem(imovel.getCaracteristicas()
				.getNumeroBanheiros());
		boxComodos.setSelectedItem(imovel.getCaracteristicas()
				.getNumeroComodos());
		boxUFEndereco.setSelectedItem(imovel.getEnd().getUf());
		boxUfCartorio.setSelectedItem(imovel.getEscritura().getUf());

	}

	public void txtEnable(boolean valor) {
		txtLougradouro.setEnabled(valor);
		txtBairro.setEnabled(valor);
		txtCidade.setEnabled(valor);
		txtCep.setEnabled(valor);
		txtCodImovel.setEnabled(valor);
		txtNumeroEscritura.setEnabled(valor);
		txtNomeCartorio.setEnabled(valor);
		txtCidadeCartorio.setEnabled(valor);
		txtInformacoesAlocacao.setEnabled(valor);
		txtInformacoesCaracteristica.setEnabled(valor);
		txtValor.setEnabled(valor);
		txtValorAluguel.setEnabled(valor);

		boxFinalidade.setEnabled(valor);
		boxTipo.setEnabled(valor);
		boxSuites.setEnabled(valor);
		boxGaragens.setEnabled(valor);
		boxBanheiros.setEnabled(valor);
		boxComodos.setEnabled(valor);
		boxUFEndereco.setEnabled(valor);
		boxUfCartorio.setEnabled(valor);

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
		case "Buscar":
			buscar();
			break;

		default:
			break;
		}

	}

	public void buscar() {
		JFrmListaPessoa prod = new JFrmListaPessoa("Escolher");
		prod.setModal(true);
		prod.setVisible(true);

		Pessoa p = (Pessoa) prod.getObj();
		txtIdProprietario.setText(String.valueOf(p.getId()));
		txtNomeProprietario.setText(String.valueOf(p.getNome()));
		prod.dispose();

	}

	public void salvar() {
		Imovel imovel = new Imovel();
		if (imovelParaAlterar != null) {
			System.out.println(txtId.getText());
			imovel.setId(Integer.parseInt(txtId.getText()));
		}

		imovel.setValor(Float.parseFloat(txtValor.getText().replace(",", ".")));
		imovel.setValor(Float.parseFloat(txtValorAluguel.getText().replace(",",
				".")));

		imovel.setCodImovel(txtCodImovel.getText());
		imovel.setTipo(String.valueOf(boxTipo.getSelectedItem()));
		imovel.setFinalidade(String.valueOf(boxFinalidade.getSelectedItem()));

		Escritura escritura = new Escritura();
		escritura.setCidadeCartorio(txtCidade.getText());
		escritura.setNomeCartorio(txtNomeCartorio.getText());
		escritura.setNumeroEscritura(String.valueOf(txtNumeroEscritura
				.getText()));
		escritura.setUf(String.valueOf(boxUfCartorio.getSelectedItem()));

		imovel.setEscritura(escritura);

		Pessoa proprietario = (Pessoa) banco.buscarPorId(Pessoa.class,
				Integer.parseInt(txtIdProprietario.getText()));
		imovel.setProprietario(proprietario);

		Endereco endereco = new Endereco();
		endereco.setLougradouro(txtLougradouro.getText());
		endereco.setBairro(txtBairro.getText());
		endereco.setUf(String.valueOf(boxUFEndereco.getSelectedItem()));
		endereco.setCidade(txtCidade.getText());
		endereco.setCep(txtCep.getText());

		imovel.setEnd(endereco);

		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setInformacaoes(txtInformacoesCaracteristica.getText());
		caracteristica.setNumeroBanheiros(boxBanheiros.getSelectedIndex());
		caracteristica.setNumeroComodos(boxComodos.getSelectedIndex());
		caracteristica.setNumeroGaragens(boxGaragens.getSelectedIndex());
		caracteristica.setNumeroSuits(boxSuites.getSelectedIndex());

		imovel.setCaracteristicas(caracteristica);
		imovel.setValor(Float.parseFloat(txtValor.getText().replace(",", ".")));
		imovel.setValorAluguel(Float.parseFloat(txtValorAluguel.getText()
				.replace(",", ".")));
		imovel.setInformacoesComplementares(txtInformacoesAlocacao.getText());

		if (imovel.getEnd().getCep() == null) {
			JOptionPane.showMessageDialog(contentPane,
					"O CEP é invalido, favor verificar novamente!",
					"ERRO DE CEP", JOptionPane.INFORMATION_MESSAGE);

		} else {

			if (imovelParaAlterar != null) {
				banco.salvarOuAtualizarObjeto(imovel);
				JOptionPane.showMessageDialog(contentPane,
						"Pessoa salva com sucesso!");
				dispose();
			} else {
				banco.salvarObjeto(imovel);
				txtId.setText(String.valueOf(imovel.getId()));
			}

			JOptionPane.showMessageDialog(contentPane,
					"Pessoa salva com sucesso!");
			if (!txtId.getText().equalsIgnoreCase("")) {

				txtEnable(false);
				btnCancelarDeletar.setToolTipText("Novo");
			}
		}
	}

	public void liberarAlteracao() {
		btnSalvarAlterar.setToolTipText("Salvar");
		txtEnable(true);

	}

	public void limparTxt() {
		txtId.setText("");
		txtValor.setText("");
		txtValorAluguel.setText("");
		txtLougradouro.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		txtCep.setText("");
		txtCodImovel.setText("");
		txtNumeroEscritura.setText("");
		txtNomeCartorio.setText("");
		txtCidadeCartorio.setText("");
		txtInformacoesAlocacao.setText("");
		txtInformacoesCaracteristica
				.setText("Tamanho : m²\n\nÁrea costruida: m²");
		txtIdProprietario.setText("");
		txtNomeProprietario.setText("");

		boxFinalidade.setSelectedItem(0);
		;
		boxTipo.setSelectedIndex(1);
		boxSuites.setSelectedIndex(0);
		boxGaragens.setSelectedIndex(0);
		boxBanheiros.setSelectedIndex(0);
		boxComodos.setSelectedIndex(0);
		boxUFEndereco.setSelectedIndex(5);
		boxUfCartorio.setSelectedIndex(5);

	}
}
