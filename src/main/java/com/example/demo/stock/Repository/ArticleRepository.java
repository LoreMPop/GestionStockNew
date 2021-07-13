package com.example.demo.stock.Repository;

import com.example.demo.stock.Entites.Article;
import com.example.demo.stock.Entites.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
    Optional<Article> findById(Long idArticle);

}
