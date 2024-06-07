package edu.nagarro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.nagarro.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String password);
}
