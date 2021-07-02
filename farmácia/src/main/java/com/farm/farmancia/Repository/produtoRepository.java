package com.farm.farmancia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.farmancia.model.Produto;
@Repository
public interface produtoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllBynomeContainingIgnoreCase(String nome);
	public List<Produto> findAllByfornecedorContainingIgnoreCase(String fornecedor);
}
