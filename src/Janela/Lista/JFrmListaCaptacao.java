package Janela.Lista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Bin.Captacao.Captacao;
import Janela.Cadastro.JFrmCaptacao;
import Persistence.Dao;
import TableModel.TMCaptacao;

@SuppressWarnings("serial")
public class JFrmListaCaptacao extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeBusca;
	private JButton btnBuscar;
	private JButton btnSair;
	private JButton btnAlterar;
	private Dao banco = new Dao();
	private TMCaptacao model = new TMCaptacao();
	private int a;
	private JTable tableCaptacao;
	private Captacao Captacao=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmListaCaptacao dialog = new JFrmListaCaptacao("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param escolher 
	 */
	public JFrmListaCaptacao(String escolher) {
		setTitle("Consulta de Classifica\u00E7\u00E3o dos Captacaos da Empresa");
		setType(Type.UTILITY);
		// setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 64, 574, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 574, 300);
		panel.add(scrollPane);

		tableCaptacao = new JTable(model);

		// tabela com colunas fixasv
		tableCaptacao.getTableHeader().setReorderingAllowed(false);
		// tamanho especifico da coluna
//		tableCaptacao.getColumn("nome").setPreferredWidth(350);

		// seleciona apenas uma linha
		tableCaptacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableCaptacao);

		txtNomeBusca = new JTextField();
		txtNomeBusca.setBounds(129, 10, 260, 20);
		contentPane.add(txtNomeBusca);
		txtNomeBusca.setColumns(10);

		JLabel lblNome = new JLabel("Nome Captacao");
		lblNome.setBounds(10, 10, 97, 20);
		contentPane.add(lblNome);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(400, 10, 89, 20);
		contentPane.add(btnBuscar);
		btnBuscar.addActionListener(this);

		btnSair = new JButton("Sair");
		btnSair.setBounds(495, 375, 89, 20);
		contentPane.add(btnSair);
		btnSair.addActionListener(this);

		btnAlterar = new JButton("Detalhe");
		btnAlterar.setBounds(399, 375, 89, 20);
		contentPane.add(btnAlterar);
		btnAlterar.addActionListener(this);
		setResizable(false);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		btnAlterar.setEnabled(false);
		if (escolher.equalsIgnoreCase("Escolher")) {
			btnSair.setText("Escolher");
			btnAlterar.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);
		switch (acao) {
		case "Buscar":
			buscar();
			break;

		case "Sair":
			dispose();
			break;
		case "Detalhe":
			Detalhe();
			break;
		case "Escolher":
			retorno();
			break;

		default:
			break;
		}

	}



	private void retorno() {
		setCaptacao((Captacao) banco.buscarPorId(Captacao.class, (Integer) tableCaptacao.getValueAt(
				tableCaptacao.getSelectedRow(), 0)));
	getCaptacao();
	dispose();
		
	}

	public void setCaptacao(Captacao Captacao) {
		this.Captacao = Captacao;
		
	}
	public Captacao getCaptacao() {
		return Captacao;
		
	}

	private void Detalhe() {
//		try {

			Captacao Captacao = (Captacao) banco.buscarPorId(
					Captacao.class,
					(Integer) tableCaptacao.getValueAt(
							tableCaptacao.getSelectedRow(), 0));
			JFrmCaptacao c = new JFrmCaptacao(Captacao);
			txtNomeBusca.setText("");
			model.removeTudo();
			c.setVisible(true);
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(contentPane,
//					"ERRO ao alterar um Captacao.");
//		}
	}

	private void buscar() {
		try {
			model.removeTudo();
			a = 0;
			List<?> lista = banco.BuscaNome(Captacao.class,
					txtNomeBusca.getText(), "nome");
			for (int i = 0; i < lista.size(); i++) {
				Captacao classif = (Captacao) lista.get(i);
				model.addRow(classif);
				a = 1;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um Captacao.");
		}
		if (a == 0) {
			btnAlterar.setEnabled(false);
		} else {
			btnAlterar.setEnabled(true);
		}
	}
	

}
