package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.model.User;
import com.web.util.ProjectTwoUtil;

@Repository
@Transactional
public class UserDao implements DaoContract<User, String> {

	private SessionFactory sessfact;
	
	@Autowired
	public UserDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public UserDao() {
	}

	@Override
	public List<User> findAll() {
		return sessfact.openSession().createQuery("from User", User.class).list();
	}

	@Override
	public User findById(String i) {
		return sessfact.openSession().get(User.class, i);
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User t) {	
		sessfact.openSession().save(t);
		return t;
	}

	@Override
	public User delete(String i) {
		// TODO Auto-generated method stub
		return null;
	}
}