package main.java.my.examples.mywas;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketHandler extends Thread {

    // class 정보를 담는 객체는 한번만 메모리에 올라가면 된다.
    private static Map<String, Class> map;
    private static Map<String, HttpServlet> servletMap;
    static {
        servletMap = new HashMap<>();
        WebServletMapperManager wsmm = new WebServletMapperManager();
        map = wsmm.findServlet("/Users/choijaeyong/fastcampus/git/mywas/target/classes/");
    }



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

            // request response 를 이용하여 무엇을 할까??
            // 1. path 정보에 해당하는 동적 프로그램이 있는지 확인한다.
            // ex:) /today  --> TodayServlet 이 실행한 결과가 보여진다.
            // 2. 동적 프로그램이 아니라면
            // path 에 해당하는 파일이 있는지 찾아본다.
            // 있으면 해당 파일의 내용을 보여주고,







            DefaultServlet servlet = new DefaultServlet();
            servlet.service(req,res);

            System.out.println(req.getHttpPath());
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
