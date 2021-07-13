package com.Gamesgen.LojaGames.services;
import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Gamesgen.LojaGames.model.Userlogin;
import com.Gamesgen.LojaGames.model.Usuario;
import com.Gamesgen.LojaGames.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}

	public Optional<Userlogin> Logar(Optional<Userlogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getnome());
		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
//ele pega 2 senha e verifica se é igual se for ele retorna verdadeiro
				String auth = user.get().getnome() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
//vai pegar um e code com base64,ai escolhe qual formato de bite você quer 
				String authHeader = "Basic " + new String(encodedAuth);
				user.get().setToken(authHeader);
				user.get().setNickname(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());
				return user;
			}
		}
		return null;
	}
}
