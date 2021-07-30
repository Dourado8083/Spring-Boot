package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
 class UsuarioTest {
	public Usuario usuario;
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator(); //para pegar erros 

	@BeforeEach
	public void start() { 
     usuario = new Usuario("Gustavo", "Xmld");
	}

	@Test
	void testValidaAtributosNaoRetornaErro() {
		Set<ConstraintViolation<Usuario>> validacao =validator.validate(usuario);
		assertTrue(validacao.isEmpty());
	}

	@Test
	void testValidaAtributosRetornaErro() {
		Usuario usuarioErro = new Usuario();
		usuarioErro.setNome("Gustiz");
		Set<ConstraintViolation<Usuario>> validacao = validator.validate(usuarioErro);
		assertFalse(validacao.isEmpty());

	}
}
