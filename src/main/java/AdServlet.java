import dao.AdsDAO;
import dao.POJO.Contacts;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by secret on 19.04.2017.
 */

// /ad /ads/*
//сервлет для пост запроса со страницы создания объявы. нужен только для этого
public class AdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String header = req.getParameter("header");
        String textField = req.getParameter("textField");
        String con1 = req.getParameter("con1");
        String con2 = req.getParameter("con2");
        String contactName1 = req.getParameter("contactName1");
        String contactName2 = req.getParameter("contactName2");

        String adname = (String)req.getSession().getAttribute("adn");
        AdsDAO ad = new AdsDAO();
        if (!ad.checkAd(adname)) {
            if (header != null) {
//                String adn = (String) req.getSession().getAttribute("adn");
                if (!adname.isEmpty()) {

                    ad.createAd(adname, header, textField, contactName1, contactName2, con1, con2);
                    //                req.getRequestDispatcher("/" + adn).forward(req, resp);
                    resp.sendRedirect("/" + adname);
                } else {
                    //                ad.updateAd(adn, header, textField, contactName1, contactName2, con1, con2);
                    resp.sendRedirect("/" + adname);
                }
            }
        }
        else {
            ad.updateAd(adname, header, textField, contactName1, contactName2, con1, con2);
            resp.sendRedirect("/" + adname);
        }
    }
}
