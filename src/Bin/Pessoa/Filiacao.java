package Bin.Pessoa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

//Aparentemente terminado TODO
@Embeddable
@Table(name = "filiacao_pessoa")
public class Filiacao {
	@Column(name = "nome_pai",length=100)
	private String nomePai;
	@Column(name = "nome_mae",length=100)
	private String nomeMae;

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

}
