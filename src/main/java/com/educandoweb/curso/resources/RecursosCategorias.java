package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Categoria;
import com.educandoweb.curso.service.ServicosDaCategoria;

@RestController
@RequestMapping(value = "/categorias")
public class RecursosCategorias {
	
	@Autowired
	private ServicosDaCategoria servicosDaCategoria;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listarTudo(){
		List<Categoria> list = servicosDaCategoria.listarTudo();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> consultaId(@PathVariable Long id){
		Categoria categoria = servicosDaCategoria.consultaId(id);
		return ResponseEntity.ok().body(categoria);
	}
	
}
