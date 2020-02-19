package com.educandoweb.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.entities.Usuario;

//Salva os dados do usuário  no banco de dados//
public interface RepositorioDeUsuario extends JpaRepository<Usuario, Long> {

}
