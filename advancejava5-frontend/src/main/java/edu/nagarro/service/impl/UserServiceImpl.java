package edu.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.nagarro.model.User;
import edu.nagarro.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	public User getUser(String email, String password) {
		
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<User> responseEntity=restTemplate.getForEntity("http://localhost:8081/findUser/"+email+"/"+password,  User.class);
		return responseEntity.getBody();
	}
}
