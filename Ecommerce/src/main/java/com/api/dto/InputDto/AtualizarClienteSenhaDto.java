package com.api.dto.InputDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarClienteSenhaDto(	
		
		@NotNull(message = "O Id não pode ser nulo.") 
		@NotBlank(message="O Id não pode estar vazio.") 
		String id,
			
		@NotNull(message = "O Nome não pode ser nulo.") 
		@NotBlank(message="O Nome não pode estar vazio.") 
		String nome,
		
		@NotNull(message = "O Email não pode ser nulo.") 
		@NotBlank(message="O Email não pode estar vazio.") 
		@Email
		String email,
		
		@NotNull(message = "A Senha não pode ser nulo.") 
		@NotBlank(message="A Senha não pode estar vazio.") 
		String senha
		) {

}
