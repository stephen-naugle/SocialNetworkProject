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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Comment;
import com.web.service.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

	private CommentService cs;
	@Autowired
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	/**
	 * finds all comments by post ID
	 * @return list of comments related to specified post ID
	 */
	@GetMapping("/findcommentsbypid")
	public List<Comment> findAllByPost(@RequestParam int pid) {
		return cs.findAllByPost(pid);
	}
	
	/**
	 * finds comment by its ID
	 * @param id unique identifier for comment
	 * @return
	 */
	@GetMapping("/findcommentsbyid")
	public Comment findById(@RequestParam int id) {
		return cs.findById(id);
	}
	
	/**
	 * updates comment information
	 * @param comment Comment object with updated information
	 * @return updated comment if successful, null if not
	 */
	@PostMapping("/update")
	public Comment updateComment(@RequestBody Comment comment) {
		return cs.updateComment(comment);
	}
	
	/**
	 * creates a comment
	 * @param comment Comment object with created information
	 * @return created comment if successful, null if not
	 */
	@PostMapping("/newcomment")
	public Comment createComment(@RequestBody Comment comment) {
		return cs.createComment(comment);
	}
	
	/**
	 * deletes a comment from the DB
	 * @param id unique identifier for the comment
	 * @return deleted comment if exists, null if it does not
	 */
	@PostMapping("/delete")
	public Comment deleteComment(@RequestBody Comment comment) {
		return cs.deleteComment(comment);
	}
	
}
