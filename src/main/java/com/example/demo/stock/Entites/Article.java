package com.example.demo.stock.Entites;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "articles")

public class Article implements Serializable {
	private static final long serialVersionUID = 1704449652191403134L;
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(
			name="stock_sequence",
			sequenceName = "stock_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "stock_sequence"
	)
	private Long idArticle;

	@NotNull
	@Size(min = 2, max = 255)
	private String articleName;

	@Min(value = 0, message = "The price must be positive")
	private double articlePrice;


	@ManyToMany
 	private List<Warehouse> lesEntrepots;

	public Article(String articleNom, double articleprix, List<Warehouse> warehouses) {
		this.articleName=articleNom;
		this.articlePrice=articleprix;
		this.lesEntrepots=warehouses;
	}

	public Article(String articleName, double articlePrice) {
		this.articleName = articleName;
		this.articlePrice = articlePrice;
	}

	public Article() {
	}

	public String getName() {
		return this.articleName;
	}

	public Double getPrice() {
		return this.articlePrice;
	}

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public double getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(double articlePrice) {
		this.articlePrice = articlePrice;
	}

	public List<Warehouse> getLesEntrepots() {
		return lesEntrepots;
	}

	public void setLesEntrepots(List<Warehouse> lesEntrepots) {
		this.lesEntrepots = lesEntrepots;
	}
}