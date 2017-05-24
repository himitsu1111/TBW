package dao;

import dao.POJO.Groups;
import dao.POJO.Iptable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by secret on 11.04.2017.
 */
public class IptableDAO {

    public void addIp(String ip) {

        String sql = "INSERT INTO IPTABLE (IP) VALUES (?) ";
        Connection con = ConnectionSingleton.getInstance();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ip);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Iptable> getAllIp() {

        List<Iptable> listIp = new ArrayList<Iptable>();
        String sql = "SELECT * FROM IPTABLE";
        Connection con = ConnectionSingleton.getInstance();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                listIp.add(new Iptable(rs.getInt("ID"),
                        rs.getString("IP"),
                        rs.getDate("DATE")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listIp;
    }
}
