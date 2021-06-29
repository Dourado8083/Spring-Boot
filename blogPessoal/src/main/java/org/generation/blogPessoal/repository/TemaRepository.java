package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository  extends JpaRepository<Tema, Long> {
public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao); /*para ignorar caixa alto e baixa,vai usar o atributo de descricao*/
}
