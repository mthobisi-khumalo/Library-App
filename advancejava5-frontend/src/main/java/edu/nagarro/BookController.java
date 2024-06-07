package edu.nagarro;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.nagarro.model.Book;
import edu.nagarro.service.BookService;

@Controller
public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String username;
	public void setUsername(HttpSession session) {
		this.username = session.getAttribute("uname").toString();
	}

	private BookService bookService;
	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(BookService bs) {
		this.bookService = bs;
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String pageInit() {
		return "addBook";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@RequestParam(value = "bookId") int bookId, @RequestParam(value = "bookName") String bookName,
			@RequestParam(value = "authorName") String authorName, Model model) {

		String currentDate = new java.sql.Date(System.currentTimeMillis()) + "";
		Book book = new Book(bookId, bookName, authorName, currentDate);
		bookService.addBook(book);

		model.addAttribute("uname", username);
		Book[] b = bookService.getBooks();
		model.addAttribute("bookArray", b);
		return "libraryPage";
	}

	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public String initEditBook() {
		return "editBook";
	}

	@RequestMapping("/editBook")
	public String editBook(Model model, @RequestParam("bookName") String bookName,
			@RequestParam("authorName") String authorName, @RequestParam("bookId") int bookId, @RequestParam("currentDate") String currentDate) {

		Book book = new Book(bookId, bookName, authorName, currentDate);
		bookService.updateBook(book, bookId);

		model.addAttribute("uname", username);
		Book[] b = bookService.getBooks();
		model.addAttribute("bookArray", b);
		return "libraryPage";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(Model model, @RequestParam("bookId") int bookId) {

		bookService.deleteBook(bookId);
		model.addAttribute("uname", username);
		Book[] book = bookService.getBooks();
		model.addAttribute("bookArray", book);
		return "libraryPage";
	}
}
