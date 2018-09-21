package examples.chatserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler extends Thread {
	private ChatServer chatServer;
	private Socket socket;
	private String name;
	
	public SocketHandler(ChatServer chatServer, Socket socket) {
		this.chatServer = chatServer;
		this.socket = socket;
	}

	@Override
	public void run() {
		System.out.println("SocketHandler start");
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

			this.name = in.readLine();
			chatServer.broadcast(this.name + " 님이 입장하셨습니다.");

			chatServer.addPrintWriter(out);

			
			String line = null;
			while((line = in.readLine()) != null) {
//				out.println(line);
//				out.flush();
				chatServer.broadcast(this.name + " : " + line);
			}
			
			
			
		}catch(Exception ex) {
			System.out.println("Chat Handler close");
		}finally {
			chatServer.removePrintWriter(out);
			chatServer.broadcast(this.name + "  님이 퇴장하셨습니다.");
			System.out.println("Chat Handler finally");
			try { in.close();} catch(Exception e) {}
			try { out.close();} catch(Exception e) {}
			
		}
	}
	
	
	

}
