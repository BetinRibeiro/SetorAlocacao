package Bin.Contrato;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

//Aparentemente terminado TODO
@Embeddable
@Table(name = "caracteristica_imovel")
public class Clausula {
	@Column(name = "titulo", length = 50, nullable = true)
	private String titulo;
	// verificar aqui o tamanho maximo que pode ter um conteudo com todos os
	// paragrafos
	@Column(name = "conteudo", length = 10000, nullable = true)
	private String conteudo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
