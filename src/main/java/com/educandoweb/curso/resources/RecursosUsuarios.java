package com.educandoweb.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuarios {
	
	@GetMapping
	public ResponseEntity<Usuario> consulta(){
		Usuario u = new Usuario(1L, "Felipe", "felipe@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
