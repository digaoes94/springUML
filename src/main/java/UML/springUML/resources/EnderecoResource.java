package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Endereco;
import UML.springUML.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService endServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allEndereco(@PathVariable Integer id) {
		Endereco obj = endServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}