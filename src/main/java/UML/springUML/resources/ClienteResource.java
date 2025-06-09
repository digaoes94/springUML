package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Cliente;
import UML.springUML.services.ClienteService;

@RestController
@RequestMapping("/Clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService cliServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allCliente(@PathVariable Integer id) {
		Cliente obj = cliServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}