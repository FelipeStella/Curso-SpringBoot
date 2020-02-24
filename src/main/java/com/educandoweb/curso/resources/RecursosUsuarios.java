package com.educandoweb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.service.ServicosDoUsuario;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursosUsuarios {
	
	@Autowired
	private ServicosDoUsuario servicosDoUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarTudo(){
		List<Usuario> list = servicosDoUsuario.listarTudo();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> consultaId(@PathVariable Long id){
		Usuario usuario = servicosDoUsuario.consultaId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario obj){
		obj = servicosDoUsuario.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
		servicosDoUsuario.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizarDadosDoUsuario(@PathVariable Long id, @RequestBody Usuario obj){
		obj = servicosDoUsuario.atualizar(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
