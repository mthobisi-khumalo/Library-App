package edu.nagarro.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.nagarro.dao.BookRepository;
import edu.nagarro.dto.BookDto;
import edu.nagarro.entity.Book;
import edu.nagarro.service.AuthorService;
import edu.nagarro.service.BookService;

@Component
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<BookDto> getAllData() {
		
		List<Book> booksFound = (List<Book>) bookRepository.findAll();

		List<BookDto> booksDataList = new ArrayList<BookDto>();
		for (Book bookEntity : booksFound) {
			BookDto bookDto = new BookDto();
			bookDto.setAuthorName(bookEntity.getAuthor());
			bookDto.setBookId(bookEntity.getCode());
			bookDto.setBookName(bookEntity.getTitle());
			bookDto.setCurrentDate(bookEntity.getDate());
			booksDataList.add(bookDto);
		}
		return booksDataList;
	}

	public void delete(int bookId) throws Exception {

		Optional<Book> book = bookRepository.findById(bookId);

		if (book == null || !book.isPresent()) {
			throw new Exception("Book not found with id " + bookId);
		}

		bookRepository.deleteById(bookId);
	}

	public void update(BookDto bookDto, int bookId) throws Exception  {
		
		Book book=new Book();
		book.setCode(bookDto.getBookId());
		book.setTitle(bookDto.getBookName());
		book.setAuthor(bookDto.getAuthorName());
		book.setDate(bookDto.getCurrentDate());
		
		Optional<Book> temp = bookRepository.findById(bookId);

		if (temp == null || !temp.isPresent()) {
			throw new Exception("Book not found with id " + bookId);
		}

		book.setCode(bookId);
		bookRepository.save(book);
	}

	public void insertBook(BookDto bookDto) {
		
		Book book=new Book();
		book.setCode(bookDto.getBookId());
		book.setTitle(bookDto.getBookName());
		book.setAuthor(bookDto.getAuthorName());
		book.setDate(bookDto.getCurrentDate());
		
		bookRepository.save(book);
	}

}
