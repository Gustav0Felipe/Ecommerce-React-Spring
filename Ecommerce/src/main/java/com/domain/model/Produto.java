package com.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "produtos")
public class Produto {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id_prod;
	
	@Column
	@NotBlank
	private String image;
	
	@Column
	@NotBlank
	@Size(max = 75)
	private String nome_prod;

	@Column
	@NotBlank
	@Size(max = 255)
	private String desc_prod;

	@Column
	@NotBlank
	private Double custo_prod;

	@Column
	@NotBlank
	private Double val_prod;

	@Column
	@NotBlank
	private int qtd_estq;


	@ManyToOne
	@JoinColumn(name = "cod_cat")
	private Categoria cod_cat;

	
	//quantidadePedido
	/*
	public Produtos(String nome, String desc, int qtd_estq, double custo,  double valor) {
		this.nome = nome;
		this.desc = desc;
		this.custo = custo;
		this.qtd_estq = qtd_estq;
		this.valor = valor;
	}
	
	public Produtos() {
	}
	*/
	
	public int getId_prod() {
		return id_prod;
	}

	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public String getDesc_prod() {
		return desc_prod;
	}

	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public Double getCusto_prod() {
		return custo_prod;
	}

	public void setCusto_prod(double custo_prod) {
		this.custo_prod = custo_prod;
	}

	public Double getVal_prod() {
		return val_prod;
	}

	public void setVal_prod(double val_prod) {
		this.val_prod = val_prod;
	}

	public int getQtd_estq() {
		return qtd_estq;
	}

	public void setQtd_estq(int qtd_estq) {
		this.qtd_estq = qtd_estq;
	}

	public Categoria getCod_cat() {
		return cod_cat;
	}

	public void setCod_cat(Categoria cod_cat) {
		this.cod_cat = cod_cat;
	}
	
}
