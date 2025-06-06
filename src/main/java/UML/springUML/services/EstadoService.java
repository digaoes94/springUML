package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Estado;
import UML.springUML.repositories.EstadoRepository;
import UML.springUML.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	@Autowired
	private EstadoRepository estRepo;
	
	public Estado find(Integer id) {
		Optional<Estado> obj = estRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Estado de ID " + id + " não encontrada. Tipo: " + Estado.class.getName()));
	}
}
