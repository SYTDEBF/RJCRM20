package dto;

public class OrderDto {
    private Integer id;
    private String  custom_name;
    private String shop_name;
    private String typename;
    private float shop_price;
    private String staff_name;
    private String staff_depart;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public float getShop_price() {
        return shop_price;
    }

    public void setShop_price(float shop_price) {
        this.shop_price = shop_price;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_depart() {
        return staff_depart;
    }

    public OrderDto(Integer id, String custom_name, String shop_name, String typename, float shop_price, String staff_name, String staff_depart) {
        this.id = id;
        this.custom_name = custom_name;
        this.shop_name = shop_name;
        this.typename = typename;
        this.shop_price = shop_price;
        this.staff_name = staff_name;
        this.staff_depart = staff_depart;
    }

    public void setStaff_depart(String staff_depart) {
        this.staff_depart = staff_depart;
    }

    public OrderDto() {
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", custom_name='" + custom_name + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", typename='" + typename + '\'' +
                ", shop_price=" + shop_price +
                ", staff_name='" + staff_name + '\'' +
                ", staff_depart='" + staff_depart + '\'' +
                '}';
    }
}
