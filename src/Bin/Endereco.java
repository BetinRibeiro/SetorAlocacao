package Bin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import Bin.Imovel.Imovel;
import Bin.Pessoa.Pessoa;

/**
 * Um <code>Endereço</code> representa o conjunto 
 * de dados que compõe o local onde mora ou se 
 * encontra uma <code>Pessoa</code> ou de um <code>Imóvel</code>
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 * @see Imovel
 * @see Pessoa
 */
// Aparentemente terminado
@Embeddable
@Table(name = "endereco")
public class Endereco {
	@Column(name = "lougradouro", length = 100)
	private String lougradouro;
	@Column(name = "cidade", length = 50)
	private String cidade;
	@Column(name = "bairro", length = 50)
	private String bairro;
	@Column(name = "uf_endereco", length = 2)
	private String ufEndereco;
	@Column(name = "cep", length = 9)
	private String cep;

	/**
	 * retorna o lougradouro do endereço
	 * 
	 * @return String lougradouro
	 */
	public String getLougradouro() {
		return lougradouro;
	}

	/**
	 * Altera o lougradouro do endereço
	 * 
	 * @param lougradouro
	 */

	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}

	/**
	 * retorna a cidade do endereço
	 * 
	 * @return String cidade
	 */

	public String getCidade() {
		return cidade;
	}

	/**
	 * Altera a cidade do endereço
	 * 
	 * @param cidade
	 */

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * retorna o bairro do endereço
	 * 
	 * @return String bairro
	 */

	public String getBairro() {
		return bairro;
	}

	/**
	 * Altera o bairro do endereço
	 * 
	 * @param bairro
	 */

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * retorna o uf do endereço
	 * 
	 * @return String uf
	 */
	public String getUf() {
		return ufEndereco;
	}

	/**
	 * Altera o uf do endereço
	 * 
	 * @param uf
	 */

	public void setUf(String ufEndereco) {
		this.ufEndereco = ufEndereco;
	}

	/**
	 * retorna o cep do endereço
	 * 
	 * @return String cep
	 */

	public String getCep() {
		return cep;
	}

	/**
	 * Altera o cep do endereço verifica se possui exatamente 8 digitos
	 * 
	 * @param cep
	 */
	public void setCep(String cep) {
		if (cep.length() == 8) {
			this.cep = cep;
		} else {
			cep=null;
		
		}

	}


}
