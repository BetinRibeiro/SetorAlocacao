package Bin.Contrato;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Bin.Imovel.Imovel;

/**
 * Um <code>Contrato</code> é o acordo fixado entre partes
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 * @see Imovel
 * @see Pessoa
 * @see Clausula
 */
@Entity
@Table(name = "contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private int id;
	@Column(name = "nome", length = 80)
	private String tipo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaClausula")
	private List<Clausula> listaClausula = new ArrayList<Clausula>();

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

	public List<Clausula> getClausula() {
		return listaClausula;
	}

	public void setClausula(List<Clausula> listaClausula) {
		this.listaClausula = listaClausula;
	}

}
