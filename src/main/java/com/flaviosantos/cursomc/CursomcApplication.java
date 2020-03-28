package com.flaviosantos.cursomc;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flaviosantos.cursomc.domain.Categoria;
import com.flaviosantos.cursomc.domain.Cidade;
import com.flaviosantos.cursomc.domain.Cliente;
import com.flaviosantos.cursomc.domain.Endereco;
import com.flaviosantos.cursomc.domain.Estado;
import com.flaviosantos.cursomc.domain.Produto;
import com.flaviosantos.cursomc.domain.enums.TipoCliente;
import com.flaviosantos.cursomc.repositories.CategoriaRepository;
import com.flaviosantos.cursomc.repositories.CidadeRepository;
import com.flaviosantos.cursomc.repositories.ClienteRepository;
import com.flaviosantos.cursomc.repositories.EnderecoRepository;
import com.flaviosantos.cursomc.repositories.EstadoRepository;
import com.flaviosantos.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "INFORMATICA");
		Categoria cat2 = new Categoria(null, "ESCRITORIO");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		repo.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "PE");
		Estado est2 = new Estado(null, "SP");
		
		Cidade c1 = new Cidade(null, "RECIFE", est1);
		Cidade c2 = new Cidade(null, "SAO PAULO", est2);
		Cidade c3 = new Cidade(null, "CAMPINAS", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Flavio Santos", "flaviosantos@gmail.com", "12345678909", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32145676", "32134356"));
		Endereco end1 = new Endereco(null, "RUA PITIGUARAS", "25", "", "CAMPO GRANDE", "51031-320", cli1, c1);
		Endereco end2 = new Endereco(null, "RUA BUTANTA", "2", "APTO 302", "PAULISTA", "51031-320", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		
	}

}
