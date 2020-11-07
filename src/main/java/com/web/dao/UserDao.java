package com.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.web.model.User;
import com.web.util.ProjectTwoUtil;

public class UserDao implements DaoContract<User, String> {

	@Override
	public List<User> findAll() {
		List<User> list = ProjectTwoUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from user", User.class).list();
		return list;
	}

	@Override
	public User findById(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User t) {
		
		SessionFactory sesfact = ProjectTwoUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public User delete(String i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String firstname) {
		Session sess = ProjectTwoUtil.getSessionFactory().openSession();
		
		return sess.createQuery("from User where firstname = '"+firstname+"'", User.class).list().get(0);
	}

}
