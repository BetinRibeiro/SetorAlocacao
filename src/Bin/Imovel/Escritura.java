package Bin.Imovel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "escritura")
public class Escritura {

	// tenho que verificar se o numero que identifica a escritura contem letras - TODO
	@Column(name = "numero_escritura",length = 20, nullable = true)
	private String numeroEscritura;
	@Column(name = "nome_cartorio",length = 100, nullable = true)
	private String nomeCartorio;
	@Column(name = "cidade_cartorio",length = 100, nullable = true)
	private String cidadeCartorio;
	@Column(name = "uf_escritura",length = 2, nullable = true)
	private String ufEscritura;
	
	public String getUf() {
		return ufEscritura;
	}
	public void setUf(String ufEscritura) {
		this.ufEscritura = ufEscritura;
	}
	public String getNumeroEscritura() {
		return numeroEscritura;
	}
	public void setNumeroEscritura(String numeroEscritura) {
		this.numeroEscritura = numeroEscritura;
	}
	public String getNomeCartorio() {
		return nomeCartorio;
	}
	public void setNomeCartorio(String nomecartorio) {
		this.nomeCartorio = nomecartorio;
	}
	public String getCidadeCartorio() {
		return cidadeCartorio;
	}
	public void setCidadeCartorio(String cidadeCartorio) {
		this.cidadeCartorio = cidadeCartorio;
	}
	

}
