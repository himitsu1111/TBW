package dao.POJO;

/**
 * Created by secret on 19.04.2017.
 */
public class Ads {

    private long id;
    private String adname;
    private String header;
    private String textField;
    private int con_1_id;
    private int con_2_id;
    private String con1;
    private String con2;
    private String email;
    private int rating;

    public Ads(long id, String adname,
               String header, String textField,
               int con_1_id, int con_2_id, String con1,
               String con2, String email, int rating) {
        this.id = id;
        this.adname = adname;
        this.header = header;
        this.textField = textField;
        this.con_1_id = con_1_id;
        this.con_2_id = con_2_id;
        this.con1 = con1;
        this.con2 = con2;
        this.email = email;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public int getCon_1_id() {
        return con_1_id;
    }

    public void setCon_1_id(int con_1_id) {
        this.con_1_id = con_1_id;
    }

    public int getCon_2_id() {
        return con_2_id;
    }

    public void setCon_2_id(int con_2_id) {
        this.con_2_id = con_2_id;
    }

    public String getCon1() {
        return con1;
    }

    public void setCon1(String con1) {
        this.con1 = con1;
    }

    public String getCon2() {
        return con2;
    }

    public void setCon2(String con2) {
        this.con2 = con2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

