package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Produto;
import UML.springUML.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository catRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = catRepo.findById(id);
		return obj.orElse(null);
	}
}
