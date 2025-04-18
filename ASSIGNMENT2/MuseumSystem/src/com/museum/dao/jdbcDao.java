package com.museum.dao;

import java.sql.SQLException;
import java.util.Collection;

public interface jdbcDao <T ,K>
{
	boolean save(T t) throws SQLException;
	Collection<T> findAll() throws SQLException;
	 T findById(K key) throws SQLException;

}
