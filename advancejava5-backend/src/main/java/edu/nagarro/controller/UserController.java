package edu.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.nagarro.dto.UserDto;
import edu.nagarro.service.UserService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/findUser/{email}/{password}")
	public ResponseEntity<UserDto> getUser(@PathVariable String email, @PathVariable String password) {

		UserDto user = userService.getUser(email, password);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
