package Bin.Contrato;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	@Column(name = "nome",length=80, nullable=true, unique=false)
	private String tipo;
	@OneToMany
	private Collection<Clausula> clausula = new ArrayList<Clausula>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Collection<Clausula> getClausula() {
		return clausula;
	}
	public void setClausula(Collection<Clausula> clausula) {
		this.clausula = clausula;
	}
	

}
