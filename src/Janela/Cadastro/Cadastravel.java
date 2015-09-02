package Janela.Cadastro;

public interface Cadastravel {
	void inserir(Object ob);
	void salvar();

	void liberarAlteracao();
	void limparTxt();
	void txtEnable(boolean valor);

}
