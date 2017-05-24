package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by secret on 13.04.2017.
 */
public class UsersDAO {

    public boolean createUser(String email, String password, String adname) {

        String sql = "INSERT INTO USERS (EMAIL, PASSWORD, ADNAME) VALUES (?, ?, ?) ";
        Connection con = ConnectionSingleton.getInstance();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, adname);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error in create user!!!");
            return false;
        }
        return true;
    }

    public boolean checkAdName(String adname) {

        String sql = "select adname from users where adname = ?";
        Connection con = ConnectionSingleton.getInstance();


        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, adname);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return true;
            }
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String logMeIn(String email, String password) {

        String sql = "select adname from users where email = ? and password = ?";
        Connection con = ConnectionSingleton.getInstance();
        String adname = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                adname = rs.getString("adname");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adname;
    }

}
