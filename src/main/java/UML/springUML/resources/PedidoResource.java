package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Pedido;
import UML.springUML.services.PedidoService;

@RestController
@RequestMapping("/Pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allPedido(@PathVariable Integer id) {
		Pedido obj = pedServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}