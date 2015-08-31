package Bin.Imovel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

//Aparentemente terminado TODO
@Embeddable
@Table(name = "caracteristica_imovel")
public class Caracteristica {
	@Column(name = "area",length = 8, nullable = true)
	private String area;
	@Column(name = "numero_comodos",length = 2, nullable = true)
	private int numeroComodos;
	@Column(name = "numero_garagens",length = 2, nullable = true)
	private int numeroGaragens;
	@Column(name = "numero_suits",length = 2, nullable = true)
	private int numeroSuits;
	@Column(name = "numero_banheiros",length=2, nullable=true)
	private int numeroBanheiros;
	@Column(name = "caracteristica",length=200, nullable=true)
	private String caracteristicas;
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getNumeroComodos() {
		return numeroComodos;
	}
	public void setNumeroComodos(int numeroComodos) {
		this.numeroComodos = numeroComodos;
	}
	public int getNumeroGaragens() {
		return numeroGaragens;
	}
	public void setNumeroGaragens(int numeroGaragens) {
		this.numeroGaragens = numeroGaragens;
	}
	public int getNumeroSuits() {
		return numeroSuits;
	}
	public void setNumeroSuits(int numeroSuits) {
		this.numeroSuits = numeroSuits;
	}
	public int getNumeroBanheiros() {
		return numeroBanheiros;
	}
	public void setNumeroBanheiros(int numeroBanheiros) {
		this.numeroBanheiros = numeroBanheiros;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	

}
