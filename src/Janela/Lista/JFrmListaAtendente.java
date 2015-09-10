package Janela.Lista;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import Bin.Pessoa.Atendente;
import Janela.Cadastro.JFrmCadastroAtendente;
import Persistence.Dao;
import TableModel.TMAtendente;

public class JFrmListaAtendente extends JFrmLista {

	private Dao banco = new Dao();
	private TMAtendente model = new TMAtendente();
	private Atendente Atendente = null;

	// TODO retirar esse metodo estatico pois não ha necessidade
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					JFrmListaAtendente frame = new JFrmListaAtendente("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// contrutor
	public JFrmListaAtendente(String escolher) {
		super(escolher);
		model = new TMAtendente();
		tableObjeto = new JTable(model);
		tableObjeto.getTableHeader().setReorderingAllowed(false);
		tableObjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableObjeto);
		renomeando("Lista Atendente", "Atendente");
	}

	@Override
	void retorno() {
		setObj((Atendente) banco.buscarPorId(Atendente.class,
				(Integer) tableObjeto.getValueAt(tableObjeto.getSelectedRow(),
						0)));
		getObj();
		dispose();
	}

	@Override
	public void setObj(Object obj) {
		this.Atendente = (Bin.Pessoa.Atendente) obj;
	}

	@Override
	public Object getObj() {
		return Atendente;
	}

	@Override
	void Detalhe() {
		Atendente Atendente = (Atendente) banco.buscarPorId(Atendente.class,
				(Integer) tableObjeto.getValueAt(tableObjeto.getSelectedRow(),
						0));
		JFrmCadastroAtendente c = new JFrmCadastroAtendente(Atendente);
		txtNomeBusca.setText("");
		model.removeTudo();
		c.setVisible(true);
	}

	@Override
	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNomeHabilitado(Atendente.class,
					txtNomeBusca.getText(), "nome", true);
			for (int i = 0; i < lista.size(); i++) {
				Atendente classif = (Atendente) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um Atendente.");
		}

	}

	@Override
	protected void renomeando(String titulo, String nomeBusca) {
		setTitle(titulo);
		lblNomeBusca.setText(nomeBusca);

	}

}
