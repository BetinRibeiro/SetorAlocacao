package Janela.Lista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import Bin.Captacao.Captacao;
import Janela.Cadastro.JFrmCaptacao;
import Persistence.Dao;
import TableModel.TMCaptacao;

public class JFrmListaCaptacao extends JFrmLista implements ActionListener {

	private Dao banco = new Dao();
	private TMCaptacao model = new TMCaptacao();
	private Captacao Captacao = null;
	
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
