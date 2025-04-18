package com.museum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale.Category;

import com.museum.entity.Article;
import com.museum.utils.jdbcUtils;

public class ArticleDao implements jdbcDao<Article,Integer>
{

	private Connection con;
	private String query;
	private PreparedStatement pstm;
	private Statement stm;
	public  ArticleDao ()throws SQLException
	{
		con=jdbcUtils.getDbConnection();
	}
	public boolean save(Article articles) throws SQLException
	
	{query="insert into article values(?,?,?,?,?);";
		pstm=con.prepareStatement(query);
		pstm.setInt(1, 0);
		pstm.setString(2,articles.getName());
		pstm.setString(3, articles.getCategory().toString());
		pstm.setDate(4,Date.valueOf(articles.getCreateDate()));
		pstm.setString(5,articles.getName());
		int count=pstm.executeUpdate();
		if(count>0)
		{
			System.out.println(count +"row inserted !!");
			return true;
		}
		else
		
		return false;
	}

	@Override
	public Collection<Article> findAll() throws SQLException
	{
		List<Article>articles=new ArrayList<Article>();
		query="select *  from article ;";
		stm=con.createStatement();
		ResultSet rs=stm.executeQuery(query);
		
		while(rs.next())
		{
			Article article=new Article(rs.getInt("id"), 
					rs.getString("name"),Category.valueOf(rs.getString("Category")), 
					rs.getDate("date_Created").toLocalDate(),
					rs.getString("create_name"));
			articles.add(article);
		}
		
		return articles;
	}

	@Override
	public Article findById(Integer key) throws SQLException 
	{
	Article foundarticle=null;
	query="select * from article where id=?";
	pstm=con.prepareStatement(query);
	
	pstm.setInt(1, key);
	ResultSet rs=pstm.executeQuery();
	
	while(rs.next())
	{
		int id=rs.getInt("id");
		String name=rs.getString("name");
		Category category=Category.valueOf(rs.getString("Category"));
		LocalDate date=rs.getDate("date_Created").toLocalDate();
		
		String CategoryName=rs.getString("create_name");
        foundarticle=new Article(id, CategoryName, category, date, name);
	}
		
		return foundarticle;
	}
	
}



