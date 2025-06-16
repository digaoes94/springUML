package UML.springUML.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UML.springUML.domain.Pedido;
import UML.springUML.repositories.PedidoRepository;
import UML.springUML.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedRepo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido de ID " + id + " não encontrada. Tipo: " + Pedido.class.getName()));
	}
}
