package UML.springUML;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import UML.springUML.domain.Categoria;
import UML.springUML.domain.Cidade;
import UML.springUML.domain.Estado;
import UML.springUML.domain.Produto;
import UML.springUML.repositories.CategoriaRepository;
import UML.springUML.repositories.CidadeRepository;
import UML.springUML.repositories.EstadoRepository;
import UML.springUML.repositories.ProdutoRepository;

@SpringBootApplication
public class MainUML implements CommandLineRunner {
	@Autowired private CategoriaRepository catRepo;
	@Autowired private ProdutoRepository prodRepo;
	@Autowired private EstadoRepository estRepo;
	@Autowired private CidadeRepository cidRepo;
	
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
	}
}