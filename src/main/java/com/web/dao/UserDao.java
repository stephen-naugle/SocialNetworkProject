package com.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.controller.PostController;
import com.web.model.User;


@Repository
@Transactional
public class UserDao implements DaoContract<User, String> {

	private static Logger logger = Logger.getLogger(UserDao.class);
	
	private SessionFactory sessfact;
	
	public UserDao() {
	}

	@Autowired
	public void setSessfact(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	/**
	 * @returns a list of all users in the DB
	 */
	@Override
	public @ResponseBody List<User> findAll() {
		return sessfact.openSession().createQuery("from User", User.class).list();
	}

	/**
	 * @param an integer correlating to the user id
	 * @return user associated with the id
	 */
	@Override
	public User findById(String i) {
		return sessfact.openSession().createQuery("from User where username = '" + i + "'", User.class).uniqueResult();
	}

	/**
	 * @param user for which to delete
	 * @return the user that was deleted
	 */
	@Override
	public User update(User t) {
		sessfact.getCurrentSession().update(t);
		//Session sess = sessfact.openSession();
		//sess.update(t);
		//sessfact.flush();
		return t;
	}

	/**
	 * @param user to be added to the DB
	 * @return the deleted user
	 */
	@Override
	public User save(User t) {	
		sessfact.openSession().save(t);
		return t;
	}

	/**
	 * @param id of the user to be deleted
	 * @return the deleted user 
	 */
	@Override
	public User delete(User t) {
		sessfact.openSession().delete(t);
		return t;
	}
	
	public List<User> searchByUsername(String username){
		return sessfact.openSession().createQuery("from User where username like '%"+username+"%'", User.class).list();
	}
	
	public User findByEmail(String email) {
		return sessfact.openSession().createQuery("from User where email like '"+email+"'", User.class).uniqueResult();
	}
}