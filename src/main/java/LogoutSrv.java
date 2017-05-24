import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by secret on 24.04.2017.
 */

// /logout
public class LogoutSrv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        session.removeAttribute("adn");
//        session.removeAttribute("myAdmin");
        session.invalidate();
        resp.sendRedirect("/");
//        RequestDispatcher rd = req.getRequestDispatcher("/"); //The url where go after logout
//        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
