package com.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.web.dao.UserDao;

public class Driver {

		public static void main(String[] args) {
			ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
			UserDao ud = ac.getBean(UserDao.class);
			
			//Then you can add things to the User table if you want
		}
}
