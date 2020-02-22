package com.educandoweb.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Produto;

//Salva os dados do produto  no banco de dados//
public interface RepositorioDeProduto extends JpaRepository<Produto, Long> {

}
