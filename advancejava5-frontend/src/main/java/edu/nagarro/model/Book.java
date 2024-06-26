package edu.nagarro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Book{

	private int bookId;

	private String bookName;

	private String authorName;

	private String currentDate;

}
