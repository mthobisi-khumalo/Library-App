package edu.nagarro.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.nagarro.dao.UserRepository;
import edu.nagarro.dto.UserDto;
import edu.nagarro.entity.User;
import edu.nagarro.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserDto getUser(String email, String password) {

		User userFound = (User) userRepository.findByEmailAndPassword(email, password);
		UserDto userDto = new UserDto();
		
		if(userFound!=null) {
			userDto.setUserId(userFound.getUserId());
			userDto.setName(userFound.getName());
			userDto.setEmail(userFound.getEmail());
			userDto.setPassword(userFound.getPassword());
		}else {
			userDto.setUserId(0);
		}
		
		return userDto;
	}

}
