package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.web.model.Comment;

//future annotations for spring
//@ContextConfiguration(locations = "")
//@Transactional
public class CommentDaoTest {
	private CommentDao cd;
	private Comment comment;
	
	@Before
	public void init() {
		cd = new CommentDao();
		comment = new Comment(1, 1, "some username", "Testing comment.");
		cd.create(comment);
	}
	
	@Test
//	@Rollback(true)
	public void testAddComment() {
		Comment c = new Comment();
		assertNotNull(cd.create(c));
	}
	
	@Test
//	@Rollback(true)
	public void testFindAll() {
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		assertEquals(comments, cd.findAll());
	}
	
	@Test
//	@Rollback(true)
	public void testFindById() {
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		assertEquals(comments, cd.findById(comment.getCommentId()));
	}
	
	@Test
//	@Rollback(true)
	public void testUpdateComment() {
		comment.setComment("changed");
		assertNotNull(cd.update(comment));
		assertEquals("changed", cd.FindById(comment.getCommentId()).getComment());
	}
	
	@Test
//	@Rollback(true)
	public void testDeleteCommentSuccessfully() {
		assertNotNull(cd.delete(comment.getCommentId()));
	}

	@Test
//	@Rollback(true)
	public void testDeleteCommentUnsuccessfully() {
		Comment c = new Comment();
		c.setCommentId(2);
		assertNull(cd.delete(comment.getCommentId()));
	}
	
	@Test
//	@Rollback(true)
	public void testDuplicateCommentThrowsException() {
		cd.create(comment);
		cd.create(comment);
	}
	

}
