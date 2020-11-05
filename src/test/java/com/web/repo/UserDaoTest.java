package com.web.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import com.web.model.User;

//future annotations for spring
//@ContextConfiguration(locations = "")
//@Transactional
public class UserDaoTest {
	private UserDao ud;
	private User user;
	
	@Before
	public void init() {
		ud = new UserDao();
		user = new User("some username", "some pass", "some email", "some first", "some last", "some num",
				"some occupation", "some bio", "some address", LocalDate.now());
		ud.create(user);
	}
	
	@Test
//	@Rollback(true)
	public void testAddUser() {
		User u = new User();
		assertNotNull(ud.create(u));
	}
	
	@Test
//	@Rollback(true)
	public void testFindAllUsers() {
		List<User> users = new ArrayList<>();
		users.add(user);
		assertEquals(users, ud.findAll());
	}
	
	@Test
	public void testFindUserByUsername() {
		assertEquals("some username", ud.findByUsername("some username").getUsername());
	}
	
	@Test
//	@Rollback(true)
	public void testUpdateUser() {
		user.setFirstname("changed");
		assertNotNull(ud.update(user));
		assertEquals("changed", ud.findByUsername(user.getUsername()).getFirstname());
	}
	
	@Test
//	@Rollback(true)
	public void testDeleteUserSuccessfully() {
		assertNotNull(ud.delete(user.getUsername()));
	}

	@Test
//	@Rollback(true)
	public void testDeleteUserUnsuccessfully() {
		User u = new User();
		u.setUsername("this should fail");
		assertNull(ud.delete(u.getUsername()));
	}
	
	@Test(expected = HibernateException.class)
//	@Rollback(true)
	public void testDuplicateUserThrowsException() {
		ud.create(user);
		ud.create(user);
	}
	
}
