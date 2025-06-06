package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Cidade;
import UML.springUML.services.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService cidServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allCidade(@PathVariable Integer id) {
		Cidade obj = cidServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}