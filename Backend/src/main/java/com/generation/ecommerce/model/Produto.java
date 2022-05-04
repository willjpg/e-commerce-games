package com.generation.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


	
	@Entity
	@Table(name = "tb_produto")
	public class Produto {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull(message = "O atributo nome é obrigatório!")
		@Size(max = 100, message = "O atributo nome tem no máximo de 100 caracteres")
		private String nome;
		
		@NotNull(message = "O atributo descrição é obrigatório!")
		@Size(min = 50,max = 1000, message = "O atributo descrição tem no mínimo 50 e máximo de 500 caracteres")
		private String descricao;
		
		@NotNull(message = "O atributo console é obrigatório!")
		@Size(max = 20, message = "O atributo console tem no máximo de 20 caracteres")
		private String console;
		
		@Column(name = "data_lancamento")
		@JsonFormat(pattern = "yyyy-MM-dd")
		
		private LocalDate dataLancamento;
		
		@PositiveOrZero
		private	int quantidade;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		@NotNull(message = "Preço é obrigatório!")
		@Positive
		private	BigDecimal preco;
		
		private String foto;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private Categoria categoria;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getDescricao() {
			return descricao;
		}


		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}


		public String getConsole() {
			return console;
		}


		public void setConsole(String console) {
			this.console = console;
		}


		public LocalDate getDataLancamento() {
			return dataLancamento;
		}


		public void setDataLancamento(LocalDate dataLancamento) {
			this.dataLancamento = dataLancamento;
		}


		public int getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}


		public BigDecimal getPreco() {
			return preco;
		}


		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}


		public String getFoto() {
			return foto;
		}


		public void setFoto(String foto) {
			this.foto = foto;
		} 
		
		
		public Categoria getCategoria() {
			return categoria;
		}


		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

}