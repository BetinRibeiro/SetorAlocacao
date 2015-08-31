package Bin.Imovel;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import Bin.Endereco;
import Bin.Pessoa.Pessoa;

//Aparentemente terminado
@Entity
@Table(name = "imovel")
public class Imovel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	@Column(name = "cod_imovel",length=6, nullable=true)
	private String codImovel;
	@Embedded
	private Pessoa proprietario;
	@Embedded
	private Escritura escritura;
	@Embedded
	private Endereco end;
	@Embedded
	private Caracteristica caracteristicas;
	@Column(name = "tipo",length=50, nullable=true)
	private String tipo;
	@Column(name = "finalidade",length=50, nullable=true)
	private String finalidade;
	@Column(name = "valor",length=11, nullable=true)
	private float valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getProprietario() {
		return proprietario;
	}
	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	public Escritura getEscritura() {
		return escritura;
	}
	public void setEscritura(Escritura escritura) {
		this.escritura = escritura;
	}
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}
	public Caracteristica getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(Caracteristica caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
}
