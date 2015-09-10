package Janela.Lista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import Bin.Pessoa.Pessoa;
import Janela.Cadastro.JFrmCadastroPessoa;
import Persistence.Dao;
import TableModel.TMPessoa;

public class JFrmListaPessoa extends JFrmLista implements ActionListener {
	private Dao banco = new Dao();
	private TMPessoa model = new TMPessoa();
	private Pessoa Pessoa = null;
	
	//TODO retirar esse metodo estatico pois não ha necessidade 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					JFrmListaPessoa frame = new JFrmListaPessoa("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrmListaPessoa(String escolher) {
		super(escolher);
		model= new TMPessoa();
		tableObjeto = new JTable(model);
		tableObjeto.getTableHeader().setReorderingAllowed(false);
		tableObjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableObjeto);
		renomeando("Lista de Pessoas", "Nome");
	}

	@Override
	void retorno() {
		setObj((Pessoa) banco.buscarPorId(
				Pessoa.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0)));
		getObj();
		dispose();
	}

	@Override
	public void setObj(Object obj) {
		this.Pessoa = (Bin.Pessoa.Pessoa) obj;
	}

	@Override
	public Object getObj() {
		return Pessoa;
	}

	@Override
	void Detalhe() {
		Pessoa Pessoa = (Pessoa) banco.buscarPorId(
				Pessoa.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0));
		JFrmCadastroPessoa c = new JFrmCadastroPessoa(Pessoa);
		txtNomeBusca.setText("");
		model.removeTudo();
		c.setVisible(true);
	}

	@Override
	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNomeHabilitado(Pessoa.class,
					txtNomeBusca.getText(), "nome", true);
			for (int i = 0; i < lista.size(); i++) {
				Pessoa classif = (Pessoa) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um Pessoa.");
		}

	}

	@Override
	protected void renomeando(String titulo, String nomeBusca) {
		setTitle(titulo);
		lblNomeBusca.setText(nomeBusca);
		
	}

}
