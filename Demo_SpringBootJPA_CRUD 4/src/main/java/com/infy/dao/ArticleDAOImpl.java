package com.infy.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.entity.Article;



@Repository(value = "articleDAO")
public class ArticleDAOImpl implements ArticleDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Integer addArticle(Article article) {
		
		Integer articleId = null;

		Article entity = new Article();
		
		entity.setTitle(article.getTitle());
		
		entity.setDate(LocalDate.now());
		
		entity.setBody(article.getBody());
		
		entity.setComments((article.getComments()));
		
		entity.setSummary(article.getSummary());
		
		entity.setUsername(article.getUsername());
		
		entity.setImage(article.getImage());
		
		entityManager.persist(entity);

		articleId = entity.getId();		

		return articleId;
		
	}

	@Override
	public Article getArticle(Integer articleId) throws Exception {
		
		Article article = null;

		Article articleEntity = entityManager.find(Article.class, articleId);
		
		if (articleEntity!=null) {
			
			article = new Article();
			
			article.setId(articleEntity.getId());
			article.setUsername(articleEntity.getUsername());
			article.setDate(articleEntity.getDate());
			article.setBody(articleEntity.getBody());
			article.setTitle(articleEntity.getTitle());	
			article.setSummary(articleEntity.getSummary());
			article.setComments(articleEntity.getComments());
		}

		return article;
		
	}


	

}
