package com.educandoweb.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.repository.RepositorioDePedido;

@Service
public class ServicosDoPedido {
	
	@Autowired
	private RepositorioDePedido repositorioDePedido;
	
	public List<Pedido> listarTudo(){
		return repositorioDePedido.findAll();
	}
	
	public Pedido consultaId(Long id) {
		Optional<Pedido> obj = repositorioDePedido.findById(id);
		return obj.get();
	}

}
