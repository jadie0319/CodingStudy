package Chapter7.Question5;

public class Book {
	private int bookId;
	private String details;
	
	public Book(int id, String detail) {
		bookId = id;
		details = detail;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	

}
