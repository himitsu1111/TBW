import dao.GroupsDAO;
import dao.IptableDAO;
import dao.POJO.Groups;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by secret on 11.04.2017.
 */

// /index.jsp
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        GroupsDAO gd = new GroupsDAO();
        IptableDAO id = new IptableDAO();
//        List<Groups> lg = gd.getGroups();
//        req.setAttribute("gr", lg);
        String ip1 = "ip = " + req.getHeader("X-Forwarded-For") + "srv ip = " + req.getLocalAddr() + "srv name - " + req.getServerName();
//
        id.addIp(ip1);
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);

//        UsersDAO ud = new UsersDAO();
//
//        String s = req.getRequestURI();
//        if (!s.equals("/")) {
//            String[] strings = s.split("/");
//            System.out.println(strings[1] + "was in new servlet");
//            System.out.println(s + "was in new servlet 2nd time");
//            if (ud.checkAdName(strings[1])) {
//                req.getRequestDispatcher("/1.jsp").forward(req, resp);
//            } else
//                req.getRequestDispatcher("/index.jsp").forward(req, resp);
//        }
//        else
//            resp.sendRedirect("/index.jsp");
//        req.setAttribute("show", "show");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
