package com.domain.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.domain.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Procedure
	public Cliente pd_user_cliente(String email, String senha);
	
	@Procedure
	public int pd_cadastro_cliente(String nome ,String telefone, String email, String cpf);
	
	@Procedure
	public void pd_cadastro_cliente_sistema(int cliente, String usuario, String senha);
	
	@Procedure
	public Boolean pd_user_cliente_alreadyExists(String usuario, String cpf);
	
	@Procedure
	public Cliente pd_atualiza_cliente(int idCliente, String nome, String telefone);
	
	@Procedure
	public Boolean pd_autorizar_alterar_senha(int idCliente, String senhaAtual);
	
	@Procedure
	public Cliente pd_atualiza_senha_cliente(int idCliente, String novaSenha);
	
	@Procedure
	public void pd_deletar_cliente(int idCliente);
}
