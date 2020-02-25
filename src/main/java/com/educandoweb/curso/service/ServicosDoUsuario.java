package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.repository.RepositorioDeUsuario;
import com.educandoweb.curso.service.exception.DataIntegrityViolationException;
import com.educandoweb.curso.service.exception.ResourceNotFoundException;

@Service
public class ServicosDoUsuario {
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;
	
	public List<Usuario> listarTudo(){
		return repositorioDeUsuario.findAll();
	}
	
	public Usuario consultaId(Long id) {
		Optional<Usuario> obj = repositorioDeUsuario.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorioDeUsuario.save(usuario);
	}
	
	public void deletar(Long id) {
		try {
			repositorioDeUsuario.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(RuntimeException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
		
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		try{
			Usuario entidade = repositorioDeUsuario.getOne(id);
			atualizarDados(entidade, obj);
			return repositorioDeUsuario.save(entidade);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	public void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}

}
