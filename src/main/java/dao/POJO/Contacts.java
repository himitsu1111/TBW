package dao.POJO;

/**
 * Created by secret on 18.04.2017.
 */
public class Contacts {

    private int id;
    private String name;

    public Contacts(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
