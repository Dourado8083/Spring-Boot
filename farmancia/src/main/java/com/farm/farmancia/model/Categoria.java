package com.farm.farmancia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*import javax.persistence.ManyToMany;*/
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cataid;
	private String decricao;
	@NotNull
	private String Tipo;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	/*public Categoria(int cataid, String decricao, @NotNull String tipo) {
		super();
		this.cataid = cataid;
		this.decricao = decricao;
		Tipo = tipo;
	}*/

	public int getCataid() {
		return cataid;
	}

	public void setCataid(int cataid) {
		this.cataid = cataid;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

}
