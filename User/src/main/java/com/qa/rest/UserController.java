package com.qa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entities.SentUser;
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

	private void sendToQueue(User user){
        SentUser userToStore =  new SentUser(user);
        jmsTemplate.convertAndSend("UserQueue", userToStore);
    }

	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return service.getUsers();
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User retval = service.createUser(user);
		sendToQueue(user);
		return new ResponseEntity<>(retval, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getUser/{aId}")
	public ResponseEntity<User> getOneUser(@PathVariable("aId") int aId) {

		User retVal = service.findByAId(aId);

		if (retVal == null) {
			return new ResponseEntity<>(retVal, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(retVal, HttpStatus.CREATED);
		}
	}
	
	@GetMapping(value = "pokeName/{aId}/{name}")
	public ResponseEntity<Object> getPokeByName(@PathVariable("aId") int aId, @PathVariable("name") String name){
		
		User retVal = service.findByAId(aId);
		
		if (retVal == null) {
			return new ResponseEntity<>(retVal, HttpStatus.NO_CONTENT);
		} else {
		
			Object pokemon = rest.getForObject("http://localhost:8081/poke/getName/{name}", Object.class, name);
			
		return new ResponseEntity<>(pokemon, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "pokeNum/{aId}/{num}")
	public ResponseEntity<Object> getPokeByNum(@PathVariable("aId") int aId, @PathVariable("num") int num){
		
		User retVal = service.findByAId(aId);
		
		if (retVal == null) {
			return new ResponseEntity<>(retVal, HttpStatus.NO_CONTENT);
		} else {
		
			Object pokemon = rest.getForObject("http://localhost:8081/poke/getNum/{num}", Object.class, num);
		
		return new ResponseEntity<>(pokemon, HttpStatus.OK);
		}
	}

}
