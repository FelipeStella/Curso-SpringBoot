package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.repository.RepositorioDeUsuario;

@Service
public class ServicosDoUsuario {
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;
	
	public List<Usuario> listarTudo(){
		return repositorioDeUsuario.findAll();
	}
	
	public Usuario consultaId(Long id) {
		Optional<Usuario> obj = repositorioDeUsuario.findById(id);
		return obj.get();
	}

}
