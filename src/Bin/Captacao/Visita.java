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
@Entity
@Table(name = "visita")
public class Visita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataCadastro;
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataAgendamento;
	@OneToOne
    @JoinColumn(name="id_imovel", nullable=true)
	private Imovel imovel;
	@OneToOne
    @JoinColumn(name="id_captacao", nullable=true)
	private Captacao captacao;
	@OneToOne
    @JoinColumn(name="id_atendente", nullable=true)
	private Atendente atendente;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public Captacao getCaptacao() {
		return captacao;
	}
	public void setCaptacao(Captacao captacao) {
		this.captacao = captacao;
	}
	public Atendente getAtendente() {
		return atendente;
	}
	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	
	
	

}
