package com.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.Util.Utilitarios;
import com.api.dto.InputDto.AtualizarClienteDto;
import com.api.dto.InputDto.AtualizarClienteSenhaDto;
import com.api.dto.OutputDto.DadosClienteDto;
import com.domain.model.Cliente;
import com.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	public ClienteRepository clienteRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	MailService mailService;

	public Boolean clienteJaCadastrado(String email, String cpf) {
		return clienteRepository.pd_user_cliente_alreadyExists(email, cpf);
	}
	
	public Boolean clienteExisteDesabilitado(String email) {

		Boolean clienteDesativado = clienteRepository.pd_user_cliente_inactive(email);

		System.out.println("Tentando Reativar Cliente..." + clienteDesativado);
		if(clienteDesativado) {
			reativarCliente(email);
			return true;
		};
		return false;
	}
	
	public void reativarCliente(String email) {
		Cliente cliente = (Cliente) clienteRepository.findByEmail(email);
		System.out.println("Enviando notif, Code: " + cliente.getVerificationCode());
		mailService.sendReactivationEmail(cliente);
	}

	public DadosClienteDto cadastrarCliente(Cliente cliente) {
		
		Boolean clientExist = clienteJaCadastrado(cliente.getEmail(), cliente.getCpf());
		if(clientExist){
			throw new RuntimeException("Esse email já existe.");
		} else {
			String encodedPassword = passwordEncoder.encode(cliente.getPassword());
			cliente.setPassword(encodedPassword);
			
			String randomCode = Utilitarios.gerarStringAlphanumerica(64);
			
			cliente.setVerificationCode(randomCode);
			cliente.setEnabled(false);
			cliente.setRole("USER");
			Cliente clienteSalvo = clienteRepository.save(cliente);
			
			DadosClienteDto saidaCliente = new DadosClienteDto(
					//TODO aqui seria cliente salvo não?
					cliente.getCod_cli(),
					cliente.getNome(),
					cliente.getEmail(),
					cliente.getPassword(),
					cliente.getTelefone(),
					cliente.getCpf(),
					null,
					cliente.getRole(),
					null
					);
			mailService.sendVerificationEmail(clienteSalvo);
			
			return saidaCliente;
		}
	}
	
	public boolean verify(String code) {
		Cliente cliente = clienteRepository.findByVerificationCode(code);
		
		if(cliente == null || cliente.isEnabled()) {
			return false;
		} else {
			cliente.setVerificationCode(null);
			cliente.setEnabled(true);
			clienteRepository.save(cliente);
			
			return true;
		}
	}
	
	
	public Cliente atualizarCliente(AtualizarClienteDto cliente) {
		return clienteRepository.pd_atualiza_cliente(Integer.parseInt(cliente.id()), cliente.nome(), cliente.telefone());
	}
	
	public String notificarCliente(AtualizarClienteSenhaDto cliente) {
		String senhaDatabase = clienteRepository.pd_autorizar_alterar_senha(Integer.parseInt(cliente.id()), cliente.senha());
		if(passwordEncoder.matches(cliente.senha(), senhaDatabase)) {
			String token = Utilitarios.gerarStringAlphanumerica(64);
			mailService.sendPassChangeEmail(token, cliente);
			return token;
		}else {
			return null;
		}
	}

	public Cliente atualizarSenhaCliente(AtualizarClienteSenhaDto dadosCliente) {
		try{
			String encodedPassword = passwordEncoder.encode(dadosCliente.senha());
			return clienteRepository.pd_atualiza_senha_cliente(Integer.parseInt(dadosCliente.id()), encodedPassword);
		}catch(Exception e) {
			return null;
		}
	}

	public void deletarCliente(String idCliente) {
		String verificationCode = Utilitarios.gerarStringAlphanumerica(64);
		clienteRepository.pd_deletar_cliente(Integer.parseInt(idCliente), verificationCode);	
	}
}
