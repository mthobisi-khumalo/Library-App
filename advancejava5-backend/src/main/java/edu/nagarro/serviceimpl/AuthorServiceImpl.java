package edu.nagarro.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.nagarro.dao.AuthorRepository;
import edu.nagarro.dto.AuthorDto;
import edu.nagarro.dto.BookDto;
import edu.nagarro.entity.Author;
import edu.nagarro.entity.Book;
import edu.nagarro.service.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public List<AuthorDto> getAllData() {
		
		List<Author> authorsFound = (List<Author>) authorRepository.findAll();

		List<AuthorDto> authorsList = new ArrayList<AuthorDto>();
		for (Author authorEntity : authorsFound) {
			AuthorDto authorDto = new AuthorDto();
			authorDto.setAuthorName(authorEntity.getName());
			authorsList.add(authorDto);
		}
		return authorsList;
	}

}
