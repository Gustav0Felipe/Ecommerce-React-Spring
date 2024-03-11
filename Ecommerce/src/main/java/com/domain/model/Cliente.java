package com.domain.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int cod_cli;
	
	@Column
	@NotBlank
	@Size(max = 255)
	private String nome_cli;
	
	@NotBlank
	@Size(max = 20)
	private String tel_cli;

	@Email 
	@NotBlank
	@Size(max = 255)
	private String email_cli;
	
	@Column
	@NotBlank
	public String cpf_cli;
	
	
	
	public int getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getNome_cli() {
		return nome_cli;
	}

	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}

	public String getTel_cli() {
		return tel_cli;
	}

	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	public String getCpf_cli() {
		return cpf_cli;
	}

	public void setCpf_cli(String cpf_cli) {
		this.cpf_cli = cpf_cli;
	}

	
/*	
	public Cliente(int id, String nome, String telefone, String email, String cpf) { //Antes recebia tambem senha.
		this.cod_cli = id;
		this.nome_cli = nome;
		this.tel_cli = telefone;
		this.email_cli = email;
		this.cpf_cli = cpf;
	}

	public Cliente() {
	}
*/
	
}
