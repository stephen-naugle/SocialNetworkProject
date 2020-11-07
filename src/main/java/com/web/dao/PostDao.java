package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Post;
import com.web.model.User;
import com.web.util.ProjectTwoUtil;


@Repository
@Transactional
public class PostDao implements DaoContract<Post, Integer>{

	
private SessionFactory sessfact;
	
	@Autowired
	public PostDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public PostDao() {
	}
	
	
	@Override
	public List<Post> findAll() {
		return sessfact.openSession().createQuery("from Post", Post.class).list();
	}

	@Override
	public Post findById(Integer i) {
		return sessfact.openSession().get(Post.class, i);
	}

	@Override
	public Post update(Post t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post save(Post t) {
		sessfact.openSession().save(t);
		return t;
	}

	@Override
	public Post delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
