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
public long id;
@NotNull
@Size(min = 5, max = 20)
public String fornecedor;
@NotNull
@Size(min = 5, max = 20)
public String titulo;
@NotNull
public String nome;
@NotNull
public float Precoverda;
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
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public float getPrecoverda() {
	return Precoverda;
}
public void setPrecoverda(float precoverda) {
	Precoverda = precoverda;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}


}
