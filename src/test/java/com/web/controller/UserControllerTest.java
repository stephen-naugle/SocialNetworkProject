package com.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.web.model.User;
import com.web.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	@Mock
	private UserService usMock;
	@InjectMocks
	private UserController uc;
	private User user;
	
	@Before
	public void init() {
		uc = new UserController(usMock);
		user = new User("some username", "some pass", "some email", "some first", "some last", "some num",
				"some occupation", "some bio", "some address", LocalDate.now());
	}
	
	@Test
	public void testAddUser() {
		when(usMock.create(user)).thenReturn(user);
		assertEquals(user.toString(), uc.create(user).toString());
	}
	
	@Test
	public void testFindAll() {
		List<User> users = new ArrayList<>();
		users.add(user);
		when(usMock.findAll()).thenReturn(users);
		assertEquals(users.get(0).toString(), uc.findAll().get(0).toString());
	}
	
	@Test
	public void testFindUserByUsername() {
		when(usMock.findByUsername(user.getUsername())).thenReturn(user);
		assertEquals(user.toString(), uc.findByUsername(user.getUsername()).toString());
	}
	
	@Test
	public void testUpdateUser() {
		when(usMock.update(user)).thenReturn(user);
		assertEquals(user.toString(), uc.update(user).toString());
	}
	
	@Test
	public void testDeleteUser() {
		when(usMock.delete(user.getUsername())).thenReturn(user);
		assertNotNull(uc.delete(user.getUsername()));
	}
}
