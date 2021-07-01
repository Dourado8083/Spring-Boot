package com.Gamesgen.LojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gamesgen.LojaGames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

public List<Produto> findAllBynomeContainingIgnoreCase(String nome);
public List<Produto> findAllByfornecedorContainingIgnoreCase(String fornecedor);

}
