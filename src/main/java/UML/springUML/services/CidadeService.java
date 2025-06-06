package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Cidade;
import UML.springUML.repositories.CidadeRepository;
import UML.springUML.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository cidRepo;
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = cidRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cidade de ID " + id + " não encontrada. Tipo: " + Cidade.class.getName()));
	}
}
