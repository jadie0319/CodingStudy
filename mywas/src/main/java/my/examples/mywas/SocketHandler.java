package main.java.my.examples.mywas;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread {
    private Socket socket;
    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;


        try {
            in = socket.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));

            Request req = new Request(in,br);
            Response res = new Response(out,pw);


            DefaultServlet servlet = new DefaultServlet();
            servlet.service(req,res);

            System.out.println("service 메소드 이후에 :  " + res.getContentLength());





        } catch(Exception ex) {
            System.out.println("SocketHandler 에서의 에러 : " + ex.getMessage());
        } finally {
            try {
                in.close();
            }catch(Exception e){}

            try {
                out.close();
            }catch(Exception e){}

            try {
                socket.close();
            }catch(Exception e){}
        }

    }
}
