package Chapter7.Question5;

public class OnlineReaderSystem {
	private User activeUser;
	private Book activeBook;
	
	private Library library;
	private UserManager userManager;
	private Display display;
	
	public OnlineReaderSystem() {
		library = new Library();
		userManager = new UserManager();
		display = new Display();
	}
	
	public Library getLibrary() {
		return library;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public Book getActiveBook() {
		return activeBook;
	}
	
	public void setActiveBook(Book book) {
		activeBook = book;	
		display.displayBook(book);
	}
	
	public User getActiveUser() {
		return activeUser;
	}
	
	public void setActiveUser(User user) {
		activeUser = user;
		display.displayUser(user);
	}
	
	
	
	

}
