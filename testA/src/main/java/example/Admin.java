package example;

/**
 * Created by Administrator on 2019/4/3.
 */
public class Admin {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasspord() {
        return passpord;
    }

    public void setPasspord(String passpord) {
        this.passpord = passpord;
    }

    private Integer id;
    private String username;
    private String passpord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String  toString(){
        return "admin:id="+id+";username="+username+";password="+passpord;
    }
}
