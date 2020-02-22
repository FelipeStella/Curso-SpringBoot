package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.service.ServicosDoProduto;

@RestController
@RequestMapping(value = "/produtos")
public class RecursosProdutos {
	
	@Autowired
	private ServicosDoProduto servicosDoProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarTudo(){
		List<Produto> list = servicosDoProduto.listarTudo();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> consultaId(@PathVariable Long id){
		Produto produto = servicosDoProduto.consultaId(id);
		return ResponseEntity.ok().body(produto);
	}
	
}
