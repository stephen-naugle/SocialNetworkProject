package com.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Post;
import com.web.service.PostService;

@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {

	private static Logger logger = Logger.getLogger(PostController.class);
	
	private PostService ps;
	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
	/**
	 * finds all posts
	 * @return a list of all posts
	 */
	@GetMapping("/allposts")
	public List<Post> findAll(){
		logger.info("Found all posts.");
		return ps.findAll();
	}
	
	/**
	 * finds a post by it's id
	 * @param id unique ID of the post
	 * @return post with matching ID, null if no matching ID found
	 */
	@PostMapping("/findbypostid")
	public Post findById(@RequestBody int id) {
		logger.info("Found post by id.");
		return ps.findById(id);
	}
	
	/**
	 * edits the information of a post
	 * @param post new Post object with updated information
	 * @return updated Post if successful, null if not
	 */
	@PostMapping("/update")
	public Post editPost(@RequestBody Post post) {
		logger.info("Updated post.");
		return ps.editPost(post);
	}
	
	/**
	 * creates a new Post
	 * @param post new Post Object to be stored in the DB
	 * @return created post if successful, null if not
	 */
	@PostMapping("/create")
	public Post createPost(@RequestBody Post post) {
		logger.info("Created post.");
		return ps.createPost(post);
	}
	
	/**
	 * deletes post with specified ID
	 * @param id unique identifier for the post
	 * @return deleted post if successful, null if not
	 */
	@PostMapping("/delete")
	public Post deletePost(@RequestBody Post post) {
		logger.info("Deleted post.");
		return ps.deletePost(post);
	}
	
	/**
	 * finds all posts by specified user
	 * @param username unique identifier for user
	 * @return list of posts by user
	 */
	
	@PostMapping("/findpostsbyuser")
	public List<Post> findAllByUser(@RequestBody String username) {
		logger.info("Found all posts by username.");
		return ps.findAllByUser(username);
	}
}
