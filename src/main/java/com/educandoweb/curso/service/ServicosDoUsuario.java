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
	
	public Usuario inserir(Usuario usuario) {
		return repositorioDeUsuario.save(usuario);
	}
	
	public void deletar(Long id) {
		repositorioDeUsuario.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario obj) {
		Usuario entidade = repositorioDeUsuario.getOne(id);
		atualizarDados(entidade, obj);
		return repositorioDeUsuario.save(entidade);
	}
	
	public void atualizarDados(Usuario entidade, Usuario obj) {
		entidade.setNome(obj.getNome());
		entidade.setEmail(obj.getEmail());
		entidade.setTelefone(obj.getTelefone());
	}

}
