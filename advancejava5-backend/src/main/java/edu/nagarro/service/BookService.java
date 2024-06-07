package edu.nagarro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.nagarro.dto.BookDto;
import edu.nagarro.entity.Book;

/*
 * Book service Interface
 */

@Service
public interface BookService {
	
	public List<BookDto> getAllData();
	public void delete(int bookId) throws Exception;
	public void update(BookDto bookDto,  int bookId) throws Exception;
	public void insertBook(BookDto bookDto);
}
