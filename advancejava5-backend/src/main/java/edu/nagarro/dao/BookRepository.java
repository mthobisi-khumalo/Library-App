package edu.nagarro.dao;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.nagarro.entity.Book;
 
public interface BookRepository extends JpaRepository<Book,Integer> {
	
	@Modifying
	@Query("update Book b set b.title = ?2, b.date = ?3, b.author = ?4 where b.code = ?1")
	String updateBookByCode(int code, String title, Date date, String author);
}
