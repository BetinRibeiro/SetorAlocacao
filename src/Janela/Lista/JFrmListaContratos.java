package Janela.Lista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Bin.Contrato.Contrato;
import Janela.Cadastro.JFrmCadastroContrato;
import Persistence.Dao;
import TableModel.TMContrato;

public class JFrmListaContratos extends JFrmLista implements ActionListener {
	private Dao banco = new Dao();
	private TMContrato model = new TMContrato();
	private Contrato Contrato = null;
	
	//TODO retirar esse metodo estatico pois não ha necessidade 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					JFrmListaContratos frame = new JFrmListaContratos("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrmListaContratos(String escolher) {
		super(escolher);
		model= new TMContrato();
		tableObjeto = new JTable(model);
		tableObjeto.getTableHeader().setReorderingAllowed(false);
		tableObjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableObjeto);
		renomeando("Lista de Contratos", "Nome");
	}

	@Override
	void retorno() {
		setObj((Contrato) banco.buscarPorId(
				Contrato.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0)));
		getObj();
		dispose();
	}

	@Override
	public void setObj(Object obj) {
		this.Contrato = (Bin.Contrato.Contrato) obj;
	}

	@Override
	public Object getObj() {
		return Contrato;
	}

	@Override
	void Detalhe() {
		Contrato Contrato = (Contrato) banco.buscarPorId(
				Contrato.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0));
		JFrmCadastroContrato c = new JFrmCadastroContrato();
		txtNomeBusca.setText("");
		model.removeTudo();
		c.setVisible(true);
	}

	@Override
	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNomeHabilitado(Contrato.class,
					txtNomeBusca.getText(), "nome", true);
			for (int i = 0; i < lista.size(); i++) {
				Contrato classif = (Contrato) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um Contrato.");
		}

	}

	@Override
	protected void renomeando(String titulo, String nomeBusca) {
		setTitle(titulo);
		lblNomeBusca.setText(nomeBusca);
		
	}

}
