package my.examples.guestbook.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/delete")
public class GuestbookDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // id 를 읽어들인다.
        String id = req.getParameter("id");
        System.out.println(id + " 게시글을 삭제한다.");

        // 세션에서 관리자 로그인 정보가 있는지 확인한다.

        // id에 해당하는 방명록을 삭제한다.

        resp.sendRedirect("/guestbook/list");
    }
}
