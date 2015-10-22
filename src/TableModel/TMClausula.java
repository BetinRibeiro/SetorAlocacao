package TableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Bin.Contrato.Clausula;

@SuppressWarnings("serial")
public class TMClausula extends AbstractTableModel {

	private List<Clausula> dados;
	private String[] colunas = { "Titulo"};

	// voc� precisar que os dados tamb�m sejam imediatamente alterados no banco
	// de dados por exemplo,
	// voc� vai precisar adicionar um TableModelListener ao seu model que
	// executar� o m�todo
	// tableChanged toda vez que os dados da JTable forem alterados.
	public TMClausula() {
		dados = new ArrayList<Clausula>();

	}

	public void addRow(Clausula p) {

		this.dados.add(p);
		this.fireTableDataChanged();
	}

	public void removeTudo() {

		this.dados.clear();
		this.fireTableDataChanged();
	}

	public String getColumnName(int num) {
		return this.colunas[num];
	}

	// Tamb�m iremos precisar de um m�todo que remova uma linha da tabela
	public String removeRow(int linha) {
		String titulo = this.dados.get(linha).getTitulo();
		this.dados.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
		return titulo;
	}

	// Se voc� deve lembrar quando utiliz�vamos o DefaultTableModel pod�amos
	// alterar a tabela
	// simplesmente dando um duplo clique em cima e alguma c�lula e ela
	// permitiria a edi��o.
	// Isso acontecia porque no DefaultTableModel o m�todo isCellEditable(int
	// linha, int coluna)
	// que � chamado para saber se uma c�lula � edit�vel sempre retornava true,
	// mas no AbstractTableModel
	// ele retorna sempre false, ent�o devemos sobrescreve-lo
	public boolean isCellEditable(int linha, int coluna) {
		return true;
	}

	// Estes m�todos devem retornar respectivamente o numero de linhas, o numero
	// de colunas
	// e o valor da c�lula correspondente aos valores de linha e coluna
	// fornecidos por par�metro.
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
		
	}
	public Object retornaObjeto(int linha) {
		System.out.println(dados.get(linha).getTitulo());
		return dados.get(linha);
	}

	@Override
	public Object getValueAt(int linha, int coluna) {

		switch (coluna) {

		case 0:
			return dados.get(linha).getTitulo();


		}
		return null;
	}

}
