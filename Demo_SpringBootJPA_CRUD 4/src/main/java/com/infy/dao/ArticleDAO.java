package com.infy.dao;


import com.infy.entity.Article;


public interface ArticleDAO {
	
	public Integer addArticle(Article article);
	
	public Article getArticle(Integer articleId) throws Exception;

}
