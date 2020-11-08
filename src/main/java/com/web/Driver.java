package com.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web.dao.CommentDao;
import com.web.dao.DaoContract;
import com.web.dao.UserDao;
import com.web.model.Comment;
import com.web.model.User;

public class Driver {
static User judy = new User(1, "judge", "judy", "judy@gmail.com", "judge", "judy", "1234567890", "judge", "lol im a judge", "123 judge town", null, null);
static Comment judysComment = new Comment(1, 1, "judge", "judge jusy in this bitch");	
public static void main(String[] args) {
			ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
			UserDao ud = ac.getBean(UserDao.class);
			CommentDao cd = ac.getBean(CommentDao.class);
			ud.save(judy);
			cd.save(judysComment);
			System.out.println(ud.findAll());
			System.out.println(cd.findAll());
			
		}
}
