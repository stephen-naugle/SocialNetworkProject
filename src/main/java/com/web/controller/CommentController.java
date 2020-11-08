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

import com.web.model.Comment;
import com.web.service.CommentService;

@Controller
@CrossOrigin
@RequestMapping("/comment.app")
public class CommentController {

	private CommentService cs;

	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	/**
	 * finds all comments by post ID
	 * @return list of comments related to specified post ID
	 */
	@RequestMapping("/findcommentsbypid")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> findAllByPost(int pid) {
		return cs.findAllByPost(pid);
	}
	
	/**
	 * finds comment by its ID
	 * @param id unique identifier for comment
	 * @return
	 */
	public Comment findById(int id) {
		return cs.findById(id);
	}
	
	/**
	 * updates comment information
	 * @param comment Comment object with updated information
	 * @return updated comment if successful, null if not
	 */
	public Comment updateComment(Comment comment) {
		return cs.updateComment(comment);
	}
	
	/**
	 * creates a comment
	 * @param comment Comment object with created information
	 * @return created comment if successful, null if not
	 */
	@RequestMapping("/newcomment")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Comment createComment(@RequestBody Comment comment) {
		return cs.createComment(comment);
	}
	
	/**
	 * deletes a comment from the DB
	 * @param id unique identifier for the comment
	 * @return deleted comment if exists, null if it does not
	 */
	public Comment deleteComment(int id) {
		return cs.deleteComment(id);
	}
	
}
