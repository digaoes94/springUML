package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Cliente;
import UML.springUML.repositories.ClienteRepository;
import UML.springUML.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository cliRepo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = cliRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente de ID " + id + " não encontrada. Tipo: " + Cliente.class.getName()));
	}
}
