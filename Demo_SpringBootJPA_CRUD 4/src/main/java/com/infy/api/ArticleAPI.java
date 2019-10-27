package com.infy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Article;
import com.infy.entity.CustomerEntity;
import com.infy.service.ArticleService;
import com.infy.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArticleAPI {
	
	
	@Autowired
	private ArticleService articleService;
	
    @Autowired
	Environment environment;
    
    
    //add
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseEntity<String> addArticle(@RequestBody Article article) throws Exception  {
	    	
		     articleService.addArticle(article);
			
			String successMessage = "Article added successfully";
			
			System.out.println(environment.getProperty("UserInterface.INSERT_SUCCESS") + article.getId());
			
			ResponseEntity<String> response = new ResponseEntity<String>(successMessage, HttpStatus.CREATED);
			
			
			
			return response;
		}
	 //retriev by id

	@RequestMapping(value = "/getArticleDetails/{articleId}", method = RequestMethod.GET)
	
	public ResponseEntity<Article> getArticleDetails(@PathVariable Integer articleId)  throws Exception  {
		
		Article article = articleService.getArticle(articleId);
		
		ResponseEntity<Article> response = new ResponseEntity<Article>(article, HttpStatus.OK);
		
		return response;
	}
	
	//retrieve all

}
