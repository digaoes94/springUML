package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Estado;
import UML.springUML.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService estServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allEstado(@PathVariable Integer id) {
		Estado obj = estServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}