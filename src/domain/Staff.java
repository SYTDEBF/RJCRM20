package domain;

public class Staff {
    private int id;
    private String staff_name;
    private String staff_depart;
    private String typename;
    private int staff_salary;
    public void setId(int id) {
        this.id = id;
    }
    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }
    public void setStaff_depart(String staff_depart) {
        this.staff_depart = staff_depart;
    }
    public void setStaff_shop_type(String staff_shop_type) {
        this.typename = staff_shop_type;
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
    public String getStaff_shop_type() {
        return typename;
    }
    public int getStaff_salary() {
        return staff_salary;
    }

    public Staff(String staff_name, String staff_depart, String staff_shop_type, int staff_salary) {
        this.staff_name = staff_name;
        this.staff_depart = staff_depart;
        this.typename= staff_shop_type;
        this.staff_salary = staff_salary;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_depart='" + staff_depart + '\'' +
                ", staff_shop_type='" + typename+ '\'' +
                ", staff_salary=" + staff_salary +
                '}';
    }
}
