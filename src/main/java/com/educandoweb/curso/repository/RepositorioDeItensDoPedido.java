package com.educandoweb.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.ItemDoPedido;

//Salva os dados do usuário  no banco de dados//
public interface RepositorioDeItensDoPedido extends JpaRepository<ItemDoPedido, Long> {

}
