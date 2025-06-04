package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Produto;
import UML.springUML.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService catServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allProduto(@PathVariable Integer id) {
		Produto obj = catServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}