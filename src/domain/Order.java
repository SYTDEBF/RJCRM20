package domain;

import java.util.Date;

public class Order {
    private int id;
    private int custom_id;
    private int shop_id;
    private int staff_id;
    private Date create_time;
    public void setId(int id) {
        this.id = id;
    }
    public void setCustom_id(int custom_id) {
        this.custom_id = custom_id;
    }
    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public int getId() {
        return id;
    }
    public int getCustom_id() {
        return custom_id;
    }
    public int getShop_id() {
        return shop_id;
    }
    public int getStaff_id() {
        return staff_id;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public Order(int custom_id, int shop_id, int staff_id, Date create_time) {
        this.custom_id = custom_id;
        this.shop_id = shop_id;
        this.staff_id = staff_id;
        this.create_time = create_time;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", custom_id=" + custom_id +
                ", shop_id=" + shop_id +
                ", staff_id=" + staff_id +
                ", create_time=" + create_time +
                '}';
    }
}

