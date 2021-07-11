package com.Gamesgen.LojaGames.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gamesgen.LojaGames.model.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

	public List<Categoria> findAllByTituloContainingIgnoreCase(String titulo);
}
