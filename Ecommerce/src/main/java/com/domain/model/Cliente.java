package com.domain.model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "clientes")
@Table
public class Cliente implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int cod_cli;
	
	@Column(name="nome_cli")
	@NotBlank
	@Size(max = 255)
	private String nome;
	
	@Column(name="tel_cli")
	@NotBlank
	@Size(max = 20)
	private String telefone;

	@Column(name="email_cli")
	@Email 
	@NotBlank
	@Size(max = 255)
	private String email;
	
	@Column(name="pass_cli")
	@NotBlank
	@Size(max = 100)
	private String password;
	
	@Column(name="cpf_cli")
	@NotBlank
	public String cpf;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	@Column
	private boolean enabled;

	@Column
	private String role;
	
	public Cliente() {
	
	}
	
	public Cliente(String nome, String email, String password, String role) {
        this.nome= nome;
        this.email = email;
        this.password = password;
        this.role = role;
    }

 

	public Cliente(String nome, String telefone,
			String email, String password,
			String cpf, String verification_code, boolean enabled) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.verificationCode = verification_code;
		this.enabled = enabled;
	}
	public Cliente(String nome, String telefone,
			 String email, String password,
			 String cpf, String role) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.role = role;
	}

	public Cliente(
			 String nome,
			 String telefone,
			 String email,
			 String cpf,
			 String role) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.role = role;
	}
	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
	}


	@Override
	public String getPassword() {
		return password;
	}


	@Override
	public String getUsername() {
		return email;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	
}
