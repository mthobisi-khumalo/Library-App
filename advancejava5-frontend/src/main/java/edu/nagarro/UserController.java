package edu.nagarro;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.nagarro.model.Book;
import edu.nagarro.model.User;
import edu.nagarro.service.BookService;
import edu.nagarro.service.UserService;

@Controller
@SessionAttributes("uname")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserService userService;
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	private BookService bookService;
	@Autowired(required = true)
	@Qualifier(value = "bookService")
	public void setBookService(BookService bs) {
		this.bookService = bs;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String start() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model m,
			HttpServletRequest request) throws Exception {

		User user = userService.getUser(email, password);
		int userId = user.getUserId();
		
		if (userId != 0) {
			String username = user.getName();
			m.addAttribute("uname", username);
			Book[] book = bookService.getBooks();
			m.addAttribute("bookArray", book);
			return "libraryPage";
		} else {
			m.addAttribute("wrongUname", "Wrong username or password");
			return "index";
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/logout")
	public String logout() {
		return "index";
	}
}
