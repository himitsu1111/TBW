import dao.AdsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by secret on 17.05.2017.
 */

// /mail

public class MailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String param = "";
        String rating = "";
        param = req.getParameter("param");
        rating = req.getParameter("rating");
        System.out.println("in mail servlet -- " + param);
//        if (!param.equals("")) {
//            System.out.println("can send some emails!!!");
//
//        }
        AdsDAO ad = new AdsDAO();
        ad.increaseRating(param);
        Integer intParam = Integer.parseInt(rating) + 1;
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(intParam.toString());
    }
}
