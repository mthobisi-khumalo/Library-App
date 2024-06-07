package edu.nagarro.service;

import org.springframework.stereotype.Service;

import edu.nagarro.dto.UserDto;

/*
 * Author service interface 
 */

@Service
public interface UserService {
	
	public UserDto getUser(String email, String password);
}
