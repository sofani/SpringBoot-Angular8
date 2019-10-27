package com.infy.service;

import com.infy.entity.Article;


public interface ArticleService {
	
	public Integer addArticle(Article article) throws Exception;
	
	public Article getArticle(Integer articleId) throws Exception;

}
