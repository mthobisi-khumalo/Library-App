package edu.nagarro.service;

import org.springframework.stereotype.Service;

import edu.nagarro.model.User;

@Service
public interface UserService {

	public User getUser(String email, String password);
}
