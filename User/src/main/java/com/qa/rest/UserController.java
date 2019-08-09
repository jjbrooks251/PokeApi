package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entities.User;
import com.qa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;

	private RestTemplate rest;

	private JmsTemplate jmsTemplate;

	@Autowired
	public UserController(UserService service, RestTemplate rest, JmsTemplate jmsTemplate) {
		this.service = service;
		this.rest = rest;
		this.jmsTemplate = jmsTemplate;
	}
	
//	private void sendToQueue(User user){
//        SentUser accountToStore =  new SentUser(user);
//        jmsTemplate.convertAndSend("UserQueue", userToStore);
//    }
	
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return service.getUsers();
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User retval = service.createUser(user);
		return new ResponseEntity<>(retval, HttpStatus.CREATED);
	}
	
}
