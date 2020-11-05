package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import com.web.model.Post;

//future annotations for spring
//@ContextConfiguration(locations = "")
//@Transactional
public class PostDaoTest {
	private PostDao pd;
	private Post post;
	
	@Before
	public void init() {
		pd = new PostDao();
		post = new Post(1, "some username", "Testing Post", "This post is all about testing.");
		pd.create(post);
	}
	
	@Test
//	@Rollback(true)
	public void testAddPost() {
		Post p = new Post();
		assertNotNull(pd.create(p));
	}
	
	@Test
//	@Rollback(true)
	public void testFindAll() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		assertEquals(posts, pd.findAll());
	}
	
	@Test
//	@Rollback(true)
	public void testFindAllByAuthor() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		assertEquals(posts, pd.findAllByAuthor(post.getAuthor()));
	}

	@Test
//	@Rollback(true)
	public void testFindById() {
		List<Post> posts = new ArrayList<>();
		posts.add(post);
		assertEquals(posts, pd.findById(post.getPostId()));
	}
	
	@Test
//	@Rollback(true)
	public void	testUpdatePost() {
		post.setBody("changed");
		assertNotNull(pd.update(post));
		assertEquals("changed", pd.findById(post.getPostId()).getBody());
	}
	
	@Test
//	@Rollback(true)
	public void testDeletePostSuccessfully() {
		assertNotNull(pd.delete(post.getPostId()));
	}

	@Test
//	@Rollback(true)
	public void testDeletePostUnsuccessfully() {
		Post p = new Post();
		assertNull(pd.delet(p.getPostId()));
	}

	@Test(expected = HibernateException.class)
//	@Rollback(true)
	public void testDuplicatePostThrowsException() {
		pd.create(post);
		pd.create(post);
	}
	
}
