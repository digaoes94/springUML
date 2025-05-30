package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Categoria;
import UML.springUML.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository catRepo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = catRepo.findById(id);
		return obj.orElse(null);
	}
}
