import dao.ContactsDAO;
import dao.POJO.Contacts;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by secret on 21.04.2017.
 */

// /login
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("emailL");
        String password = req.getParameter("passwordL");
//        String adname = req.getParameter("adname");
        UsersDAO ud = new UsersDAO();




        if ((email != null) && (password != null)
                && (!email.equals(""))
                && (!password.equals(""))) {

            String adname = ud.logMeIn(email, password);
            req.getSession().setAttribute("adn", adname);
//            req.getSession().setAttribute("adn", adname);
//            req.getRequestDispatcher("/settings").forward(req, resp);
            resp.sendRedirect("/settings");
        }
        else
            resp.sendRedirect("/");

    }

}
