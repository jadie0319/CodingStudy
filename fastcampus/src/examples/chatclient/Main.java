package examples.chatclient;

public class Main {
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("127.0.0.1" , 11000);
        chatClient.start();

    }
}
