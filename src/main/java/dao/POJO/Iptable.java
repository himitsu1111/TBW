package dao.POJO;

import java.sql.Date;

/**
 * Created by secret on 11.04.2017.
 */
public class Iptable {

    private long id;
    private String ip;
    private Date date;

    public Iptable(long id, String ip, Date date) {
        this.id = id;
        this.ip = ip;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
