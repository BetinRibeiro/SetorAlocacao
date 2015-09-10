package Bin.Imovel;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@Column(name = "cod_imovel",length=6, unique=false)
	private String codImovel;
	@OneToOne
    @JoinColumn(name="id_pessoa")
	private Pessoa proprietario;
	@Embedded
	private Escritura escritura;
	@Embedded
	private Endereco end;
	@Embedded
	private Caracteristica caracteristicas;
	@Column(name = "valor",length=11, nullable=true)
	private float valor;
	@Column(name = "valor_aluguel",length=11, nullable=true)
	private float valorAluguel;
	@Column(name = "informacoes",length=80, nullable=true)
	private String informacoes;
	@Column(name = "disponivel", nullable=true)
	private boolean disponivel;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodImovel() {
		return codImovel;
	}
	public void setCodImovel(String codImovel) {
		this.codImovel = codImovel;
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(float valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}
