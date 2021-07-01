package com.Gamesgen.LojaGames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


	@Entity
	public class Categoria {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String descricao;
		@NotNull
		private String Tipo;
		@Size(min = 10, max = 100)
		private String titulo;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getTipo() {
			return Tipo;
		}
		public void setTipo(String tipo) {
			Tipo = tipo;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
	}

