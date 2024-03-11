package com.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "admin_sistema_loja")
public class Admin {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	Integer cod_admin;
	
	@Email
	@NotBlank
	@Size(max = 50)
	String user_admin;
	
	@NotBlank
	@Size(max = 30)
	String senha_admin;
}
