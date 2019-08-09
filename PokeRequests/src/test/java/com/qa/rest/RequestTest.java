package com.qa.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestTest {
	
	@InjectMocks
	private RequestController controller;
	
	@Mock 
	private RestTemplate rest;
	
	@Test
	public void findByName() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<Object> pokemon = new ResponseEntity<Object>(null, HttpStatus.OK);
		
		Mockito.when(rest.exchange("https://pokeapi.co/api/v2/pokemon/pikachu", HttpMethod.GET, entity, Object.class)).thenReturn(pokemon);
		Assert.assertEquals(pokemon, controller.getPokeByName("pikachu"));
	}
	
	@Test
	public void findByNum() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<Object> pokemon = new ResponseEntity<Object>(null, HttpStatus.OK);
		
		Mockito.when(rest.exchange("https://pokeapi.co/api/v2/pokemon/4", HttpMethod.GET, entity, Object.class)).thenReturn(pokemon);
		Assert.assertEquals(pokemon, controller.getPokeByNum(4));
		
	}
	
}
