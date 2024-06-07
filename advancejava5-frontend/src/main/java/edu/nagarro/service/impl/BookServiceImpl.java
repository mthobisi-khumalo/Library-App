package edu.nagarro.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.nagarro.model.Book;
import edu.nagarro.service.BookService;

@Component
public class BookServiceImpl implements BookService {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8081/books";

	@Override
	public Book[] getBooks() {
		
		ResponseEntity<Book[]> bookArray=restTemplate.getForEntity(url, Book[].class);
		Book[] book = bookArray.getBody();
		return book;
	}

	@Override
	public void addBook(Book book) {
		
		restTemplate.postForEntity(url, book, Book.class);
	}

	@Override
	public void updateBook(Book book, int bookId) {
		
		restTemplate.put(url+"/"+bookId, book);
	}

	@Override
	public void deleteBook(int bookId) {
		
		restTemplate.delete(url+"/"+bookId);

	}

}
