package domain;

public class Custom {
    private Integer id;
    private String custom_name;
    private String custom_phone;
    private String custom_address;
    private int custom_credit;
    private String custom_password;

    public String getCustom_password() {
        return custom_password;
    }

    public void setCustom_password(String custom_password) {
        this.custom_password = custom_password;
    }

    public Custom(String custom_name,String custom_password, String custom_phone, String custom_address,int custom_credit) {
        this.custom_name = custom_name;
        this.custom_phone = custom_phone;
        this.custom_address = custom_address;
        this.custom_credit = custom_credit;
        this.custom_password = custom_password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }
    public void setCustom_phone(String custom_phone) {
        this.custom_phone = custom_phone;
    }
    public void setCustom_address(String custom_address) {
        this.custom_address = custom_address;
    }
    public void setCustom_credit(int custom_credit) {
        this.custom_credit = custom_credit;
    }
    public Integer getId() {
        return id;
    }
    public String getCustom_name() {
        return custom_name;
    }
    public String getCustom_phone() {
        return custom_phone;
    }
    public String getCustom_address() {
        return custom_address;
    }
    public int getCustom_credit() {
        return custom_credit;
    }

    public Custom(){

    }

    public Custom(Integer id, String custom_name, String custom_phone, String custom_address, int custom_credit, String custom_password) {
        this.id = id;
        this.custom_name = custom_name;
        this.custom_phone = custom_phone;
        this.custom_address = custom_address;
        this.custom_credit = custom_credit;
        this.custom_password = custom_password;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "id=" + id +
                ", custom_name='" + custom_name + '\'' +
                ", custom_phone='" + custom_phone + '\'' +
                ", custom_address='" + custom_address + '\'' +
                ", custom_credit=" + custom_credit +
                ", custom_password='" + custom_password + '\'' +
                '}';
    }
}
