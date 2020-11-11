package com.web.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.LoginObject;
import com.web.model.User;
import com.web.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);
	
	private UserService us;
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}
	
	/**
	 * Finds all users within the DB
	 * @return list of all users
	 */
	@GetMapping("/allusers")
	public List<User> findAll(){
		logger.info("Found all users.");
		return us.findAll();
	}
	
	/**
	 * Finds a user by their username
	 * @param username the id of the user
	 * @return User with matching username, null if not
	 */
	@PostMapping("/findbyusername")
	public User findById(@RequestBody String username) {
		logger.info("Found user by username.");
		return us.findById(username);
	}
	
	/**
	 * Updates user information
	 * @param user new User object to update existing user
	 * @return New user information, or null if no user with the username exists
	 */
	@PostMapping("/update")
	public User updateUserInformation(@RequestBody User user) {
		logger.info("Updated user.");
		return us.updateUserInformation(user);
	}
	
	/**
	 * Deletes user from DB
	 * @param username id of the user
	 * @return the User object that was removed from the DB
	 */
	@PostMapping("/delete")
	public User deleteUser(@RequestBody User user) {
		logger.info("Deleted user.");
		return us.deleteUser(user);
	}
	
	/**
	 * Creates new user in DB
	 * @param User to be added
	 * @return the user that was added
	 */
	@PostMapping("/newuser")
	public User addUser(@RequestBody User user) throws ParseException{
		logger.info("Registered user.");
		return us.addUser(user);
	}
	
	@PostMapping("/login")
	public boolean loginUser(@RequestBody LoginObject loginDetails) throws NoSuchAlgorithmException {
		logger.info("Verifying user.");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] usernameByteArray = (loginDetails.getUsername() + "sticky").getBytes();
		byte[] passwordByteArray = (loginDetails.getPassword() + "sticky").getBytes();
		
		boolean verify = false;
		try {
			if(us.findById((md.digest(usernameByteArray)).toString()).getPassword().equals((md.digest(passwordByteArray)).toString())){
				logger.info("Verified.");
				verify = true;
			}
		}catch (Exception e){
			logger.info("User could not be verified.");
			logger.warn(e);
		}
		
		return verify;
	}
	
	@GetMapping("/search")
		public List<User> searchByUsername(@RequestParam String username){
			logger.info("Found all users with similar user names.");
			return us.searchByUsername(username);
		}
	
}
