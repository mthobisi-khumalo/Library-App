package edu.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.nagarro.dto.BookDto;
import edu.nagarro.entity.Book;
import edu.nagarro.service.BookService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookDto>> getBooks() { 
		
		List<BookDto> allData = bookService.getAllData();
		
		if (allData != null && allData.size() > 0) {
			return new ResponseEntity<>(allData,HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/books")
	public void addBook(@RequestBody BookDto book) {

		bookService.insertBook(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity delete(@PathVariable("bookId") int bookId) {
		
		try {
			bookService.delete(bookId);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("No book Found with given id", HttpStatus.BAD_REQUEST);

		}
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Object> update(@RequestBody BookDto bookData, @PathVariable("bookId") int bookId) {
		
		try {
			bookService.update(bookData, bookId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 return new ResponseEntity<>("No book found to be updated", HttpStatus.BAD_REQUEST);
		}
	}
	
}
