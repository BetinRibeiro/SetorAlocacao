package Janela.Lista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import Bin.Imovel.Imovel;
import Janela.Cadastro.JFrmCadastroImovel;
import Persistence.Dao;
import TableModel.TMImovel;

public class JFrmListaImoveis extends JFrmLista implements ActionListener {

	private Dao banco = new Dao();
	private TMImovel model = new TMImovel();
	private Imovel Imovel = null;
	
	//TODO retirar esse metodo estatico pois não ha necessidade 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					JFrmListaImoveis frame = new JFrmListaImoveis("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrmListaImoveis(String escolher) {
		super(escolher);
		model= new TMImovel();
		tableObjeto = new JTable(model);
		tableObjeto.getTableHeader().setReorderingAllowed(false);
		tableObjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableObjeto);
		renomeando("Lista de Imoveis", "Codigo");
	}

	@Override
	void retorno() {
		setObj((Imovel) banco.buscarPorId(
				Imovel.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0)));
		getObj();
		dispose();
	}

	@Override
	public void setObj(Object obj) {
		this.Imovel = (Imovel) obj;
	}

	@Override
	public Object getObj() {
		return Imovel;
	}

	@Override
	void Detalhe() {
		Imovel Imovel = (Imovel) banco.buscarPorId(
				Imovel.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0));
		JFrmCadastroImovel c = new JFrmCadastroImovel(Imovel);
		txtNomeBusca.setText("");
		model.removeTudo();
		c.setVisible(true);
	}

	@Override
	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNome(Imovel.class,
					txtNomeBusca.getText(), "id");
			for (int i = 0; i < lista.size(); i++) {
				Imovel classif = (Imovel) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um Imovel.");
		}

	}
	@Override
	protected void renomeando(String titulo, String nomeBusca) {
		setTitle(titulo);
		lblNomeBusca.setText(nomeBusca);
		
	}

}