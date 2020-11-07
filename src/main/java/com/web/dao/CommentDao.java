package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.Comment;


@Repository
@Transactional
public class CommentDao implements DaoContract<Comment, Integer> {

private SessionFactory sessfact;
	
	@Autowired
	public CommentDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public CommentDao() {
	}
	
	@Override
	public List<Comment> findAll() {
		return sessfact.openSession().createQuery("from Comment", Comment.class).list();
	}

	@Override
	public Comment findById(Integer i) {
		return sessfact.openSession().get(Comment.class, i);
	}

	@Override
	public Comment update(Comment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment save(Comment t) {
		sessfact.openSession().save(t);
		return t;
	}

	@Override
	public Comment delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findByName(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

}
