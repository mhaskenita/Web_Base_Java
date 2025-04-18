package com.museum1;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Locale.Category;
import java.util.Scanner;

import com.museum.service.ArticleService;

import com.museum.service.ResourceNotFoundException;

public class ArticleMain 
{
	

	public static void main(String[] args) throws SQLException
	
	{
		Scanner sc=new Scanner(System.in);
		ArticleService service=null;
		try {
			 service= new ArticleService();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	boolean exit=true;
	while(exit)
	{
		System.out.println("=====menu===="+"\n1.add Article."+"\n2.Display all Articles."
	+"\n3. Display Details of Article."+
	   "\n0.exit");
		
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:{
			try {System.out.println("enter article name,category(PAINTING, SCULPTURE, ARTIFACT),created date,creator name");
			
			String name=sc.next();
			Category category=Category.valueOf(sc.next());
			LocalDate date=LocalDate.parse(sc.next());
			String creatorName=sc.next();
			service.addArticle(name, category, date, creatorName);
			
			
			
			} catch (Exception e ) 
			{
				e.printStackTrace();
				
			}
			
			break;
		}	
		case 2:{
			try {
				service.displaygetAllArticles();
				
			} catch (Exception e)
			{
				e.printStackTrace();
				
			}
			
			break;
		}
		
		case 3:{
			try {
				System.out.println("enter article id ");
				service.displayArticleDetails(sc.nextInt());
				
			} catch ( ResourceNotFoundException r) 
			{
				
				r.printStackTrace();
			}
		
			
			break;
		}
		case 0:{
			exit=false;
			System.out.println("Thank you  !!"); 
			
			break;
		}
			
		}
		
	}
		

	}

}
