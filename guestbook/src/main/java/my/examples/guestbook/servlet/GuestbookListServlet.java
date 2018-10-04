package my.examples.guestbook.servlet;

import my.examples.guestbook.dao.GuestbookDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/guestbook/list")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // db 에서 목록을 읽어온다.
        GuestbookDao guestbookDao = new GuestbookDao();
        List<Guestbook> list = guestbookDao.getGuestbookList();



        // request scope = request 에 값을 저장하여 jsp까지 값을 전달한다.
        // 읽어온 결과를 jsp 에 전달하기 위해 request에 값을 저장한다.
        req.setAttribute("guestbookList",list);
        req.setAttribute("guestbookSize", list.size());


        // jsp에 포워딩한다. 포워딩은 url은 변경되지 않고 jsp에게 값을 전달.

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(req,resp);

    }
}
