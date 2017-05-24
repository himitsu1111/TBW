import dao.AdsDAO;
import dao.ContactsDAO;
import dao.GroupsDAO;
import dao.POJO.Ads;
import dao.POJO.Contacts;
import dao.POJO.Groups;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by secret on 11.04.2017.
 */

//@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {

    ContactsDAO cd = new ContactsDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        resp.sendRedirect("/");

        AdsDAO ad = new AdsDAO();
        String s = (String)req.getSession().getAttribute("adn");

        if (s != null) {
            System.out.println("was in settings get adn not null");
            List<Contacts> lc = cd.getContacts();

            req.setAttribute("listContacts", lc);

            if (ad.checkAd(s)) {
                Ads ads = ad.getAdByAdname(s);
                req.setAttribute("ads", ads);
                System.out.println("was in get/settings/checkAd");
            }

            req.getRequestDispatcher("/template.jsp").forward(req, resp);
        }
        else
            req.getRequestDispatcher("/").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String adname = req.getParameter("adname");

        String header = req.getParameter("header");
        String textField = req.getParameter("textField");
        String con1 = req.getParameter("con1");
        String con2 = req.getParameter("con2");
        String contactName1 = req.getParameter("contactName1");
        String contactName2 = req.getParameter("contactName2");

        UsersDAO ud = new UsersDAO();



        if ((email != null) && (!email.equals(""))
                && (!password.equals("")) && (!adname.equals(""))
                && ud.createUser(email, password, adname)) {

            List<Contacts> lc = cd.getContacts();

            req.setAttribute("listContacts", lc);
            req.getSession().setAttribute("adn", adname);
            req.getRequestDispatcher("/template.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/");
            System.out.println("was in set post redirect to /");
        }

//        AdsDAO ad = new AdsDAO();
//
//        if (header != null) {
//            String adn = (String)req.getSession().getAttribute("adn");
//            if (!adn.isEmpty()) {
//                ad.createAd(adn, header, textField, contactName1, contactName2, con1, con2);
//                req.getRequestDispatcher("/1.jsp").forward(req, resp);
//            }
//        }

    }
}
