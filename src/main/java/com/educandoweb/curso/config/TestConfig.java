package com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.entities.Categoria;
import com.educandoweb.curso.entities.ItemDoPedido;
import com.educandoweb.curso.entities.Pagamento;
import com.educandoweb.curso.entities.Pedido;
import com.educandoweb.curso.entities.Produto;
import com.educandoweb.curso.entities.Usuario;
import com.educandoweb.curso.enuns.StatusDoPedido;
import com.educandoweb.curso.repository.RepositorioDeCategoria;
import com.educandoweb.curso.repository.RepositorioDeItensDoPedido;
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
	
	@Autowired
	private RepositorioDeItensDoPedido repositorioDeItensDoPedido;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");	
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusDoPedido.PAGO,u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusDoPedido.ENVIADO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusDoPedido.CANCELADO, u1);
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		Produto pro1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pro2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pro3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pro4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pro5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1, u2));
		repositorioDePedido.saveAll(Arrays.asList(p1, p2, p3));
		repositorioDeCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
		repositorioDeProduto.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));
		
		pro1.getCategorias().add(cat2);
		pro2.getCategorias().add(cat1);
		pro2.getCategorias().add(cat3);
		pro3.getCategorias().add(cat3);
		pro4.getCategorias().add(cat3);
		pro5.getCategorias().add(cat2);
		
		repositorioDeProduto.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5));
		
		ItemDoPedido ip1 = new ItemDoPedido(p1, pro1, 2, pro1.getPreco());
		ItemDoPedido ip2 = new ItemDoPedido(p1, pro3, 1, pro3.getPreco());
		ItemDoPedido ip3 = new ItemDoPedido(p2, pro3, 2, pro3.getPreco());
		ItemDoPedido ip4 = new ItemDoPedido(p3, pro5, 2, pro5.getPreco());
		
		repositorioDeItensDoPedido.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));
		
		Pagamento pag1 = new Pagamento(Instant.parse("2019-06-20T21:53:07Z"), p1);
		p1.setPagamento(pag1);
		
		repositorioDePedido.save(p1);
		
	}
	
	
	

}
