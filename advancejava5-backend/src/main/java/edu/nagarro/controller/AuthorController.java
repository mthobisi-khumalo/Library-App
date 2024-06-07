package edu.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.nagarro.dto.AuthorDto;
import edu.nagarro.service.AuthorService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@GetMapping("/authors")
	public ResponseEntity<List<AuthorDto>> getAuthors() {

		List<AuthorDto> allData = authorService.getAllData();

		if (allData != null && allData.size() > 0) {
			return new ResponseEntity<>(allData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
