package com.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.model.Comment;
import com.web.util.ProjectTwoUtil;

public class CommentDao implements DaoContract<Comment, Integer> {

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findById(Integer i) {
		Session sess = ProjectTwoUtil.getSessionFactory().openSession();
		Comment c = sess.get(Comment.class, i);
		return c;
	}

	@Override
	public Comment update(Comment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment save(Comment t) {
		Session sess = ProjectTwoUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.persist(t);
		tx.commit();
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
