package com.web.dao;

import java.util.List;

import com.web.model.Comment;



public interface DaoContract <T, I>{
	
	List<T> findAll();
	T findById(I i);
	T update(T t);
	T save(T t);
	T delete(T t);

}
