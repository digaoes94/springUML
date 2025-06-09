package UML.springUML;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import UML.springUML.domain.Categoria;
import UML.springUML.domain.Cidade;
import UML.springUML.domain.Cliente;
import UML.springUML.domain.Endereco;
import UML.springUML.domain.Estado;
import UML.springUML.domain.Produto;
import UML.springUML.domain.enums.TipoCliente;
import UML.springUML.repositories.CategoriaRepository;
import UML.springUML.repositories.CidadeRepository;
import UML.springUML.repositories.ClienteRepository;
import UML.springUML.repositories.EnderecoRepository;
import UML.springUML.repositories.EstadoRepository;
import UML.springUML.repositories.ProdutoRepository;

@SpringBootApplication
public class MainUML implements CommandLineRunner {
	@Autowired private CategoriaRepository catRepo;
	@Autowired private ProdutoRepository prodRepo;
	@Autowired private EstadoRepository estRepo;
	@Autowired private CidadeRepository cidRepo;
	@Autowired private ClienteRepository cliRepo;
	@Autowired private EnderecoRepository endRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MainUML.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria (null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		
		Estado est1 = new Estado(null, "Espírito Santo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade cid1 = new Cidade(null, "Vitória", est1);
		Cidade cid2 = new Cidade(null, "Vila Velha", est1);
		Cidade cid3 = new Cidade(null, "Belo Horizonte", est2);
		Cidade cid4 = new Cidade(null, "Campanha", est2);
		
		Cliente cli1 = new Cliente(null, "Rodrigo Araujo", "rodrigo@rodrigo", "11111111111", TipoCliente.CPF);
		cli1.getTelefones().add("012345678");
		Cliente cli2 = new Cliente(null, "Moqueca Games", "moqueca@games", "2222222222222222", TipoCliente.CPJ);
		cli2.getTelefones().add("000000000");
		
		Endereco end1 = new Endereco(null, "Avenida Selares", "123", "Casa C", "Bairro Sampoerna", "00000000", cid2, cli1);
		cli1.getEnderecos().add(end1);
		Endereco end2 = new Endereco(null, "Rua Anhangá", "1988", "Loja 903", "Bairro Ibirapuera", "00000000", cid3, cli2);
		cli2.getEnderecos().add(end2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().add(cat1);
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().add(cat1);
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3, cid4));
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3));
		estRepo.saveAll(Arrays.asList(est1, est2));
		cidRepo.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));
		cliRepo.saveAll(Arrays.asList(cli1, cli2));
		endRepo.saveAll(Arrays.asList(end1, end2));
	}
}