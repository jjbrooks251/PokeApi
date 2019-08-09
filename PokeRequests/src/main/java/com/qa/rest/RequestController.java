package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/poke")
public class RequestController {
	
	private RestTemplate restTemplate;
	
	@Autowired
	public RequestController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping(value = "/getName/{name}")
	public ResponseEntity<Object> getPokeByName(@PathVariable("name") String name) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		return restTemplate.exchange("https://pokeapi.co/api/v2/pokemon/"+name, HttpMethod.GET, entity, Object.class);
	}
	
}
