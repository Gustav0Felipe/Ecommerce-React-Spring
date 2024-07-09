package com.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Produto findById(int id);
	
	@Query("select p from produtos p where p.nome_prod=:nomeProduto")
	Produto findByNome(@Param("nomeProduto")String nomeProduto);
	
	List<Produto> findAll(); 
	
	@Procedure
	public void pd_cadastro_produto(String nome, String descricao, Double custo, Double valor , int estoque,int categoria,String img); 
}
