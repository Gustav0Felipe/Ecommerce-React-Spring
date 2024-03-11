package com.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.EmailSender.EmailSender;
import com.api.InputDto.ClienteDto;
import com.api.InputDto.LoginDto;
import com.api.Util.Utilitarios;
import com.domain.model.Cliente;
import com.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	public ClienteRepository clienteRepository;
	
	@Autowired
	EmailSender emailSender;

	public Cliente login(LoginDto credenciais) {
		return clienteRepository.pd_user_cliente(credenciais.email(), credenciais.senha());
	}
	
	public Boolean clienteJaCadastrado(String email, String cpf) {
		return clienteRepository.pd_user_cliente_alreadyExists(email, cpf);
	}
	
	
	public Cliente cadastrarCliente(ClienteDto cadastro) {
		int idCliente = clienteRepository.pd_cadastro_cliente(cadastro.nome(), cadastro.telefone(), cadastro.email(), cadastro.cpf());
		clienteRepository.pd_cadastro_cliente_sistema(idCliente, cadastro.email(), cadastro.senha());
		
		Cliente cliente = clienteRepository.pd_user_cliente(cadastro.email(), cadastro.senha());
		return cliente;
	}
	
	public Cliente atualizarCliente(ClienteDto cliente) {
		return clienteRepository.pd_atualiza_cliente(Integer.parseInt(cliente.idCliente()), cliente.nome(), cliente.telefone());
	}
	
	public String notificarCliente(LoginDto cliente) {
		Boolean senhaCorresponde = clienteRepository.pd_autorizar_alterar_senha(Integer.parseInt(cliente.idCliente()), cliente.senha());
		if(senhaCorresponde) {
			String token = Utilitarios.gerarStringAlphanumerica();
			emailSender.sendEmail(token, cliente.email());
			return token;
		}else {
			return null;
		}
	}


	public Cliente atualizarSenhaCliente(LoginDto dadosCliente) {
		try{
			return clienteRepository.pd_atualiza_senha_cliente(Integer.parseInt(dadosCliente.idCliente()), dadosCliente.senha());
		}catch(Exception e) {
			return null;
		}
	}

	public void deletarCliente(String idCliente) {
		clienteRepository.pd_deletar_cliente(Integer.parseInt(idCliente));	
	}
}
