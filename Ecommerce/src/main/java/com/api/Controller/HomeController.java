package com.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Service.ProdutoService;
import com.domain.model.Produto;

@RestController
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	ProdutoService produtoService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<Produto> principalPage() {
		return produtoService.listarProdutos();
	}
}
