package com.example.demo.stock.controllers;

import com.example.demo.stock.Entites.Article;

import com.example.demo.stock.Service.ArticleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	private final ArticleService articleService;
@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping()
	public List<Article> getAllArticles() {
		return articleService.getAllArticles();

	}
	@GetMapping("/articles/{id}")
	public Article getArticle( @PathVariable(value = "id") Long articleId) throws NotFoundException {
		return articleService.findArticleById(articleId);
	}

	@PutMapping("/addArticles")
	public void registerNewArticle( @RequestBody Article article) {
	articleService.addNewArticles(article);
	}

	@PutMapping("/articlesUpdateByName/{id}")
	public  void updateArticleByName(@PathVariable(value = "id") Long articleId,
												@RequestParam(required = false) String articleName)
	{
		articleService.updateArticleByName(articleId, articleName);

	}
	@PutMapping("/articlesUpdateByPrice/{id}")
	public void updateArticleByPrice(@PathVariable(value = "id") Long articleId,
														@RequestParam(required = false) Double articlePrice  )
	{
		articleService.updateArticleByPrice(articleId, articlePrice);

	}
	@DeleteMapping("/{id}")
	public void delArticle(@PathVariable(value = "id") Long articleId) {
		articleService.deleteArticle(articleId);
	}

}
