package com.museum.entity;

import java.time.LocalDate;
import java.util.Locale.Category;

public class Article 
{private Integer id;
private String name;
private Category category;
private LocalDate CreateDate;
private String  createName;


public Article()
{
	
}


public Article(Integer id, String name, Category category, LocalDate createDate, String createName) {
	super();
	this.id = id;
	this.name = name;
	this.category = category;
	CreateDate = createDate;
	this.createName = createName;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
}


public LocalDate getCreateDate() {
	return CreateDate;
}


public void setCreateDate(LocalDate createDate) {
	CreateDate = createDate;
}


@Override
public String toString() {
	return "Article [id=" + id + ", name=" + name + ", category=" + category + ", CreateDate=" + CreateDate
			+ ", createName=" + createName + "]";
}








}
