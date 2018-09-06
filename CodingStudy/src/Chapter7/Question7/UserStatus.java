package Chapter7.Question7;

public class UserStatus {
	private String message;
	private UserStatusType type;
	public UserStatus(UserStatusType type, String message) {
		this.message = message;
		this.type = type;
	}
	
	public UserStatusType getStatusType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
}
