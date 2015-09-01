package Bin.Pessoa;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

//Aparentemente terminado TODO
@Embeddable
@Table(name = "telefone_pessoa")
public class Telefone {
	@Column(name = "fone1",length=12, nullable=true)
	private long fone1;
	@Column(name = "fone2",length=12, nullable=true)
	private long fone2;
	public long getFone1() {
		return fone1;
	}
	public void setFone1(long fone1) {
		this.fone1 = fone1;
	}
	public long getFone2() {
		return fone2;
	}
	public void setFone2(long fone2) {
		this.fone2 = fone2;
	}
	
	
	

}
