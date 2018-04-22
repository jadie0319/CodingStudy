package Chapter7.Question3;

public class User {
	private String name;
	private long ID;
	
	public User(String n, long i) {
		name = n;
		ID = i;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	public User getUser() {
		return this;
	}
	
	public static User addUser(String n, long i) {
		return new User(n,i);
	}
	
	
	
	

}
