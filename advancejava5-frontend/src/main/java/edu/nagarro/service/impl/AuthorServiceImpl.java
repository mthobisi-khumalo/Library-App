package edu.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.nagarro.model.Author;
import edu.nagarro.service.AuthorService;


@Component
public class AuthorServiceImpl implements AuthorService{

	@Override
	public Author[] getAuthor() {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Author[]> responseEntity=restTemplate.getForEntity("http://localhost:8081/authors",  Author[].class);
		return responseEntity.getBody();
	}

}
