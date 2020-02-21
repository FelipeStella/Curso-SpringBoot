package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.service.ServicosDoPedido;

@RestController
@RequestMapping(value = "/pedidos")
public class RecursosPedidos {

	@Autowired
	private ServicosDoPedido servicosDoPedido;

	@GetMapping
	public ResponseEntity<List<Pedido>> listarTudo() {
		List<Pedido> list = servicosDoPedido.listarTudo();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> consultaId(@PathVariable Long id) {
		Pedido pedido = servicosDoPedido.consultaId(id);
		return ResponseEntity.ok().body(pedido);
	}

}
