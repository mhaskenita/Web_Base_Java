package com.museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale.Category;
import java.util.Optional;

import com.museum.dao.ArticleDao;
import com.museum.entity.Article;

public class ArticleService 

{
	private ArticleDao articleDao;

	public ArticleService() throws SQLException{
		articleDao=new ArticleDao();
		
		
		
		// TODO Auto-generated constructor stub
	}
	public void addArticle(String name,Category category,LocalDate createdDate,String creatorName)
	throws SQLException
	
	
	{ Optional<Article> existingArticle=articleDao.findAll().stream().filter(article ->article.getName().equalsIgnoreCase(name))
			.findFirst();
	
	if(existingArticle.isEmpty())
	{
		Article newArticle=new Article(null,name,category,createdDate,creatorName);
		boolean status=articleDao.save(newArticle);
		
		if(status)
			System.out.println("Article added successfully!!");
		else
			System.out.println("Article failed to add !!");
		
		
	}
	else
	{
		throw new ResourceAlreadyExistException("Article already exist with same name"+name);
	}
		
	}
	public void displaygetAllArticles() throws SQLException
	{
		articleDao.findAll().stream().forEach(article -> System.out.println(article));
		
	}
	public  void displayArticleDetails(Integer id)throws SQLException, ResourceNotFoundException
	{
		Article foundarticle=articleDao.findById(id);
		if(foundarticle !=null)
		{
			System.out.println(foundarticle);
		}
		else
			throw new ResourceNotFoundException("article not found of id :"+id);
		
	}
	
		
		
	}


