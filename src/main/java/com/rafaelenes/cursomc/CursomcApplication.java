package com.rafaelenes.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafaelenes.cursomc.domain.Categoria;
import com.rafaelenes.cursomc.domain.Cidade;
import com.rafaelenes.cursomc.domain.Cliente;
import com.rafaelenes.cursomc.domain.Endereco;
import com.rafaelenes.cursomc.domain.Estado;
import com.rafaelenes.cursomc.domain.Produto;
import com.rafaelenes.cursomc.domain.enums.TipoCliente;
import com.rafaelenes.cursomc.repositories.CategoriaRepository;
import com.rafaelenes.cursomc.repositories.CidadeRepository;
import com.rafaelenes.cursomc.repositories.ClienteRepository;
import com.rafaelenes.cursomc.repositories.EnderecoRepository;
import com.rafaelenes.cursomc.repositories.EstadoRepository;
import com.rafaelenes.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1 , p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Assis", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "45351581850", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Rafael Enes", "rafaelenes@gmail.com", "04662579000109", TipoCliente.PESSOAJURIDICA);
		
		cli1.getTelefones().addAll(Arrays.asList("18998083461", "18997297623"));
		cli2.getTelefones().addAll(Arrays.asList("18997992221", "1833248582"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto 303", "Jardim", "1980000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenidia Matos", "105", "Sala 800", "Centro", "1234567", cli1, c2);
		Endereco e3 = new Endereco(null, "Rua João Pessoa", "67", "Casa", "Centro", "19806000", cli2, c4);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2, e3));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
	}

}
