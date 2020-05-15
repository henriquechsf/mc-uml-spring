package me.henriquesouza.mcuml;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.henriquesouza.mcuml.domain.Categoria;
import me.henriquesouza.mcuml.domain.Cidade;
import me.henriquesouza.mcuml.domain.Cliente;
import me.henriquesouza.mcuml.domain.Endereco;
import me.henriquesouza.mcuml.domain.Estado;
import me.henriquesouza.mcuml.domain.Produto;
import me.henriquesouza.mcuml.domain.enums.TipoCliente;
import me.henriquesouza.mcuml.repositories.CategoriaRepository;
import me.henriquesouza.mcuml.repositories.CidadeRepository;
import me.henriquesouza.mcuml.repositories.ClienteRepository;
import me.henriquesouza.mcuml.repositories.EnderecoRepository;
import me.henriquesouza.mcuml.repositories.EstadoRepository;
import me.henriquesouza.mcuml.repositories.ProdutoRepository;

@SpringBootApplication
public class McUmlApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(McUmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
				
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Paraná");
		Estado est2 = new Estado(null, "Mato Grosso");
		
		Cidade c1 = new Cidade(null, "Umuarama", est1);
		Cidade c2 = new Cidade(null, "Cuiabá", est2);
		Cidade c3 = new Cidade(null, "Pontes e Lacerda", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "98765432122", TipoCliente.PESSOAFISICA);
		// adiciona telefones ao cliente
		cli1.getTelefones().addAll(Arrays.asList("44999997777", "44988887766"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "78250000", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "87509000", cli1, c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
