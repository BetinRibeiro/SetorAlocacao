package Bin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

//Aparentemente terminado
@Embeddable
@Table(name = "endereco")
public class Endereco {
	@Column(name = "lougradouro",length=100, nullable=true)
	private String lougradouro;
	@Column(name = "cidade",length=50, nullable=true)
	private String cidade;
	@Column(name = "bairro",length=50, nullable=true)
	private String bairro;
	@Column(name = "uf_endereco",length=2, nullable=true)
	private String ufEndereco;
	@Column(name = "cep",length=9, nullable=true)
	private String cep;
	public String getLougradouro() {
		return lougradouro;
	}
	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return ufEndereco;
	}
	public void setUf(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
	
	
	

}
