package com.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	
	
	List<Produto> findAll(); 
}
