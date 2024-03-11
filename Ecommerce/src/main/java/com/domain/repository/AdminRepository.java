package com.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.domain.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	
	@Procedure
	public Boolean pd_is_admin(String usuario, String senha);
	
	@Procedure
	public void pd_cadastro_produto(String nome, String descricao, Double custo, Double valor , int estoque,int categoria,String img); 
}
