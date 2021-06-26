package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*") /* aceitar requisições de qualquer origem */
public class PostagemController {
	@Autowired /* garantir que os serviços do postagem vai ser acessado pelo controle */
	private PostagemRepository repository;

	@GetMapping /* vai disparar o resto debaixo */
	public ResponseEntity<List<Postagem>> GetAll() { /* pega todos */
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}") /*
							 * para pegar o valor que entrar ,para pegar o caminho,meio q uma variavel do
							 * caminho,por ID
							 */
	public ResponseEntity<Postagem> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		/*
		 * Assim que for feito o acesso em id,vai ser acessado diretamento esse
		 * metodo,ele vai capturar a variavel que vai ser acessado dentro do
		 * patchvariavel,vai para o metodo debaixo que é um ok ou um não encontrado
		 */
	}

	/* Pelo tituto */
	@GetMapping("/titulo/{titulo}") /* depois de uma barra o ultimo dado na ia entender ,ia dar duplicidade. */
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}