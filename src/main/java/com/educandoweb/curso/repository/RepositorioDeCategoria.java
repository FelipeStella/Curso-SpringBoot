package com.educandoweb.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Categoria;

//Salva os dados da categoria no banco de dados//
public interface RepositorioDeCategoria extends JpaRepository<Categoria, Long> {

}
