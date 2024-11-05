package com.api.Service;

import java.util.Properties;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.api.Util.Utilitarios;
import com.api.dto.InputDto.AtualizarClienteSenhaDto;
import com.domain.model.Cliente;
import com.domain.model.Credenciamento;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	private Utilitarios ultilitario;
	
	private String verifyURL = "http://localhost:5173/loja";
	
	private final Properties props = new Properties();

	private Session session;  

	private String remetente;
	
	
	MailService(Utilitarios ultilitario) {  
		this.ultilitario = ultilitario;
		props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port","587");
        props.put("mail.smtp.host","smtp-mail.outlook.com");
        Credenciamento empresa = this.ultilitario.getEmpresa();
        
        remetente = empresa.getMail_username();
        
	    session = Session.getInstance(props, new Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(empresa.getMail_username(), empresa.getMail_password());
	        }
	    });
	}  
	
	public void sendPassChangeEmail(String token, AtualizarClienteSenhaDto cliente) {
		try {
			
	 	
		MimeMessage mimeMessage = new MimeMessage(session);
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		String htmlMsg = 
			("<h1>Aviso!: Tentaram alterar a senha de sua conta no site Ecommerce</h1>"
			+ "<p>Se for o dono da conta, [[NOME]] , e não for aquele que efetuou o pedido, entre em contato, caso tenha efetuado o pedido: </p>"
			+ "<a href='%s/perfil/editar-senha/auth=%s'>Para prosseguir e alterar sua senha clique aqui.<a>".formatted(verifyURL, token)
			).replace("[[NOME]]", cliente.nome());
		helper.setText(htmlMsg, true);
		helper.setFrom(remetente);
		helper.setTo(cliente.email());
		helper.setSubject("Aviso de tentativa de alteração de senha.");
		Transport.send(mimeMessage);
     	}catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
    }

	public void sendVerificationEmail(Cliente cliente) {
		try {
			MimeMessage mimeMessage = new MimeMessage(session);
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			String htmlMsg = 
				("<h1>Olá [[NOME]], aqui esta o link para confirmar seu cadastro: </h1>"
				+ String.format("<a href='%s/cadastro/verificar/auth=%s'>Clique Aqui</a>", verifyURL, cliente.getVerificationCode())
				).replace("[[NOME]]", cliente.getNome());
			
			helper.setText(htmlMsg, true);
			helper.setFrom(remetente);
			helper.setTo(cliente.getEmail());
			helper.setSubject("Confirmação de registro.");
			Transport.send(mimeMessage);
	     	}catch(Exception e) {
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
	     	}
		
	}

	public void sendReactivationEmail(Cliente cliente) {
		try {
			MimeMessage mimeMessage = new MimeMessage(session);
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

			String htmlMsg = 
				("<h1>Olá [[NOME]], tentaram reativar sua conta no site Ecommerce, se a tentativa foi feita por você acesse: </h1>"
				+ String.format("<a href='%s/cadastro/verificar/%s'>Clique Aqui</a>", verifyURL, cliente.getVerificationCode())
				).replace("[[NOME]]", cliente.getNome());
			
			helper.setText(htmlMsg, true);
			helper.setFrom(remetente);
			helper.setTo(cliente.getEmail());
			helper.setSubject("Confirmação de registro.");
			Transport.send(mimeMessage);
	     	}catch(Exception e) {
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
	     	}
	}
}
