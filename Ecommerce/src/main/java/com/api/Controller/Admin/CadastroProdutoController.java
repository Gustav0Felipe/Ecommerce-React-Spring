package com.api.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.AdminService;
import com.api.dto.InputDto.ProdutoDto;

@RequestMapping("/admin")
@RestController
public class CadastroProdutoController {
	
	@Autowired
	AdminService adminService;

	
	@CrossOrigin(origins="*", allowedHeaders="*")
	@PostMapping("/cadastrar-produto")
	public HttpStatus cadastrarProduto(@RequestBody ProdutoDto produto) {
		adminService.cadastrarProduto(produto);
		
		return HttpStatus.OK;
	}
	
	
}
