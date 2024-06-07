package edu.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.nagarro.dto.AuthorDto;
import edu.nagarro.entity.Author;

/*
 * Author service interface 
 */

@Service
public interface AuthorService {
	
	public List<AuthorDto> getAllData();
}
