package dto;

public class StaffDto {
    private int id;
    private String staff_name;
    private String staff_depart;
    private String  typename;
    private int staff_salary;
    private String staff_password;

    public String getStaff_password() {
        return staff_password;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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

    public StaffDto(int id, String staff_name, String staff_depart, String typename, int staff_salary, String staff_password) {
        this.id = id;
        this.staff_name = staff_name;
        this.staff_depart = staff_depart;
        this.typename = typename;
        this.staff_salary = staff_salary;
        this.staff_password = staff_password;
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



    public StaffDto() {
    }

    @Override
    public String toString() {
        return
                "编号:" + id +
                        " 员工姓名:" + staff_name;

    }
}
