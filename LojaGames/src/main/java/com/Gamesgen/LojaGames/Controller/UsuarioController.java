package com.Gamesgen.LojaGames.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gamesgen.LojaGames.model.Userlogin;
import com.Gamesgen.LojaGames.model.Usuario;
import com.Gamesgen.LojaGames.repository.UsuarioRepository;
import com.Gamesgen.LojaGames.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*") 
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService; 
	private UsuarioRepository usuariorepository;

	@PostMapping("/logar")
	public ResponseEntity<Userlogin> Autentication(@RequestBody Optional<Userlogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {

		return usuariorepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> encontrarPorNome(@PathVariable String nome) {

		return ResponseEntity.ok().body(usuariorepository.findAllByNomeContainingIgnoreCase(nome));
	}
}
