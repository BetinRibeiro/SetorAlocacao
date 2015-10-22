package Bin.Interessado;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Uma
 * <code>Captacao</code> representa o contato estabelecido
 *  entre a empresa e uma pessoa que pode estar com interesse de alugar um 
 *  imovel ou contratar os serviços de administração de um imovel que possui
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 */

@Entity
@Table(name = "captacao")
public class Interessado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;

	@Column(name = "nome", length = 50)
	private String nome;

	@Column(name = "num_telefone", length = 12)
	private String telefone;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(name = "descricao", length = 200)
	private String descricao;

	@Column(name = "interesse", length = 35)
	private String interesse;



	@Column(name = "observacao", length = 35)
	private String observacao;
	
	/**
	 * retorna o Observação do endereço
	 * 
	 * @return String Observação
	 */

	public String getObservacao() {
		return observacao;
	}/**
	 * Altera o Observação do endereço
	 * 
	 * @param Observação
	 */

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}/**
	 * retorna o Interesse do endereço
	 * 
	 * @return String Interesse
	 */

	public String getInteresse() {
		return interesse;
	}/**
	 * Altera o Interesse do endereço
	 * 
	 * @param Interesse
	 */

	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}
	/**
	 * retorna o Id do endereço
	 * 
	 * @return int Id
	 */
	public int getId() {
		return id;
	}/**
	 * Altera o Id do endereço
	 * 
	 * @param Id
	 */

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * retorna o Nome do endereço
	 * 
	 * @return String Nome
	 */
	public String getNome() {
		return nome;
	}/**
	 * Altera o Nome do endereço
	 * 
	 * @param Nome
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}/**
	 * retorna o Telefone do endereço
	 * 
	 * @return String Telefone
	 */

	public String getTelefone() {
		return telefone;
	}/**
	 * Altera o Telefone do endereço
	 * 
	 * @param Telefone
	 */

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}/**
	 * retorna a DataCadastro do endereço
	 * 
	 * @return String DataCadastro
	 */

	public Date getDataCadastro() {
		return dataCadastro;
	}/**
	 * Altera a DataCadastro do endereço
	 * 
	 * @param DataCadastro
	 */

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * retorna o lougradouro do endereço
	 * 
	 * @return String lougradouro
	 */
	public String getDescricao() {
		return descricao;
	}/**
	 * Altera o lougradouro do endereço
	 * 
	 * @param lougradouro
	 */

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
