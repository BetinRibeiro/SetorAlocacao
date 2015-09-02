package Bin.Captacao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "captacao")
public class Captacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	
	@Column(name = "nome",length=50, nullable=true)
	private String nome;
	
	@Column(name = "num_telefone",length=12, nullable=true)
	private String telefone;
	
	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	@Column(name = "descricao",length=200, nullable=true)
	private String descricao;
	
	@Column(name = "interesse",length=35, nullable=true)
	private String interesse;
	
	@Column(name = "vlr_med", nullable=true)
	private float valorMedio;
	
	@Column(name = "observacao",length=35, nullable=true)
	private String observacao;
	
	
	
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getInteresse() {
		return interesse;
	}
	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}
	public float getValorMedio() {
		return valorMedio;
	}
	public void setValorMedio(float valorMedio) {
		this.valorMedio = valorMedio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
