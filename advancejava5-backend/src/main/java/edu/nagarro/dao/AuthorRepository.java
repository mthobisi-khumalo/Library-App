package edu.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.nagarro.entity.Author;


/*
 * Repository class to perform CRUD operations on Author class
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, String>{

}
