package dao;

import pojo.BookPojo;

public class BookDaoArrayImpl implements BookDao{

	// allBooks is my temporary database
	// i can hold a max of 20 books
	BookPojo[] allBooks = new BookPojo[20];
	
	public BookDaoArrayImpl() {
		// we are trying to have 3 books in the array when the program startups
		allBooks[0] = new BookPojo(101, "Harry Potter and the Goblet of Fire", "J.K.Rowling", "Fiction", 35 ,"");
		allBooks[1] = new BookPojo(102, "Harry Potter and the Half Blood Prince", "J.K.Rowling", "Fiction", 45 ,"");
		allBooks[2] = new BookPojo(103, "Harry Potter and the Order of Phoenix", "J.K.Rowling", "Fiction", 30 ,"");
	}
	
	@Override
	public BookPojo[] getAllBooks() {
		return allBooks;
	}

	@Override
	public BookPojo addBook(BookPojo bookPojo) {
		// generate the new unique bookId
		int newBookId = allBooks[allBooks.length-1].getBookId() + 1;
		
		// now set this newBookId in to the incoming pojo
		bookPojo.setBookId(newBookId);
		
		// copying this bookPojo into a new BookPojo object and then adding it to the array 
		allBooks[allBooks.length] = new BookPojo(bookPojo.getBookId(), bookPojo.getBookTitle(), bookPojo.getBookAuthor(), bookPojo.getBookGenre(), bookPojo.getBookCost(), bookPojo.getBookImageUrl());
		
		// returning the bookPojo which has the newBookId set in it
		return bookPojo;
	}

	@Override
	public BookPojo updateBook(BookPojo bookPojo) {
		
		for(int i=0;i<allBooks.length;i++) {
			if(allBooks[i].getBookId() == bookPojo.getBookId()) {
				// if we have reached here means a match is found
				// and replace it with the updated bookPojo
				allBooks[i] = new BookPojo(bookPojo.getBookId(), bookPojo.getBookTitle(), bookPojo.getBookAuthor(), bookPojo.getBookGenre(), bookPojo.getBookCost(), bookPojo.getBookImageUrl());
				//  no point in continuing the loop once the book is found
				break;
			}
		}
		return bookPojo;
	}

	@Override
	public void deleteBook(int bookId) {
		for(int i=0;i<allBooks.length;i++) {
			if(allBooks[i].getBookId() == bookId) {
				// if we have reached here means a match is found
				// and just set it to null which means that we ahve removed it from the array
				// setting it to null will create an empty space in the array, but we shall choose to ignore it for now
				allBooks[i] = null;
				//  no point in continuing the loop once the book is found
				break;
			}
		}
	}

	@Override
	public BookPojo getABook(int bookId) {
		BookPojo fetchedBookPojo = null;
		for(int i=0;i<allBooks.length;i++) {
			if(allBooks[i] == null) {
				break;
			}
			if(allBooks[i].getBookId() == bookId) {
				// if we have reached here means a match is found
				fetchedBookPojo = new BookPojo(allBooks[i].getBookId(), allBooks[i].getBookTitle(), allBooks[i].getBookAuthor(), allBooks[i].getBookGenre(), allBooks[i].getBookCost(), allBooks[i].getBookImageUrl());
				//  no point in continuing the loop once the book is found
				break;
			}
		}
		// fetchedBookPOjo will remain null if no match is found
		return fetchedBookPojo;
	}

}
