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
	

}
