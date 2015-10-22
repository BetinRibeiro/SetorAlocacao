package Janela.Cadastro;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.toedter.calendar.JDateChooser;

import Bin.Interessado.Interessado;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.sql.Date;

/**
 * Uma <code>JFrmCadastraCaptacao</code> cadastro da captação view que cadastra
 * ou altera uma captação
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 */

// não esta serializado- serialização é para resgatar dados dessa classe em
// qualquer outra classe
@SuppressWarnings("serial")
public class JFrmInteressado extends JFrmCadastro {

	// txtfild
	private JTextField txtId;
	private JTextField txtNumTelefone;
	private JTextField txtNome;
	private JTextArea txtDescricao;

	// data de cadastro
	private JDateChooser dtCadastro;

	/**
	 * captacaoParaAlterar essa é uma variavel de apoi para poder navegar entre
	 * as classes o parametro passado pelo construtor
	 */
	private Interessado captacaoParaAlterar = null;

	/**
	 * esse box carrega dois valores predefinidos que são
	 * "Contrato de Administração", "Contrado de Locação" são os unicos
	 * interesses que a empresa pode prestar serviços
	 */
	private JComboBox<String> boxInteresse;

	/**
	 * variavel que preenche o box de interesse que são especificos pela empresa
	 */
	String[] interesse = { "Contrato de Administração", "Contrado de Locação" };

	/**
	 * metodo estatico para teste.
	 */
	public static void main(String[] args) {
		try {
			JFrmInteressado dialog = new JFrmInteressado(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Contrutor do dialog.
	 */
	public JFrmInteressado(Interessado captacao) {
		super(captacao);
		setTitle("Capta\u00E7\u00E3o de Clientes");
		// setBounds(100, 100, 671, 485);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 770, 386);
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
		txtNumTelefone.setBounds(338, 70, 135, 20);
		panel.add(txtNumTelefone);

		boxInteresse = new JComboBox<String>(interesse);
		boxInteresse.setBounds(338, 30, 287, 20);
		panel.add(boxInteresse);

		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 50, 147, 20);
		panel.add(lblNomeCompleto);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 70, 287, 20);
		panel.add(txtNome);

		JLabel lblValorMaximo = new JLabel("Numero Telefone");
		lblValorMaximo.setBounds(338, 50, 108, 20);
		panel.add(lblValorMaximo);

		JLabel lblTipo = new JLabel("Interesse");
		lblTipo.setBounds(338, 10, 84, 20);
		panel.add(lblTipo);

		dtCadastro = new JDateChooser(new java.util.Date());
		dtCadastro.setEnabled(false);
		dtCadastro.setBounds(191, 30, 106, 20);
		panel.add(dtCadastro);

		JLabel lblDataCadastro = new JLabel("Data Cadastro");
		lblDataCadastro.setBounds(191, 10, 106, 20);
		panel.add(lblDataCadastro);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 121, 750, 247);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 750, 247);
		panel_1.add(scrollPane);

		txtDescricao = new JTextArea();
		txtDescricao
				.setText("Localiza\u00E7\u00E3o: \r\n\r\nPrefer\u00EAncia:\r\n\r\n");
		scrollPane.setViewportView(txtDescricao);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 90, 250, 20);
		panel.add(lblDescrio);

		// para criar mesmo no centro
		setLocationRelativeTo(null);
		// deixar no topo de todos os outros
		setAlwaysOnTop(true);
		// limpar todos os componentes para inserirmos dados
		limparTxt();

		/**
		 * Quando for passado alguma captação como parametro iremos inserir os
		 * dados nas caixas de txt e mudaremos os botões de salvar para alterar
		 * e cancelar por deletar
		 */

		// quando a captacao for nula será para cadastrar uma captacao quando
		// ela
		// não for quer dizer que será feita uma alteração da captacao que foi
		// passada como parametro para isso temos mudar o texto do
		// btnSalvarAlterar para alterar, e ele vai ter uma função de
		// desbloquear as caixas de texto serão bloqueadas, nem sempre a
		// captacao
		// quer fazer uma alteração as vezes quer só consultar os dados
		if (captacao != null) {

			btnSalvarAlterar.setText("Alterar");
			btnCancelarDeletar.setToolTipText("Deletar");
			inserir(captacao);
			txtEnable(false);
		}

		/**
		 * aqui vou adicionar um observador dos botões para que quando um deles
		 * for clicado a ação dele seja enviada para o metodo actionPerformed
		 */
		btnCancelarDeletar.addActionListener(this);
		btnSalvarAlterar.addActionListener(this);
		/**
		 * seta a captação como variavel global para que possa ser visualizada
		 * pelos outros metodos
		 */
		captacaoParaAlterar = captacao;

	}

	@Override
	public void inserir(Object ob) {
		try {

			Interessado captacao = (Interessado) ob;
			
			
			txtId.setText(String.valueOf(captacao.getId()));
			txtNome.setText(String.valueOf(captacao.getNome()));
			txtNumTelefone.setText(String.valueOf(captacao.getTelefone()));
			txtDescricao.setText(String.valueOf(captacao.getDescricao()));
			txtObservacao.setText(String.valueOf(captacao.getDescricao()));

			dtCadastro.setDate(captacao.getDataCadastro());

			boxInteresse.setSelectedItem(captacao.getInteresse());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	
	@Override
	public void salvar() {
		try {

			Interessado captacao = new Interessado();
			
			captacao.setNome(txtNome.getText());
			captacao.setInteresse(String.valueOf(boxInteresse.getSelectedItem()));
			captacao.setTelefone(txtNumTelefone.getText());
			captacao.setDataCadastro(Date.valueOf(df.format(dtCadastro
					.getDate())));
			captacao.setObservacao("NÃO AGENDOU VISITA");
			captacao.setDescricao(txtDescricao.getText());

			if (captacaoParaAlterar != null) {
				banco.salvarOuAtualizarObjeto(captacao);
				JOptionPane.showMessageDialog(contentPane,
						"Salva Alteração com sucesso!");
				System.out.println(txtId.getText());
				captacao.setId(Integer.parseInt(txtId.getText()));
				dispose();
			} else {
				
				banco.salvarObjeto(captacao);
				txtId.setText(String.valueOf(captacao.getId()));
				txtObservacao.setText(captacao.getObservacao());
				JOptionPane.showMessageDialog(contentPane,
						"captacao salva com sucesso!");
			}

			txtEnable(false);
			btnCancelarDeletar.setToolTipText("Novo");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void liberarAlteracao() {
		try {

			btnSalvarAlterar.setText("Salvar");
			txtEnable(true);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void limparTxt() {
		try {

			txtId.setText("");
			txtNome.setText("");
			boxInteresse.setSelectedIndex(0);
			txtNumTelefone.setText("");
			dtCadastro.setDate(new java.util.Date());
			txtDescricao
					.setText("Localiza\u00E7\u00E3o: \r\n\r\nPrefer\u00EAncia:\r\n\r\n");
			txtObservacao.setText("");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void txtEnable(boolean valor) {
		try {

			txtNome.setEnabled(valor);
			txtNumTelefone.setEnabled(valor);
			boxInteresse.setEnabled(valor);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}