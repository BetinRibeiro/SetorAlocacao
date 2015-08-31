package Janela.Cadastro;
import java.awt.EventQueue;

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
import javax.swing.UIManager;



public class JFrmCadastroImovel extends JDialog {

	/**
	 * 
	 */
	//ainda não sei exatamente para que ser isso, pesquisei por alto mais não entendi muito
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					JFrmCadastroImovel frame = new JFrmCadastroImovel();
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
	public JFrmCadastroImovel() {
		setTitle("Cadastro de Im\u00F3vel");
		setBounds(100, 100, 770, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);  
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 735, 381);
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
		txtCodImovel.setEnabled(false);
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
		lblNomeDoProprietario.setBounds(90, 100, 123, 14);
		panel.add(lblNomeDoProprietario);
		
		JLabel lblCdigoDoProprietario = new JLabel("C\u00F3digo ");
		lblCdigoDoProprietario.setBounds(10, 100, 68, 14);
		panel.add(lblCdigoDoProprietario);
		
		txtNumeroEscritura = new JTextField();
		txtNumeroEscritura.setEnabled(false);
		txtNumeroEscritura.setColumns(10);
		txtNumeroEscritura.setBounds(10, 70, 130, 20);
		panel.add(txtNumeroEscritura);
		
		JLabel lblNumeroDaEscritura = new JLabel("Numero da Escritura");
		lblNumeroDaEscritura.setBounds(10, 55, 130, 14);
		panel.add(lblNumeroDaEscritura);
		
		txtNomeCartorio = new JTextField();
		txtNomeCartorio.setEnabled(false);
		txtNomeCartorio.setColumns(10);
		txtNomeCartorio.setBounds(150, 71, 222, 20);
		panel.add(txtNomeCartorio);
		
		JLabel lblNomeDoCartorio = new JLabel("Nome do Cartorio");
		lblNomeDoCartorio.setBounds(150, 56, 130, 14);
		panel.add(lblNomeDoCartorio);
		
		txtCidadeCartorio = new JTextField();
		txtCidadeCartorio.setEnabled(false);
		txtCidadeCartorio.setColumns(10);
		txtCidadeCartorio.setBounds(382, 70, 255, 20);
		panel.add(txtCidadeCartorio);
		
		JLabel lblCidadeDoCartorio = new JLabel("Cidade do Cartorio");
		lblCidadeDoCartorio.setBounds(382, 55, 130, 14);
		panel.add(lblCidadeDoCartorio);
		
		JComboBox boxUfCartorio = new JComboBox();
		boxUfCartorio.setBounds(647, 70, 60, 20);
		panel.add(boxUfCartorio);
		boxUfCartorio.setEnabled(false);
		
		JLabel lblUf = new JLabel("UF cartorio");
		lblUf.setBounds(647, 55, 78, 14);
		panel.add(lblUf);
		
		txtLougradouro = new JTextField();
		txtLougradouro.setBounds(10, 161, 392, 20);
		panel.add(txtLougradouro);
		txtLougradouro.setEnabled(false);
		txtLougradouro.setColumns(10);
		
		JLabel lblRua = new JLabel("Lougradrouro e Numero");
		lblRua.setBounds(10, 145, 226, 14);
		panel.add(lblRua);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(10, 205, 210, 20);
		panel.add(txtCidade);
		txtCidade.setEnabled(false);
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
		txtCep.setEnabled(false);
		txtCep.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(412, 160, 225, 20);
		panel.add(txtBairro);
		txtBairro.setEnabled(false);
		txtBairro.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(412, 145, 46, 14);
		panel.add(lblBairro);
		
		JComboBox boxUFEndereco = new JComboBox();
		boxUFEndereco.setEnabled(false);
		boxUFEndereco.setBounds(647, 160, 58, 20);
		panel.add(boxUFEndereco);
		
		JLabel lblUfEndereo = new JLabel("UF Endere\u00E7o");
		lblUfEndereo.setBounds(647, 145, 78, 14);
		panel.add(lblUfEndereo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(411, 114, 89, 20);
		panel.add(btnBuscar);
		
		JLabel lblSuites = new JLabel("Suites");
		lblSuites.setBounds(552, 190, 60, 14);
		panel.add(lblSuites);
		
		JLabel lblGaragens = new JLabel("Garagens");
		lblGaragens.setBounds(482, 190, 60, 14);
		panel.add(lblGaragens);
		
		JLabel lblComodos = new JLabel("C\u00F4modos");
		lblComodos.setBounds(412, 190, 60, 14);
		panel.add(lblComodos);
		
		JComboBox boxComodos = new JComboBox();
		boxComodos.setEnabled(false);
		boxComodos.setBounds(412, 205, 60, 20);
		panel.add(boxComodos);
		
		JComboBox boxGaragens = new JComboBox();
		boxGaragens.setEnabled(false);
		boxGaragens.setBounds(482, 205, 60, 20);
		panel.add(boxGaragens);
		
		JComboBox boxSuites = new JComboBox();
		boxSuites.setEnabled(false);
		boxSuites.setBounds(552, 205, 60, 20);
		panel.add(boxSuites);
		
		JLabel lblBanheiros = new JLabel("Banheiros");
		lblBanheiros.setBounds(622, 190, 60, 14);
		panel.add(lblBanheiros);
		
		JComboBox boxBanheiros = new JComboBox();
		boxBanheiros.setEnabled(false);
		boxBanheiros.setBounds(622, 205, 60, 20);
		panel.add(boxBanheiros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 715, 125);
		panel.add(scrollPane);
		
		JTextArea txtInformacoesComplementares = new JTextArea();
		txtInformacoesComplementares.setText("Tamanho : m\u00B2\r\n\r\n\u00C1rea costruida: m\u00B2\r\n\r\n\r\n\r\n");
		scrollPane.setViewportView(txtInformacoesComplementares);
		
		JLabel lblInformaesComplementares = new JLabel("Informa\u00E7\u00F5es Complementares");
		lblInformaesComplementares.setBounds(10, 230, 173, 14);
		panel.add(lblInformaesComplementares);
		
		JComboBox boxTipo = new JComboBox();
		boxTipo.setEnabled(false);
		boxTipo.setBounds(222, 25, 174, 20);
		panel.add(boxTipo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(222, 10, 60, 14);
		panel.add(lblTipo);
		
		JComboBox boxFinalidade = new JComboBox();
		boxFinalidade.setEnabled(false);
		boxFinalidade.setBounds(406, 25, 198, 20);
		panel.add(boxFinalidade);
		
		JLabel lblFinalizadade = new JLabel("Finalizadade");
		lblFinalizadade.setBounds(406, 10, 106, 14);
		panel.add(lblFinalizadade);
		
		JCheckBox chckbxDisponvel = new JCheckBox("Dispon\u00EDvel");
		chckbxDisponvel.setBounds(610, 24, 97, 23);
		panel.add(chckbxDisponvel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(458, 403, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(656, 403, 89, 23);
		contentPane.add(btnSair);
		
		txtInformacoesAlocacao = new JTextField();
		txtInformacoesAlocacao.setEnabled(false);
		txtInformacoesAlocacao.setColumns(10);
		txtInformacoesAlocacao.setBounds(10, 403, 438, 23);
		contentPane.add(txtInformacoesAlocacao);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(557, 403, 89, 23);
		contentPane.add(btnCancelar);
	}
}
