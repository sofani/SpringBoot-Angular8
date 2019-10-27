package com.infy.api;


import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infy.entity.Article;


import com.infy.service.ArticleService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ArticleAPI {
	
	
	@Autowired
	private ArticleService articleService;
	

	
    @Autowired
	Environment environment;
    
    
//    @RequestMapping("/getImage/{id}")
//	public void getImage(HttpServletResponse response,@PathVariable("id") int id) throws Exception {
//	    response.setContentType("image/jpeg");
//	    Article article =articleService.getArticle(id);
//	    byte[] imageBytes = article.getImage();
//	    response.getOutputStream().write(imageBytes);
//	    response.getOutputStream().flush();
//	    //<img src="getImage/222" />
//	}
    
    
    //add
	
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ResponseEntity<String> addArticle(@ModelAttribute Article article, @RequestParam("file") MultipartFile file) throws Exception  {
	    	
	
    		//save image into database
    		InputStream inputStream = null;
    		OutputStream outputStream = null;
    		
    		//File file = new File("C:\\mavan-hibernate-image-mysql.gif");
    		
            byte[] bFile = new byte[(int) file.getSize()];
            
            try {
            	inputStream = file.getInputStream();
    	     //convert file into array of bytes
            	inputStream.read(bFile);
            	inputStream.close();
            	
            } catch (Exception e) {
            	
    	        e.printStackTrace();
            }
            
            
            article.setImage(bFile);
		
		
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
