package com.web.service;

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

import com.web.model.Post;
import com.web.repo.PostDao;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {
	@Mock
	private PostDao pdMock;
	@InjectMocks
	private PostService ps;
	private Post post;
	
	@Before
	public void init() {
		ps = new PostService(pdMock);
		post = new Post(1, "some username", "Testing Post", "This post is all about testing.");
	}
	
	@Test
	public void testAddPost() {
		when(pdMock.create(post)).thenReturn(post);
		assertEquals(post.toString(), ps.create(post).toString());
	}
	
	@Test
	public void testFindAll() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		when(pdMock.findAll()).thenReturn(posts);
		assertEquals(posts.get(0).toString(), ps.findAll().get(0).toString());
	}
	
	@Test
	public void testFindAllByAuthor() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		when(pdMock.findAllByAuthor(post.getAuthor())).thenReturn(posts);
		assertEquals(posts.get(0).toString(), ps.findAllByAuthor(post.getAuthor()).get(0).toString());
	}
	
	@Test
	public void testFindById() {
		when(pdMock.findById(post.getPostId())).thenReturn(post);
		assertEquals(post.toString(), ps.findById(post.getPostId()).toString());
	}
	
	@Test
	public void testUpdatePost() {
		when(pdMock.update(post)).thenReturn(post);
		assertEquals(post.toString(), ps.update(post).toString());
	}
	
	@Test
	public void testDeletePost() {
		when(pdMock.delete(post.getPostId())).thenReturn(post);
		assertNotNull(ps.delete(post.getPostId()));
	}
}
