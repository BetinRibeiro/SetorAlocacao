package Bin.Imovel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "escritura")
public class Escritura {

	// tenho que verificar se o numero que identifica a escritura contem letras - TODO
	@Column(name = "numero_escritura",length = 20, nullable = true)
	private long numeroEscritura;
	@Column(name = "nome_cartorio",length = 100, nullable = true)
	private String nomeCartorio;
	@Column(name = "cidade_cartorio",length = 100, nullable = true)
	private String cidadeCartorio;
	@Column(name = "uf",length = 2, nullable = true)
	private String uf;
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public long getNumeroEscritura() {
		return numeroEscritura;
	}
	public void setNumeroEscritura(long numeroEscritura) {
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
