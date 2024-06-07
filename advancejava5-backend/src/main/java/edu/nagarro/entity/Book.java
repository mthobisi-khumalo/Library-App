package edu.nagarro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book{
	
	@Id
	@Column(name = "CODE")
	private int code;

	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "DATE")
	private String date;
	
	@Column(name = "AUTHOR")
	private String author;

}
