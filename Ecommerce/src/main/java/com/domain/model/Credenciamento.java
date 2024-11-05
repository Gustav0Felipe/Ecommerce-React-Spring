package com.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="credenciamento_empresa")
@Entity
public class Credenciamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id_empresa;
	
	@Column
	@NotBlank
	private String client_id;
	
	@Column
	@NotBlank
	private String client_secret;
	
	@Column
	@NotBlank
	private String jwt_secret ;
	
	@Column
	@NotBlank
	private String mail_password;
	
	@Column
	@NotBlank
	private String mail_username;
	
	@Column
	@NotBlank
	private String cert_name;
	
}
