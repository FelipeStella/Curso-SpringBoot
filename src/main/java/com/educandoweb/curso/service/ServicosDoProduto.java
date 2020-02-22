package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.repository.RepositorioDeProduto;

@Service
public class ServicosDoProduto {
	
	@Autowired
	private RepositorioDeProduto repositorioDeProduto;
	
	public List<Produto> listarTudo(){
		return repositorioDeProduto.findAll();
	}
	
	public Produto consultaId(Long id) {
		Optional<Produto> obj = repositorioDeProduto.findById(id);
		return obj.get();
	}

}
