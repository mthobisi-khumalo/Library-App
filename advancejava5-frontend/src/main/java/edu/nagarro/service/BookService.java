package edu.nagarro.service;

import org.springframework.stereotype.Service;

import edu.nagarro.model.Book;

@Service
public interface BookService {

	public Book[] getBooks();

	public void addBook(Book book);

	public void updateBook(Book book, int id);

	public void deleteBook(int id);
}
