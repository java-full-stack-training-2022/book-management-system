package dao;

import pojo.BookPojo;

public interface BookDao {

	// fetches all the books - Read
	BookPojo[] getAllBooks();
	
	// adds a new book - Create
	BookPojo addBook(BookPojo bookPojo);
	
	// updates an existing book - Update
	BookPojo updateBook(BookPojo bookPojo);
	
	// deletes an existing book - Delete
	void deleteBook(int bookId);
	
	// fetches a book - Read
	BookPojo getABook(int bookId);
}
