package domain;

public class Admin {
    private int id;
    private String admin_password;
    private String admin_name;
    public void setId(int id) {
        this.id = id;
    }
    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }
    public int getId() {
        return id;
    }
    public String getAdmin_password() {
        return admin_password;
    }
    public String getAdmin_name() {
        return admin_name;
    }

    public Admin(int id, String admin_password, String admin_name) {
        this.id = id;
        this.admin_password = admin_password;
        this.admin_name = admin_name;
    }

    public Admin(String admin_password, String admin_name) {
        this.admin_password = admin_password;
        this.admin_name = admin_name;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", admin_password='" + admin_password + '\'' +
                ", admin_name='" + admin_name + '\'' +
                '}';
    }

    public Admin() {
    }
}

