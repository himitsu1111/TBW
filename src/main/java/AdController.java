import dao.AdsDAO;
import dao.POJO.Ads;
import dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by secret on 17.04.2017.
 */
// /ads/*
//сервлет дл€ гет запроса любой страницы с объ€вой.
//второй сервлет нужен потому, что при пост запросе, адрес сервлета ещЄ неизвестен
//и сюда запрос прийти ещЄ не сможет.
public class AdController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersDAO ud = new UsersDAO();
        AdsDAO ad = new AdsDAO();
        String s = req.getRequestURI();
        String[] strings = s.split("/");
        System.out.println(strings[2]);
        System.out.println(s + " was in ad controller");
        if (ud.checkAdName(strings[2])) {
            Ads ads = ad.getAdByAdname(strings[2]);
            System.out.println(ads.getHeader() + " ads Header");
            req.setAttribute("ads", ads);
            req.setAttribute("ads1", "test string");
            req.getRequestDispatcher("/1.jsp").forward(req, resp);
        }
    }
}
