package dao;

import dao.POJO.Contacts;
import dao.POJO.Groups;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by secret on 18.04.2017.
 */
public class ContactsDAO {

    public List<Contacts> getContacts() {

        List<Contacts> listCon = new ArrayList<Contacts>();
        String sql = "SELECT * FROM CONTACTS";
        Connection con = ConnectionSingleton.getInstance();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                listCon.add(new Contacts(rs.getInt("ID"),
                                   rs.getString("NAME")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCon;
    }
}
