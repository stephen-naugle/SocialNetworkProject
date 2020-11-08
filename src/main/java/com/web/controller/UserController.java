package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.model.User;
import com.web.service.UserService;

@Controller
@CrossOrigin
@RequestMapping("/user.app")
public class UserController {

	
	private UserService us;
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	/**
	 * Finds all users within the DB
	 * @return list of all users
	 */
	@RequestMapping("/alluser")
	@GetMapping
	public @ResponseBody List<User> findAll(){
		return us.findAll();
	}
	
	/**
	 * Finds a user by their username
	 * @param username the id of the user
	 * @return User with matching username, null if not
	 */
	@RequestMapping("/finduserbyusername")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public User findById(@RequestBody String username) {
		return us.findById(username);
	}
	
	/**
	 * Updates user information
	 * @param user new User object to update existing user
	 * @return New user information, or null if no user with the username exists
	 */
	public User updateUserInformation(User user) {
		return us.updateUserInformation(user);
	}
	
	/**
	 * Deletes user from DB
	 * @param username id of the user
	 * @return the User object that was removed from the DB
	 */
	public User deleteUser(String username) {
		return us.deleteUser(username);
	}
	
	/**
	 * Creates new user in DB
	 * @param User to be added
	 * @return the user that was added
	 */
	@RequestMapping("/newuser")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User addUser(@RequestBody User user) throws ParseException{
		return us.addUser(user);
	}



}
