package main.java.my.examples.mywas;

import java.io.PrintWriter;

@WebServlet("/my")
public class MyServlet extends  HttpServlet {
    @Override
    public void doGet(Request req, Response resp) {
        PrintWriter out = resp.getPw();
        for(int i=0; i< 10 ; i++) {
            out.println("<h2>hello</h2>");
        }

    }
}
