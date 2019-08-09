package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.entities.User;
import com.qa.repositories.UserRepository;

import org.junit.Assert;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repo;
	
	private static final User user1 = new User(1, "Josh", 1);
	private static final User user2 = new User(2, "Monika", 2);
	
	@Test
	public void getAllUsers() {
		List<User> Mock_List = new ArrayList<>();
		Mock_List.add(user1);
		Mock_List.add(user2);
		Mockito.when(repo.findAll()).thenReturn(Mock_List);
		Assert.assertEquals(Mock_List, service.getUsers());
		Mockito.verify(repo).findAll();
	}
	
	@Test
	public void createUser() {
		Mockito.when(repo.save(user1)).thenReturn(user1);
		Assert.assertEquals(user1, service.createUser(user1));
		Mockito.verify(repo).save(user1);
	}

}
