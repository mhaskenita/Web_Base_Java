package com.museum.service;

public class ResourceAlreadyExistException extends RuntimeException 
{
public ResourceAlreadyExistException(String msg)
{
	super(msg);
}
}
