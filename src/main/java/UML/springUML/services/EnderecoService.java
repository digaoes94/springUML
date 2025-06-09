package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Endereco;
import UML.springUML.repositories.EnderecoRepository;
import UML.springUML.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository endRepo;
	
	public Endereco find(Integer id) {
		Optional<Endereco> obj = endRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Endereco de ID " + id + " não encontrada. Tipo: " + Endereco.class.getName()));
	}
}
