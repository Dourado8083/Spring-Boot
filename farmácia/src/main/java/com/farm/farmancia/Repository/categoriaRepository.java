package com.farm.farmancia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.farmancia.model.Categoria;
@Repository
public interface categoriaRepository extends JpaRepository<Categoria, Integer> { /*chave primaria */
	public List<Categoria>findAllByTipoContainingIgnoreCase(String Tipo);
}
