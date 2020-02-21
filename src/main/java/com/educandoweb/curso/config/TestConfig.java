package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.enuns.StatusDoPedido;
import com.educandoweb.curso.repository.RepositorioDePedido;
import com.educandoweb.curso.repository.RepositorioDeUsuario;

@Configuration
@Profile("test")                  //CommandLineRunner -> interface implementada para executar o método "run" na inicialização//
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;
	
	@Autowired
	private RepositorioDePedido repositorioDePedido;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusDoPedido.AGUARDANDO_PAGAMENTO,u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusDoPedido.ENVIADO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusDoPedido.CANCELADO, u1);
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioDePedido.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	
	

}
