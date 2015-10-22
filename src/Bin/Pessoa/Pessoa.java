package Bin.Pessoa;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Bin.Endereco;
//Aparentemente terminado TODO
@Entity
@Table(name = "pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	@Column(name = "nome",length=80)
	private String nome;
	@Column(name = "nascionalidade",length=80)
	private String nascionalidade;
	@Column(name = "naturalidade",length=80)
	private String naturalidade;
	@Column(name = "estado_civil",length=80)
	private String estadoCivil;
	@Column(name = "cargo",length=80)
	private String cargo;
	
	@Column(name = "cpf",length=11)
	private long cpf;
	@Column(name = "email",length=80)
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataNascimento;
	@Column(name = "observacao",length=80)
	private String observacao;
	@Column(name = "escolaridade",length=80)
	private String escolaridade;
	@Column(name = "sexo",length=80)
	private String sexo;
	
	@Column(name = "uf_naturalidade",length=2)
	private String ufNaturalidade;
	
	
	//aqui é uma chave estrangeira
	@Embedded
	private Endereco end;
	@Embedded
	private Rg rg;
	@Embedded
	private Telefone telefone;
	@Embedded
	private Filiacao filiacao;
	

	
	public String getUfNaturalidade() {
		return ufNaturalidade;
	}
	public void setUfNaturalidade(String ufNaturalidade) {
		this.ufNaturalidade = ufNaturalidade;
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
	public String getNascionalidade() {
		return nascionalidade;
	}
	public void setNascionalidade(String nascionalidade) {
		this.nascionalidade = nascionalidade;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Filiacao getFiliacao() {
		return filiacao;
	}
	public void setFiliacao(Filiacao filiacao) {
		this.filiacao = filiacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Rg getRg() {
		return rg;
	}
	public void setRg(Rg rg) {
		this.rg = rg;
	}

	
}
