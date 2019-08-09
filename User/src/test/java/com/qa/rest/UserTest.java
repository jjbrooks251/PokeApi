package com.qa.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import com.qa.entities.User;
import com.qa.service.UserServiceImpl;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@InjectMocks
	private UserController controller;
	
	@Mock
	private UserServiceImpl service;
	
	@Mock
	private RestTemplate rest;
	
	@Mock
	private JmsTemplate jmsTemplate; 
	
	private static final User user1 = new User(1, "Josh", 1);
	private static final User user2 = new User(2, "Monika", 2);
	
	@Test
	public void getAllUsers() {
		List<User> Mock_List = new ArrayList<>();
		Mock_List.add(user1);
		Mock_List.add(user2);
		Mockito.when(service.getUsers()).thenReturn(Mock_List);
		Assert.assertEquals(Mock_List, controller.getAllUsers());
		Mockito.verify(service).getUsers();
	}
	
	@Test
	public void createUser() {
		Mockito.when(service.createUser(user1)).thenReturn(user1);
		Assert.assertEquals(user1, controller.createUser(user1).getBody());
		Mockito.verify(service).createUser(user1);
	}
	
	@Test
	public void findUser() {
		Mockito.when(service.findByAId(1)).thenReturn(user1);
		Assert.assertEquals(user1, controller.getOneUser(1).getBody());
		Mockito.verify(service).findByAId(1);
	}
	
	@Test 
	public void findNoUser() {
		Mockito.when(service.findByAId(3)).thenReturn(null);
		Assert.assertEquals(HttpStatus.NO_CONTENT, controller.getOneUser(3).getStatusCode());
		Mockito.verify(service).findByAId(3);
	}
	
	@Test
	public void findPokeNameUser() {
		ResponseEntity<Object> pokemon = new ResponseEntity<Object>(null, HttpStatus.OK);
		
		Mockito.when(service.findByAId(1)).thenReturn(user1);
		Assert.assertEquals(pokemon, controller.getPokeByName(1, "pikachu"));
		Mockito.verify(service).findByAId(1);
	}
	
	@Test 
	public void findPokeNameNoUser() {
		Mockito.when(service.findByAId(3)).thenReturn(null);
		Assert.assertEquals(HttpStatus.NO_CONTENT, controller.getPokeByName(3, "Pikachu").getStatusCode());
		Mockito.verify(service).findByAId(3);
	}
	
	@Test
	public void findPokeNumUser() {
		ResponseEntity<Object> pokemon = new ResponseEntity<Object>(null, HttpStatus.OK);
		
		Mockito.when(service.findByAId(1)).thenReturn(user1);
		Assert.assertEquals(pokemon, controller.getPokeByNum(1, 4));
		Mockito.verify(service).findByAId(1);
	}
	
	@Test 
	public void findPokeNumNoUser() {
		Mockito.when(service.findByAId(3)).thenReturn(null);
		Assert.assertEquals(HttpStatus.NO_CONTENT, controller.getPokeByNum(3, 4).getStatusCode());
		Mockito.verify(service).findByAId(3);
	}

}
