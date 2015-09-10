package Bin.Imovel;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 * Um
 * <code>Caracteristica</code> é o conjunto de atributos que possui o imovel
 * 
 * @author Rogoberto Ribeiro
 * @version 1.0
 *
 */
@Embeddable
@Table(name = "informacaoes_imovel")
public class Caracteristica{
	@Column(name = "quantidade_garagem",length = 2, nullable = true)
	private int quantidadeGaragem;
	@Column(name = "quantidade_quarto",length = 2, nullable = true)
	private int quantidadeQuarto;
	@Column(name = "quantidade_banheiro",length = 2, nullable = true)
	private int quantidadeBanheiro;
	@Column(name = "quantidade_sala",length=2, nullable=true)
	private int quantidadeSala;
	@Column(name = "quantidade_quintal",length=2, nullable=true)
	private int quantidadeQuintal;
	@Column(name = "quantidade_cozinha",length=2, nullable=true)
	private int quantidadeCozinha;
	@Column(name = "quantidade_suit",length=2, nullable=true)
	private int quantidadeSuit;
	@Column(name = "quantidade_comodos",length=2, nullable=true)
	private int quantidadeComodos;
	@Column(name = "tipo",length=200, nullable=true)
	private String tipo;
	@Column(name = "finalidade",length=200, nullable=true)
	private String finalidade;
	
	
	
	public int getQuantidadeGaragem() {
		return quantidadeGaragem;
	}
	public void setQuantidadeGaragem(int quantidadeGaragem) {
		this.quantidadeGaragem = quantidadeGaragem;
	}
	public int getQuantidadeQuarto() {
		return quantidadeQuarto;
	}
	public void setQuantidadeQuarto(int quantidadeQuarto) {
		this.quantidadeQuarto = quantidadeQuarto;
	}
	public int getQuantidadeBanheiro() {
		return quantidadeBanheiro;
	}
	public void setQuantidadeBanheiro(int quantidadeBanheiro) {
		this.quantidadeBanheiro = quantidadeBanheiro;
	}
	public int getQuantidadeSala() {
		return quantidadeSala;
	}
	public void setQuantidadeSala(int quantidadeSala) {
		this.quantidadeSala = quantidadeSala;
	}
	public int getQuantidadeQuintal() {
		return quantidadeQuintal;
	}
	public void setQuantidadeQuintal(int quantidadeQuintal) {
		this.quantidadeQuintal = quantidadeQuintal;
	}
	public int getQuantidadeCozinha() {
		return quantidadeCozinha;
	}
	public void setQuantidadeCozinha(int quantidadeCozinha) {
		this.quantidadeCozinha = quantidadeCozinha;
	}
	public int getQuantidadeSuit() {
		return quantidadeSuit;
	}
	public void setQuantidadeSuit(int quantidadeSuit) {
		this.quantidadeSuit = quantidadeSuit;
	}
	public int getQuantidadeComodos() {
		return quantidadeComodos;
	}
	public void setQuantidadeComodos(int quantidadeComodos) {
		this.quantidadeComodos = quantidadeComodos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}
	
	
	
	

}
