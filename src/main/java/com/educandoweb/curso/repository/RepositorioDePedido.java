package com.educandoweb.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Pedido;

//Salva os dados do pedido  no banco de dados//
public interface RepositorioDePedido extends JpaRepository<Pedido, Long> {

}
