package com.Gamesgen.LojaGames.Controller;

import java.util.List;

/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.Gamesgen.LojaGames.model.Produto;
import com.Gamesgen.LojaGames.repository.ProdutoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/produto")
public class ProdutoController {
private ProdutoRepository produtorepository;
/*@Autowired
public ResponseEntity<List<Produto>> GetByprodutorepository(@PathVariable String produtorepository) {
	return ResponseEntity.ok(produtorepository.findAllProdutoRepositoryContainingIgnoreCase());*/

@GetMapping("/{id}") 
public ResponseEntity<Produto> findByIdProduto(@PathVariable long id) {
return produtorepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}

@GetMapping("/titulo/{titulo}") 
public ResponseEntity<List<Produto>> findAllByTitulo(@PathVariable String titulo) {
	return ResponseEntity.ok(produtorepository.findAllBynomeContainingIgnoreCase(titulo));
}

@PostMapping 
public ResponseEntity<Produto> post(@RequestBody Produto produto) {
return ResponseEntity.status(HttpStatus.CREATED).body(produtorepository.save(produto));
}

@PutMapping 
public ResponseEntity<Produto> put(@RequestBody Produto produto) {
return ResponseEntity.status(HttpStatus.OK).body(produtorepository.save(produto));
}

@DeleteMapping("/{delete}")
public void deleteProduto(@PathVariable long id) {
produtorepository.deleteById(id);
}
}