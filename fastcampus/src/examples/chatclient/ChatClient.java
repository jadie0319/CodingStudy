package examples.chatclient;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient extends Thread {
    private String ip;
    private int port;
    private String name;

    public ChatClient(String ip, int port) {
        this.ip=ip;
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader keyboard = null;

        try {

            socket = new Socket(ip,port);



        }catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            try{ socket.close(); } catch(Exception e ) {}
            try{ in.close(); } catch(Exception e ) {}
            try{ out.close(); } catch(Exception e ) {}

        }

    }
}
