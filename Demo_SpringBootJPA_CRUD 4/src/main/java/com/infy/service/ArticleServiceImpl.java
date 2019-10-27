package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infy.dao.ArticleDAO;
import com.infy.entity.Article;


@Service(value = "articleService")
@Transactional

public class ArticleServiceImpl  implements ArticleService {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Override
	public Article getArticle(Integer articleId) throws Exception {
		
		Article article = articleDAO.getArticle(articleId);

		if (article == null) {
			
			throw new Exception("Service.CUSTOMER_UNAVAILABLE");
		}

		return article;
	}


	@Override
	public Integer addArticle(Article article) throws Exception {
		
		if (articleDAO.getArticle(article.getId()) != null) {
			
			throw new Exception("Service.CUSTOMER_ALREADY_EXISTS");
		}

		return articleDAO.addArticle(article);
	}

	

	
	
	
	

}
