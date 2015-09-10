package Bin.Pessoa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
@Embeddable
@Table(name = "endereco")
public class Rg {
	@Column(name = "rg",length=10, nullable=true, unique=true)
	private long rg;
	@Column(name = "orgao_espedidor",length=10, nullable=true, unique=false)
	private String orgaoEspedidor;
	@Column(name = "uf_rg",length=2, nullable=true)
	private String ufrg;
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	public String getOrgaoEspedidor() {
		return orgaoEspedidor;
	}
	public void setOrgaoEspedidor(String orgaoEspedidor) {
		this.orgaoEspedidor = orgaoEspedidor;
	}
	public String getUfrg() {
		return ufrg;
	}
	public void setUfrg(String ufrg) {
		this.ufrg = ufrg;
	}
	
	
	

}
