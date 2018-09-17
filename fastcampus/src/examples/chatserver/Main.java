package examples.chatserver;

public class Main {

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer(11000);
		chatServer.start();
		
	}

}
