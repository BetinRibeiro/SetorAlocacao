package Bin.Captacao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Bin.Imovel.Imovel;
import Bin.Pessoa.Atendente;

/**
 * Uma
 * <code>Visita</code> representa local e data que uma 
 * </code>Captacao<code> foi marcada para visitar o <code>Imovel</code> 
 * com data em que foi criada e a data que ser� a feita a visita
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 * @see Imovel
 * @see Captacao
 */
@Entity
@Table(name = "visita")
public class Visita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dataCadastro;
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date dataAgendamento;
	@OneToOne
	@JoinColumn(name = "id_imovel", nullable = true)
	private Imovel imovel;
	@OneToOne
	@JoinColumn(name = "id_captacao", nullable = true)
	private Captacao captacao;
	@OneToOne
	@JoinColumn(name = "id_atendente", nullable = true)
	private Atendente atendente;
	@Column(name = "concluida", nullable = true)
	private boolean concluida;

	/**
	 * retorna o se foi ou n�o concluida
	 * 
	 * @return boolean concluida
	 */
	public boolean getConcluida() {
		return concluida;
	}
	/**
	 * Altera o status de concluida ou n�o
	 * 
	 * @param concluida
	 */
	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	/**
	 * retorna o ID do endere�o
	 * 
	 * @return String ID
	 */
	public int getId() {
		return id;
	}
	/**
	 * Altera o ID do endere�o
	 * 
	 * @param ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * retorna o dataCadastro do endere�o
	 * 
	 * @return String dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}/**
	 * Altera o dataCadastro do endere�o
	 * 
	 * @param dataCadastro
	 */

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * retorna o dataAgendamento do endere�o
	 * 
	 * @return String dataAgendamento
	 */
	public Date getDataAgendamento() {
		return dataAgendamento;
	}/**
	 * Altera o dataAgendamento do endere�o
	 * 
	 * @param dataAgendamento
	 */

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	/**
	 * retorna o imovel do endere�o
	 * 
	 * @return String imovel
	 */
	public Imovel getImovel() {
		return imovel;
	}/**
	 * Altera o imovel do endere�o
	 * 
	 * @param imovel
	 */

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	/**
	 * retorna o captacao do endere�o
	 * 
	 * @return String captacao
	 */

	public Captacao getCaptacao() {
		return captacao;
	}/**
	 * Altera o captacao do endere�o
	 * 
	 * @param captacao
	 */

	public void setCaptacao(Captacao captacao) {
		this.captacao = captacao;
	}
	/**
	 * retorna o atendente do endere�o
	 * 
	 * @return String atendente
	 */

	public Atendente getAtendente() {
		return atendente;
	}/**
	 * Altera o atendente do endere�o
	 * 
	 * @param atendente
	 */

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

}
