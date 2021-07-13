package com.example.demo.stock.Service;

import com.example.demo.stock.Entites.Article;
import com.example.demo.stock.Repository.ArticleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArticleService
{

	private final ArticleRepository articleRepository;
	@Autowired
public  ArticleService(ArticleRepository articleRepository) {
		this.articleRepository=articleRepository;

	}
	public void addNewArticles(Article article) {
		Optional <Article> articleById= articleRepository.findById(article.getIdArticle());
		if (articleById.isPresent())
		{
			throw new IllegalStateException(("The article already exist"));

		}
		articleRepository.save(article);
	}

	public List<Article> getAllArticles() {
		return articleRepository.findAll();

	}

	public Article findArticleById(long articleId) {
		return articleRepository.findById(articleId).orElseThrow(() ->new IllegalStateException("Users with :"+articleId+ "does not exist"));
	}

	public void deleteArticle(Long articleId) {
		boolean exist= articleRepository.existsById(articleId);
		if (!exist){
			throw new IllegalStateException( "User with"+articleId+" does not exist");
		}
		else
			articleRepository.deleteById(articleId);
	}
	@Transactional
	public void updateArticleByName(Long id, String articleName) {
		Article article=articleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with :"+id+ "does not exist"));
		if (articleName !=null && articleName.length() >0 && !Objects.equals(article.getName(), articleName))
		{
			article.setArticleName(articleName);
		}
	}
	@Transactional
	public void updateArticleByPrice(Long articleId, Double articlePrice) {
		Article article=articleRepository.findById(articleId).orElseThrow(() -> new IllegalStateException("Student with :"+articleId+ "does not exist"));
		if (articlePrice !=null && !Objects.equals(article.getPrice(), articlePrice))
		{
			article.setArticlePrice(articlePrice);
		}
	}


}
