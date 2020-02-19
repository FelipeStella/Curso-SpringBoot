package com.educandoweb.curso.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.repository.RepositorioDeUsuario;

@Configuration
@Profile("test")                  //CommandLineRunner -> interface implementada para executar o método "run" na inicialização//
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1, u2));
		
	}
	
	
	

}
