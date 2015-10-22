package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import Bin.Contrato.Clausula;
import Bin.Contrato.Contrato;
import Persistence.Dao;
import TableModel.TMClausula;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class JFrmCadastroContrato extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNomeContrato;
	private JTable table;
	private JTextArea txtrClausula;
	private JButton btnAlterar;
	private JButton btnInserir;
	private JButton btnCancelar;
	private JButton btnDeletar;
	private JButton btnSalvar;
	private JTextField txtTituloClasula;
	private JLabel lblTituloClausula;
	private TMClausula model = new TMClausula();
	private Dao banco = new Dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrmCadastroContrato frame = new JFrmCadastroContrato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrmCadastroContrato() {
		setTitle("Cadastro Contrato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNomeContrato = new JTextField();
		txtNomeContrato.setText("Nome");
		txtNomeContrato.setBounds(10, 31, 318, 20);
		contentPane.add(txtNomeContrato);
		txtNomeContrato.setColumns(10);

		txtrClausula = new JTextArea();
		txtrClausula.setText("Clausula");
		txtrClausula.setBounds(10, 88, 768, 117);
		contentPane.add(txtrClausula);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 247, 768, 144);
		contentPane.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JLabel lblClausula = new JLabel("Clausula");
		lblClausula.setBounds(10, 69, 46, 14);
		contentPane.add(lblClausula);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 11, 46, 14);
		contentPane.add(lblDescrio);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(10, 402, 89, 23);
		contentPane.add(btnAlterar);

		btnInserir = new JButton("Inserir");
		btnInserir.setBounds(10, 216, 89, 23);
		contentPane.add(btnInserir);

		btnCancelar = new JButton("Apagar");
		btnCancelar.setBounds(109, 216, 89, 23);
		contentPane.add(btnCancelar);

		btnDeletar = new JButton("Remover");
		btnDeletar.setBounds(109, 402, 89, 23);
		contentPane.add(btnDeletar);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(689, 402, 89, 23);
		contentPane.add(btnSalvar);
		
		txtTituloClasula = new JTextField();
		txtTituloClasula.setBounds(311, 216, 338, 20);
		contentPane.add(txtTituloClasula);
		txtTituloClasula.setColumns(10);
		
		lblTituloClausula = new JLabel("Titulo Clausula");
		lblTituloClausula.setBounds(211, 222, 117, 14);
		contentPane.add(lblTituloClausula);
		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnDeletar.addActionListener(this);
		btnInserir.addActionListener(this);
		btnSalvar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		System.out.println(acao);

		switch (acao) {
		case "Alterar":
			alterar();

			break;

		case "Apagar":
			apagar();
			break;

		case "Remover":
			remover();
			break;

		case "Inserir":
			inserir();
			break;

		case "Salvar":
			salvar();

			break;

		default:
			break;
		}

	}

	private void salvar() {
		JOptionPane.showMessageDialog(null, "Salvo Com sucesso!!");
		dispose();
		Contrato contrato = new Contrato();
		contrato.setTipo(txtNomeContrato.getText());
		List<Clausula> listaClausula = new ArrayList<Clausula>();
 		for (int i = 0; i < model.getRowCount(); i++) {
			listaClausula.add((Clausula)model.retornaObjeto(i));
		}
 		contrato.setClausula(listaClausula);
 		
 		model.removeTudo();
 		apagar();
 		banco.salvarObjeto(contrato);
 		JOptionPane.showMessageDialog(contentPane, "Contrato Salvo Con sucesso");
 		dispose();

	}

	private void inserir() {
		Clausula clau = new Clausula();
		clau.setTitulo(txtTituloClasula.getText());
		clau.setConteudo(txtrClausula.getText());
		
		model.addRow(clau);
		apagar();
		if (model.getRowCount()>0) {
			btnAlterar.setEnabled(true);
			btnDeletar.setEnabled(true);
		}else {
			btnAlterar.setEnabled(false);
			btnDeletar.setEnabled(false);
		}

	}

	private void remover() {
		model.removeRow(table.getSelectedRow());
		if (model.getRowCount()>0) {
			btnAlterar.setEnabled(true);
			btnDeletar.setEnabled(true);
		}else {
			btnAlterar.setEnabled(false);
			btnDeletar.setEnabled(false);
		}

	}

	private void apagar() {
		txtTituloClasula.setText("");
		txtrClausula.setText("");
		if (model.getRowCount()>0) {
			btnAlterar.setEnabled(true);
			btnDeletar.setEnabled(true);
		}else {
			btnAlterar.setEnabled(false);
			btnDeletar.setEnabled(false);
		}

	}

	private void alterar() {
		System.out.println(model.getRowCount());
		Clausula clausu = (Clausula) model.retornaObjeto(table.getSelectedRow());
		txtrClausula.setText(clausu.getConteudo());
		txtTituloClasula.setText(clausu.getTitulo());
		model.removeRow(table.getSelectedRow());
		btnAlterar.setEnabled(false);
		btnDeletar.setEnabled(false);

	}

}
