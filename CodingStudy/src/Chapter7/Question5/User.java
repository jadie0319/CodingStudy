package Chapter7.Question5;

public class User {
	private int userId;
	private String details;
	private int accountType;
	
	public void renewMembership() {
		
	}
	
	public User(int id, String detail, int account) {
		userId = id;
		details = detail;
		accountType = account;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	
	

}
