package com.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.web.model.Post;
import com.web.util.ProjectTwoUtil;

public class PostDao implements DaoContract<Post, Integer>{

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = ProjectTwoUtil.getSessionFactory().openSession();
		Post p = sess.get(Post.class, i);
		return p;
	}

	@Override
	public Post update(Post t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post save(Post t) {
		Session sess = ProjectTwoUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.persist(t);
		tx.commit();
		return null;
	}

	@Override
	public Post delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findByName(String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

}
