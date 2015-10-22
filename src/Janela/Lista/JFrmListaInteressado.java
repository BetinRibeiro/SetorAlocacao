package Janela.Lista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import Bin.Interessado.Interessado;
import Janela.Cadastro.JFrmInteressado;
import Persistence.Dao;
import TableModel.TMInteressado;

/**
 * JFrmListainteressado lista as captações nesse caso lista quando se pesquisa alguma captação
 * @author Rogoberto
 *
 */

public class JFrmListaInteressado extends JFrmLista implements ActionListener {

	private Dao banco = new Dao();
	private TMInteressado model = new TMInteressado();
	private Interessado interessado = null;
	
	/**
	 * essa formatação será simplesmente para converter datas no formato em que
	 * o banco entende
	 */
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	//TODO retirar esse metodo estatico pois não ha necessidade 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					UIManager
							.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
					JFrmListaInteressado frame = new JFrmListaInteressado("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrmListaInteressado(String escolher) {
		super(escolher);
		model= new TMInteressado();
		tableObjeto = new JTable(model);
		tableObjeto.getTableHeader().setReorderingAllowed(false);
		tableObjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableObjeto);
		renomeando("Lista de Captações", "Nome");
		buscar();
	}


	@Override
	void retorno() {
		setObj((Interessado) banco.buscarPorId(
				Interessado.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0)));
		getObj();
		dispose();
	}

	@Override
	public void setObj(Object obj) {
		this.interessado = (Interessado) obj;
	}

	@Override
	public Object getObj() {
		return interessado;
	}

	@Override
	void Detalhe() {
		Interessado interessado = (Interessado) banco.buscarPorId(
				Interessado.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0));
		JFrmInteressado c = new JFrmInteressado(interessado);
		txtNomeBusca.setText("");
		model.removeTudo();
		c.setVisible(true);
	}

	@Override
	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNomeHabilitado(Interessado.class,
					txtNomeBusca.getText(), "nome", true);
			for (int i = 0; i < lista.size(); i++) {
				Interessado classif = (Interessado) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um interessado.");
		}

	}
	@Override
	protected void renomeando(String titulo, String nomeBusca) {
		setTitle(titulo);
		lblNomeBusca.setText(nomeBusca);
		
	}

}
