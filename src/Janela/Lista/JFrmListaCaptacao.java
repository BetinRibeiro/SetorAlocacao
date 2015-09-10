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

import Bin.Captacao.Captacao;
import Janela.Cadastro.JFrmCaptacao;
import Persistence.Dao;
import TableModel.TMCaptacao;

/**
 * JFrmListaCaptacao lista as captações nesse caso lista quando se pesquisa alguma captação
 * @author Rogoberto
 *
 */

public class JFrmListaCaptacao extends JFrmLista implements ActionListener {

	private Dao banco = new Dao();
	private TMCaptacao model = new TMCaptacao();
	private Captacao Captacao = null;
	
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
					JFrmListaCaptacao frame = new JFrmListaCaptacao("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrmListaCaptacao(String escolher) {
		super(escolher);
		model= new TMCaptacao();
		tableObjeto = new JTable(model);
		tableObjeto.getTableHeader().setReorderingAllowed(false);
		tableObjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableObjeto);
		renomeando("Lista de Captações", "Nome");
		buscar();
	}


	@Override
	void retorno() {
		setObj((Captacao) banco.buscarPorId(
				Captacao.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0)));
		getObj();
		dispose();
	}

	@Override
	public void setObj(Object obj) {
		this.Captacao = (Captacao) obj;
	}

	@Override
	public Object getObj() {
		return Captacao;
	}

	@Override
	void Detalhe() {
		Captacao Captacao = (Captacao) banco.buscarPorId(
				Captacao.class,
				(Integer) tableObjeto.getValueAt(
						tableObjeto.getSelectedRow(), 0));
		JFrmCaptacao c = new JFrmCaptacao(Captacao);
		txtNomeBusca.setText("");
		model.removeTudo();
		c.setVisible(true);
	}

	@Override
	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNomeHabilitado(Captacao.class,
					txtNomeBusca.getText(), "nome", true);
			for (int i = 0; i < lista.size(); i++) {
				Captacao classif = (Captacao) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPane,
					"ERRO ao buscar um Captacao.");
		}

	}
	@Override
	protected void renomeando(String titulo, String nomeBusca) {
		setTitle(titulo);
		lblNomeBusca.setText(nomeBusca);
		
	}

}
