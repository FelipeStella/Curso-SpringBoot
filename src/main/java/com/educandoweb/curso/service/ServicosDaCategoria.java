package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Categoria;
import com.educandoweb.curso.repository.RepositorioDeCategoria;

@Service
public class ServicosDaCategoria {
	
	@Autowired
	private RepositorioDeCategoria repositorioDeCategoria;
	
	public List<Categoria> listarTudo(){
		return repositorioDeCategoria.findAll();
	}
	
	public Categoria consultaId(Long id) {
		Optional<Categoria> obj = repositorioDeCategoria.findById(id);
		return obj.get();
	}

}
