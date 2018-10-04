package my.examples.guestbook.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/guestbook/login")
public class GuestbookLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // jsp에 포워딩 한다. 포워딩은 url은 변경되지 않고 jsp에 값을 전달.

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 암호를 읽어들인다.
        String pw = req.getParameter("password");
        System.out.println("password : " + pw);

        // 암호가 관리자 암호 인지 확인한다.
        if("1234".equals(pw)) {
            // 맞다면 session에 값을 전달.
            HttpSession session = req.getSession();
            session.setAttribute("admin","true");

        }

        // 로그인 후에는 /guestbook/list redirect 한다.
        resp.sendRedirect("/guestbook/list");
    }
}
