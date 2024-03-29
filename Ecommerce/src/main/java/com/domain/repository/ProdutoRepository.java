package com.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Produto findById(int id);
	
	List<Produto> findAll(); 
	
	@Procedure
	public void pd_cadastro_produto(String nome, String descricao, Double custo, Double valor , int estoque,int categoria,String img); 
}
