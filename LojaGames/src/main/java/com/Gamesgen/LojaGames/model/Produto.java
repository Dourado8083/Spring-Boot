package com.Gamesgen.LojaGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity	
public class Produto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotNull
@Size(min = 5, max = 20)
private String fornecedor;
@NotNull
private String Nome;
@NotNull
private float Precoverda;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFornecedor() {
	return fornecedor;
}
public void setFornecedor(String fornecedor) {
	this.fornecedor = fornecedor;
}
public String getNome() {
	return Nome;
}
public void setNome(String nome) {
	Nome = nome;
}
public float getPrecovenda() {
	return Precoverda;
}
public void setPrecoverda(float precoverda) {
	Precoverda = precoverda;
}

}
