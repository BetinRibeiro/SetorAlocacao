package Bin.Contrato;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;


/**
 * Uma <code>Clausula</code> é a descrição de uma parte do contrato cada 
 * <code>Contrato</code> possui uma ou um conjunto de clausulas
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 */
@Embeddable
@Table(name = "clausula")
public class Clausula {
	@Column(name = "titulo", length = 50)
	private String titulo;
	// verificar aqui o tamanho maximo que pode ter um conteudo com todos os
	// paragrafos
	@Column(name = "conteudo", length = 10000)
	private String conteudo;
	

	/**
	 * retorna o titulo do endereço
	 * 
	 * @return String titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * retorna o Conteudo do endereço
	 * 
	 * @return String Conteudo
	 */
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
