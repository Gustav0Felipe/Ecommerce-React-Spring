package com.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "produtos")
public class Produto {

	@Id
	@Column(name="id_prod")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id_prod;
	
	
	@Column
	@NotBlank
	@Size(max = 75)
	private String nome_prod;

	@Column
	@NotBlank
	@Size(max = 255)
	private String desc_prod;

	@Column(name="custo_prod")
	@NotNull
	private Double custo_prod;

	@Column(name="val_prod")
	@NotNull
	private Double val_prod;

	@Column
	@NotNull
	private int qtd_estq;
	
	@ManyToOne
	@JoinColumn(name = "cod_cat")
	private Categoria cod_cat;
	
	@Column
	@NotBlank
	private String image;
	
	

}
