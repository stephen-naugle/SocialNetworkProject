package com.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.web.model.Comment;
import com.web.service.CommentService;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {
	@Mock
	private CommentService csMock;
	@InjectMocks
	private CommentController ct;
	private Comment comment;
	
	@Before
	public void init() {
		ct = new CommentController(csMock);
		comment = new Comment(1, 1, "some username", "Testing comment.");
	}
	
	@Test
	public void testAddComment() {
		when(csMock.create(comment)).thenReturn(comment);
		assertEquals(comment.toString(), ct.create(comment).toString());
	}
	
	@Test
	public void testFindAll() {
		List<Comment> comments = new ArrayList<>();
		comments.add(comment);
		when(csMock.findAll()).thenReturn(comments);
		assertEquals(comments.get(0).toString(), ct.findAll().get(0).toString());
	}
	
	@Test
	public void testFindById() {
		when(csMock.findById(comment.getCommentId())).thenReturn(comment);
		assertEquals(comment.toString(), ct.findById(comment.getCommentId()).toString());
	}
	
	@Test
	public void testUpdateComment() {
		when(csMock.update(comment)).thenReturn(comment);
		assertEquals(comment.toString(), ct.update(comment).toString());
	}
	
	@Test
	public void testDeleteComment() {
		when(csMock.delete(comment.getCommentId())).thenReturn(comment);
		assertNotNull(ct.delete(comment.getCommentId()));
	}
}
