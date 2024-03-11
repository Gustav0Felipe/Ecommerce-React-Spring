package com.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.model.Produto;
import com.domain.repository.ProdutoRepository;

import jakarta.servlet.http.HttpServlet;


@RestController
@RequestMapping("/comprar")
public class ComprarController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("")
	public Produto buscarProduto(@RequestParam Integer id ) {
		Produto produto = new Produto();
		produto = produtoRepository.findById(id).orElse(null); 
		return produto;
	}
	
}
