package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Categoria;
import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.enuns.StatusDoPedido;
import com.educandoweb.curso.repository.RepositorioDeCategoria;
import com.educandoweb.curso.repository.RepositorioDePedido;
import com.educandoweb.curso.repository.RepositorioDeProduto;
import com.educandoweb.curso.repository.RepositorioDeUsuario;

@Configuration
@Profile("test")                  //CommandLineRunner -> interface implementada para executar o método "run" na inicialização//
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private RepositorioDeUsuario repositorioDeUsuario;
	
	@Autowired
	private RepositorioDePedido repositorioDePedido;
	
	@Autowired
	private RepositorioDeCategoria repositorioDeCategoria;
	
	@Autowired
	private RepositorioDeProduto repositorioDeProduto;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
		
		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusDoPedido.AGUARDANDO_PAGAMENTO,u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusDoPedido.ENVIADO, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusDoPedido.CANCELADO, u1);
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioDePedido.saveAll(Arrays.asList(o1, o2, o3));
		repositorioDeCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositorioDeProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);
		
		repositorioDeProduto.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
	}
	
	
	

}
