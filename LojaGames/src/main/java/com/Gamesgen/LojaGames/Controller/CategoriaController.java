package com.Gamesgen.LojaGames.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.Gamesgen.LojaGames.model.Categoria;

import com.Gamesgen.LojaGames.repository.CategoriaRepository;
@CrossOrigin("*")
@RestController
public class CategoriaController {
	private CategoriaRepository categoryrepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria() {
		return ResponseEntity.ok(categoryrepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIdCategoria(@PathVariable long id) {
		return categoryrepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}") 
	public ResponseEntity<List<Categoria>> findAllByTitulo(@PathVariable String titulo) {
	return ResponseEntity.ok(categoryrepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	/*
	 * @GetMapping("/titulo/{titulo}") public ResponseEntity<List<Categoria>>
	 * findAllByTitulo(@PathVariable String categoria) { return
	 * ResponseEntity.ok(categoryrepository.findAllBycategoriaContainingIgnoreCase(
	 * categoria)); }
	 */

	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryrepository.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(categoryrepository.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		categoryrepository.deleteById(id);
	}
}
