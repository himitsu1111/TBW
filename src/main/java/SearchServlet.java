import dao.AdsDAO;
import dao.POJO.Ads;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by secret on 26.04.2017.
 */

// /search
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");

        AdsDAO adsDAO = new AdsDAO();
        List<Ads> la = adsDAO.searchByHeader(query);
        System.out.println("was in search servlet!");
        req.setAttribute("result", la);
        req.getRequestDispatcher("/search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
