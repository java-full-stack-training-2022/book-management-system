package pojo;

public class BookPojo {

	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private int bookCost;
	private String bookImageUrl; // this is not very useful while working with a console based application
	
	public BookPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookPojo(int bookId, String bookTitle, String bookAuthor, String bookGenre, int bookCost,
			String bookImageUrl) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookCost = bookCost;
		this.bookImageUrl = bookImageUrl;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	public String getBookGenre() {
		return bookGenre;
	}
	
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	public int getBookCost() {
		return bookCost;
	}
	
	public void setBookCost(int bookCost) {
		this.bookCost = bookCost;
	}
	public String getBookImageUrl() {
		return bookImageUrl;
	}
	
	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}
	
	@Override
	public String toString() {
		return "BookPojo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookGenre="
				+ bookGenre + ", bookCost=" + bookCost + ", bookImageUrl=" + bookImageUrl + "]";
	}
	
	// if required place the equals() and hashcode()
	
}
