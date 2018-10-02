package my.examples.web.secondweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/TodayServlet")
public class TodayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        LocalDateTime today = LocalDateTime.now();
        out.println("today : " + today.toString());
        out.close();
    }


    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getMethod().equals("GET")) {
            doGet(req,res);

        }
    }


}
