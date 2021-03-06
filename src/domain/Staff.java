package domain;

public class Staff {
    private int id;
    private String staff_name;
    private String staff_depart;
    private int staff_shop_type;
    private int staff_salary;
    private String staff_password;

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }
    public void setStaff_depart(String staff_depart) {
        this.staff_depart = staff_depart;
    }

    public Staff(int id, String staff_name, String staff_depart, int staff_shop_type, int staff_salary, String staff_password) {
        this.id = id;
        this.staff_name = staff_name;
        this.staff_depart = staff_depart;
        this.staff_shop_type = staff_shop_type;
        this.staff_salary = staff_salary;
        this.staff_password = staff_password;
    }

    public int getStaff_shop_type() {
        return staff_shop_type;
    }

    public void setStaff_shop_type(int staff_shop_type) {
        this.staff_shop_type = staff_shop_type;
    }

    public void setStaff_salary(int staff_salary) {
        this.staff_salary = staff_salary;
    }
    public int getId() {
        return id;
    }
    public String getStaff_name() {
        return staff_name;
    }
    public String getStaff_depart() {
        return staff_depart;
    }

    public int getStaff_salary() {
        return staff_salary;
    }



    public Staff() {
    }

    @Override
    public String toString() {
        return
                "编号:" + id +
                " 员工姓名:" + staff_name;

    }
}
