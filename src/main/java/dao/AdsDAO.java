package dao;

import dao.POJO.Ads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by secret on 19.04.2017.
 */
public class AdsDAO {

    public boolean createAd(String adname, String header, String textField,
                            String conName1, String conName2, String con1, String con2) {

        String sql = "insert into ads (adname, header, textfield, con_1_id, con_2_id, " +
                "contact1, contact2) values (?, ?, ?," +    //adname, header, text
                " (select id from contacts where name = ?), " + //con name 1
                "(select id from contacts where name = ?), ?, ?); "; //con name 2, con1, con2

        Connection con = ConnectionSingleton.getInstance();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adname);
            ps.setString(2, header);
            ps.setString(3, textField);
            ps.setString(4, conName1);
            ps.setString(5, conName2);
            ps.setString(6, con1);
            ps.setString(7, con2);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * all same params
     * @param adname
     * @param header
     * @param textField
     * @param conName1
     * @param conName2
     * @param con1
     * @param con2
     */

    public void updateAd(String adname, String header, String textField,
                         String conName1, String conName2, String con1, String con2) {

        String sql = "update ads set header = ?, textfield = ?, " +
                "con_1_id = (select id from contacts where name = ?), " +
                "con_2_id = (select id from contacts where name = ?), " +
                    "contact1 = ?, contact2 = ? where adname = ?";
        Connection con = ConnectionSingleton.getInstance();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, header);
            ps.setString(2, textField);
            ps.setString(3, conName1);
            ps.setString(4, conName2);
            ps.setString(5, con1);
            ps.setString(6, con2);
            ps.setString(7, adname);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public boolean checkAd(String adname) {

        String sql = "select adname from ads where adname = ?";
        Connection con = ConnectionSingleton.getInstance();
        List<Ads> la = new ArrayList<Ads>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adname);
            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
            if (rs.next()) {
                System.out.println("check Ad return something!!!");
                return true;
            }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Ads getAdByAdname(String adname) {

        String sql = "select a.id, a.adname, a.header, a.textfield, " +
                "a.con_1_id, a.con_2_id, a.contact1, a.contact2, u.email, a.rating " +
                "from ads a, users u where a.adname = ? and a.adname = u.adname; ";
        Connection con = ConnectionSingleton.getInstance();
        Ads ads = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adname);
            ResultSet rs = ps.executeQuery();
            if (rs.next())

            ads = new Ads(rs.getInt("id"), rs.getString("adname"), rs.getString("header"),
                    rs.getString("textField"), rs.getInt("con_1_id"),
                    rs.getInt("con_2_id"), rs.getString("contact1"),
                    rs.getString("contact2"), rs.getString("email"), rs.getInt("rating"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ads;
    }

    /**
     *
     * @param header
     * @return List with selected ads
     */

    public List<Ads> searchByHeader(String header) {

        String sql = "select a.id, a.adname, a.header, a.textfield, " +
                "a.con_1_id, a.con_2_id, a.contact1, a.contact2, u.email, a.rating " +
                "from ads a, users u where header like ? and a.adname = u.adname";
        Connection con = ConnectionSingleton.getInstance();
        List<Ads> la = new ArrayList<Ads>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + header + "%");
            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
                while (rs.next()) {
                    la.add(new Ads(rs.getInt("id"), rs.getString("adname"), rs.getString("header"),
                            rs.getString("textField"), rs.getInt("con_1_id"),
                            rs.getInt("con_2_id"), rs.getString("contact1"),
                            rs.getString("contact2"), rs.getString("email"), rs.getInt("rating")));
                    System.out.println("was in AdsDAO while new Ads!");
                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return la;
    }

    /**
     *
     * @param adname - им€ объ€вы, у который повышаетс€ рейтинг на 1 пункт.
     */

    public void increaseRating(String adname) {

        String sql = "update ads set rating = " +
                     "((select rating from ads where adname = ?) + 1) " +
                     "where adname = ?";
        Connection con = ConnectionSingleton.getInstance();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adname);
            ps.setString(2, adname);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
