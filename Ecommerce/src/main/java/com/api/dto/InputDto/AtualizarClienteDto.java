package com.api.dto.InputDto;

import com.domain.model.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarClienteDto(	
		
	@NotNull(message = "O Id não pode ser nulo.") 
	@NotBlank(message="O Id não pode estar vazio.") 
	String id,
		
	@NotNull(message = "O Nome não pode ser nulo.") 
	@NotBlank(message="O Nome não pode estar vazio.") 
	String nome, 
	
	@NotNull(message = "O Telefone não pode ser nulo.") 
	@NotBlank(message="O Telefone não pode estar vazio.") 
	String telefone,
	
	@NotNull(message = "O Email não pode ser nulo.") 
	@NotBlank(message="O Email não pode estar vazio.") 
	@Email
	String email,
	
	@NotNull(message = "O Cpf não pode ser nulo.") 
	@NotBlank(message="O Cpf não pode estar vazio.") 
	String cpf,
	
	String role,
	
	String token
	) {
	
	public Cliente toModel() {
	return new Cliente(nome, telefone, email, cpf, role);
	}

}
