package Chapter7.Question7;

public class GroupChat extends Conversation {
	public void removeParticiPant(User user) {
		participants.remove(user);
	}
	
	public void addParticipant(User user) {
		participants.add(user);
	}
}
