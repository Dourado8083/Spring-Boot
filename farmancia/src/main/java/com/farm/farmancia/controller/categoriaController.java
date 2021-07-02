package com.farm.farmancia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.farm.farmancia.Repository.categoriaRepository;
import com.farm.farmancia.model.Categoria;



@RestController
@RequestMapping("/categoria")
public class categoriaController {
@Autowired
private categoriaRepository categoryrepository;
@GetMapping("/{id}") 
public ResponseEntity<Categoria> findByIdProduto(@PathVariable int cataid) {
return categoryrepository.findById(cataid).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}
@GetMapping("/descricao/{descricao}")/*
public ResponseEntity<List<Categoria>> GetByDescricao(@PathVariable String decricao) {
return ResponseEntity.ok(categoryrepository.findAllBydecricaoContainingIgnoreCase(decricao));
}*/


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
public void deleteProduto(@PathVariable int cataid) {
categoryrepository.deleteById(cataid);
}
}
