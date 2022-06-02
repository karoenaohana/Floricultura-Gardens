package br.com.atos.produto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "produto")
public class Produto {

	@ApiModelProperty(value = "ID do Produto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Codigo do Produto")
	@Column(name="codigo", nullable = false, unique = true)
	@NotBlank
	private String codigo;

	@ApiModelProperty(value = "Nome do Produto")
	@Column(name="nome", nullable = false)
	@NotBlank
	@Size(max = 50)
	private String nome;
	
	@ApiModelProperty(value = "Preço do Produto")
	@Column(name= "valor", nullable = false)
	@NotNull
	private Double preco;

	@ApiModelProperty(value = "Quantidade do Produto")
	@Column(name= "quantidade", nullable = false)
	@NotNull
	private Integer quantidade;

	
	@ApiModelProperty(value = "Categoria do Produto")
	@Column(name = "categoria", nullable = true)
	@Size(max = 50)
	private String categoria;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
