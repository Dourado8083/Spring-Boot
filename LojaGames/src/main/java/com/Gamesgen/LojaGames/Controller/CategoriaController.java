package com.Gamesgen.LojaGames.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
/*import org.springframework.web.bind.annotation.GetMapping; */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.Gamesgen.LojaGames.model.Categoria;
import com.Gamesgen.LojaGames.repository.CategoriaRepository;
import java.util.List;
@RestController

public class CategoriaController {
private CategoriaRepository categoryrepository;
	@RequestMapping("/{id}") 
	public ResponseEntity<Categoria> findByIdProduto(@PathVariable long id) {
	return categoryrepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	/*@GetMapping("/titulo/{titulo}") 
	public ResponseEntity<List<Categoria>> findAllByTitulo(@PathVariable String categoria) {
		return ResponseEntity.ok(categoryrepository.findAllBycategoriaContainingIgnoreCase(categoria));
	} */

	@PostMapping 
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
	return ResponseEntity.status(HttpStatus.CREATED).body(categoryrepository.save(categoria));
	}

	@PutMapping 
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
	return ResponseEntity.status(HttpStatus.OK).body(categoryrepository.save(categoria));
	}

	@DeleteMapping("/{delete}")
	public void deleteProduto(@PathVariable long id) {
	categoryrepository.deleteById(id);
	}
	}

