package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.model.Post;
import com.web.service.PostService;

@Controller
@CrossOrigin
@RequestMapping("/post.app")
public class PostController {

	private PostService ps;
	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}
	
	/**
	 * finds all posts
	 * @return a list of all posts
	 */
	@RequestMapping("/allposts")
	@GetMapping
	public List<Post> findAll(){
		return ps.findAll();
	}
	
	/**
	 * finds a post by it's id
	 * @param id unique ID of the post
	 * @return post with matching ID, null if no matching ID found
	 */
	public Post findById(int id) {
		return ps.findById(id);
	}
	
	/**
	 * edits the information of a post
	 * @param post new Post object with updated information
	 * @return updated Post if successful, null if not
	 */
	public Post editPost(Post post) {
		return ps.editPost(post);
	}
	
	/**
	 * creates a new Post
	 * @param post new Post Object to be stored in the DB
	 * @return created post if successful, null if not
	 */
	public Post createPost(Post post) {
		return ps.createPost(post);
	}
	
	/**
	 * deletes post with specified ID
	 * @param id unique identifier for the post
	 * @return deleted post if successful, null if not
	 */
	public Post deletePost(int id) {
		return ps.deletePost(id);
	}
	
	/**
	 * finds all posts by specified user
	 * @param username unique identifier for user
	 * @return list of posts by user
	 */
	@RequestMapping("/newpost")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Post> findAllByUser(@RequestBody String username) {
		return ps.findAllByUser(username);
	}
}
