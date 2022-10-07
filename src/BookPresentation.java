import java.util.Scanner;

import pojo.BookPojo;
import service.BookService;
import service.BookServiceImpl;


public class BookPresentation {

	public static void main(String[] args) {

		// here we will have the input and the outputs
		// the menus are displayed here
		
		// presentation layers calls the methods of the service layer
		// so i need an object of BookServiceImpl
		BookService bookService = new BookServiceImpl(); // always the interface reference variable should point to the object of the implementation class
		
		Scanner scan = new Scanner(System.in);
		char continueApp = 'y';

		while (continueApp == 'y' || continueApp == 'Y') {

			System.out.println("*************************************************");
			System.out.println("\t\tBOOK MANAGEMENT SYSTEM");
			System.out.println("*************************************************");
			System.out.println("MAIN MENU");
			System.out.println("*************************************************");
			System.out.println("1. List all the books.");
			System.out.println("2. Add a new book.");
			System.out.println("3. Update a book.");
			System.out.println("4. Delete a book.");
			System.out.println("5. Fetch a book");
			System.out.println("6. Exit.");
			System.out.println("*************************************************");
			System.out.println("Please enter an option : ");
			int option = scan.nextInt();
			System.out.println("*************************************************");
			switch (option) {
			case 1:
				// will remove this statement later an dput the actual code here
				// System.out.println("Listing all the books....");
				
				BookPojo[] fetchedAllBooks = bookService.getAllBooks();
				System.out.println("=============================================================================");
				System.out.println("ID\tTITLE\t\t\t\t\tAUTHOR\t\tGENRE\tCOST");
				System.out.println("=============================================================================");
				for(int i=0;i<fetchedAllBooks.length;i++) {
					if(fetchedAllBooks[i] != null) {
						System.out.println(fetchedAllBooks[i].getBookId() + "\t" + fetchedAllBooks[i].getBookTitle() + "\t" + fetchedAllBooks[i].getBookAuthor() + "\t" + fetchedAllBooks[i].getBookGenre() + "\t" + fetchedAllBooks[i].getBookCost());
					}
				}
				System.out.println("=============================================================================");
				break;
			case 2:
				System.out.println("Enter Book Title: ");
				String bookTitle = scan.nextLine();
				scan.nextLine();
				
				System.out.println("Enter Book Authur: ");
				String bookAuthur = scan.nextLine();
				scan.nextLine();
				
				System.out.println("Enter Book Genre: ");
				String bookGenre = scan.nextLine();
				scan.nextLine();
				
				System.out.println("Enter Book Cost: ");
				int bookCost = scan.nextInt();
				
				// now create a book pojo object and set these values into it
				BookPojo newBook = new BookPojo();
				newBook.setBookTitle(bookTitle);
				newBook.setBookAuthor(bookAuthur);
				newBook.setBookGenre(bookGenre);
				newBook.setBookCost(bookCost);
				
				BookPojo newBookPojoWithId = bookService.addBook(newBook);
				System.out.println("New book with ID " + newBookPojoWithId.getBookId() + " is added!! ");
				
				break;
			case 3:
				System.out.println("Please enter the Book ID: ");
				int bookId = scan.nextInt();
				BookPojo fetchedBookPojo = bookService.getABook(bookId);
				if(fetchedBookPojo == null) {
					// the book with the id is not found
					System.out.println("Book with ID " + bookId + " does not exist!!");
				} else {
					// the book with the id has been found
					// so display the book information
					System.out.println("=============================");
					System.out.println("BOOK ID : " + fetchedBookPojo.getBookId());
					System.out.println("BOOK TITLE : " + fetchedBookPojo.getBookTitle());
					System.out.println("BOOK AUTHOR : " + fetchedBookPojo.getBookAuthor());
					System.out.println("BOOK GENRE : " + fetchedBookPojo.getBookGenre());
					System.out.println("BOOK COST : " + fetchedBookPojo.getBookCost());
					System.out.println("=============================");
					System.out.println("Enter the new cost: ");
					int newCost = scan.nextInt();
					fetchedBookPojo.setBookCost(newCost);
					BookPojo updatedBookPojo =bookService.updateBook(fetchedBookPojo);
					System.out.println("Book cost updated successfully!!");
					
				}
				
				break;
			case 4:
				// will remove this statement later an dput the actual code here
				System.out.println("Deleting a book....");
				break;
			case 5:
				System.out.println("Please enter the Book ID: ");
				int fetchBookId = scan.nextInt();
				BookPojo returnedBookPojo = bookService.getABook(fetchBookId);
				if(returnedBookPojo == null) {
					// the book with the id is not found
					System.out.println("Book with ID " + fetchBookId + " does not exist!!");
				} else {
					// the with with the id has been found
					// so display the book information
					System.out.println("BOOK ID : " + returnedBookPojo.getBookId());
					System.out.println("BOOK TITLE : " + returnedBookPojo.getBookTitle());
					System.out.println("BOOK AUTHOR : " + returnedBookPojo.getBookAuthor());
					System.out.println("BOOK GENRE : " + returnedBookPojo.getBookGenre());
					System.out.println("BOOK COST : " + returnedBookPojo.getBookCost());
				
				}
				break;
			case 6:
				System.out.println("*************************************************");
				System.out.println("THANKYOU FOR USING BOOK MANAGEMENT SYSTEM!!");
				System.out.println("*************************************************");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid option!!");

			}
			System.out.println("*************************************************");
			System.out.println("Do you want to continue(y/n) ?");
			continueApp = scan.next().charAt(0); // taking out the first character of the string that was given as input
			// here
		}
		System.out.println("*************************************************");
		System.out.println("THANKYOU FOR USING BOOK MANAGEMENT SYSTEM!!");
		System.out.println("*************************************************");

	}

}
