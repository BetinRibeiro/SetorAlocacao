package Janela.Lista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Uma <code>JFrmLista</code> é uma classe pai que contem as caracteristicas de
 * tamanho e botões que uma tela de listagem possui, os metodos que tem que ser
 * implementao pelas classes filhas são abstract void retorno();
 * 
 * public abstract void setObj(Object obj);
 * 
 * public abstract Object getObj();
 * 
 * abstract void Detalhe();
 * 
 * abstract void buscar();
 * 
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 */

abstract class JFrmLista extends JDialog implements ActionListener {

	protected JPanel contentPane;
	protected JTextField txtNomeBusca;
	protected JButton btnBuscar;
	protected JButton btnSair;
	protected JButton btnAlterar;
	protected AbstractTableModel model;
	protected JTable tableObjeto;
	protected Object objRetorno = null;
	protected JScrollPane scrollPane;
	protected JLabel lblNomeBusca;

	public JFrmLista(String escolher) {
		// titulo que tem que ser alterado
		setTitle("Titulo");
		// tipo utilitario
		setType(Type.UTILITY);
		// tamanho da janela
		setBounds(100, 100, 600, 454);
		// container principal no qual será mentido os componentes da janela
		contentPane = new JPanel();
		// tamanho da borda do conteirner principal
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// adicionando na janela o conteirner pricipal
		setContentPane(contentPane);
		// tipo de leyout que será utilizaddo neste conteiner principal
		contentPane.setLayout(null);

		// painel que ira conter o scroll e a tabela
		JPanel panelTable = new JPanel();
		// tamanho e localização do painel da tabela
		panelTable.setBounds(10, 64, 574, 300);
		// adicionando o painel no conteiner principal
		contentPane.add(panelTable);
		// tipo de leyout utilizado por o painel table
		panelTable.setLayout(null);

		// esse componente 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 574, 300);
		panelTable.add(scrollPane);

		txtNomeBusca = new JTextField();
		txtNomeBusca.setBounds(129, 10, 260, 20);
		contentPane.add(txtNomeBusca);
		txtNomeBusca.setColumns(10);

		lblNomeBusca = new JLabel("Nome Objeto");
		lblNomeBusca.setBounds(10, 10, 97, 20);
		contentPane.add(lblNomeBusca);

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

	/**
	 * Metodo que recebe as ações dos botões 
	 */
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
	
	protected abstract void renomeando(String titulo, String nomeBusca);

	abstract void retorno();

	public abstract void setObj(Object obj);

	public abstract Object getObj();

	abstract void Detalhe();

	abstract void buscar();
}
