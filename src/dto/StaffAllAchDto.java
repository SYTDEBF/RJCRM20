package dto;

public class StaffAllAchDto {
    private int staff_id;
    private String staff_name;
    private float shop_price;

    public StaffAllAchDto(int staff_id, String staff_name, float shop_price) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.shop_price = shop_price;
    }

    public StaffAllAchDto() {
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public float getShop_price() {
        return shop_price;
    }

    public void setShop_price(float shop_price) {
        this.shop_price = shop_price;
    }

    @Override
    public String toString() {
        return "StaffAllAchDto{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", shop_price=" + shop_price +
                '}';
    }
}
