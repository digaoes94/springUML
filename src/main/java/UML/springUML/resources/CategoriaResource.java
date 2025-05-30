package UML.springUML.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UML.springUML.domain.Categoria;
import UML.springUML.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService catServ;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> allCategoria(@PathVariable Integer id) {
		Categoria obj = catServ.find(id);
		return ResponseEntity.ok().body(obj);
	}
}