package com.welitonmartins.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "PROMOCOES")
public class Promocao implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//nullable = false-> impade que insira valor null nessa coluna
	@NotBlank(message = "Um título é requirido")
	@Column(name ="TITULO", nullable = false)
	private String titulo;
	
	@NotBlank(message = "O link da promoção é requirido")
	@Column(name ="LINK_PROMOCAO", nullable = false)
	private String linkPromocao;
	
	@Column(name="SITE_PROMOCAO", nullable = false)
	private String site;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="LINK_IMAGEM", nullable= false)
	private String linkImagem;
	
	@NotNull(message = "O preço é requirido")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00") // informando para o banco que essa informçaõ é do tipo moeda
	@Column(name="PRECO_PROMOCAO", nullable = false)
	private BigDecimal preco;
	
	@Column(name = "TOTAL_LIKES")
	private int links;
	
	@Column(name= "DATA_CADASTRO", nullable = false)
	private LocalDateTime dtCadastro;
	
	@NotNull(message = "Uma categoria é requirida")
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_FK")// especificando o nome da chave estrageira que está fazendo esse relacionamento
	private Categoria categoria;

	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLinkPromocao() {
		return linkPromocao;
	}

	public void setLinkPromocao(String linkPromocao) {
		this.linkPromocao = linkPromocao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getLinks() {
		return links;
	}

	public void setLinks(int links) {
		this.links = links;
	}

	public LocalDateTime getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDateTime dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	@Override
	public String toString() {
		return "Promocao [id=" + id + ", titulo=" + titulo + ", linkPromocao=" + linkPromocao + ", site=" + site
				+ ", descricao=" + descricao + ", linkImagem=" + linkImagem + ", preco=" + preco + ", links=" + links
				+ ", dtCadastro=" + dtCadastro + ", categoria=" + categoria + "]";
	}
}
