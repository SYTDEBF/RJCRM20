package dto;

import java.time.LocalDate;
import java.util.Date;

public class ShopDto {
    private int id;
    private String shop_name;
    private LocalDate shop_date;
    private String shop_type;
    private float shop_price;
    public void setId(int id) {
        this.id = id;
    }
    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    @Override
    public String toString() {
        return
                "编号:" + id +
                        "商品名称:" + shop_name;


    }




    public void setShop_price(float shop_price) {
        this.shop_price = shop_price;
    }
    public int getId() {
        return id;
    }
    public String getShop_name() {
        return shop_name;
    }

    public ShopDto(int id, String shop_name, LocalDate shop_date, String shop_type, float shop_price) {
        this.id = id;
        this.shop_name = shop_name;
        this.shop_date = shop_date;
        this.shop_type = shop_type;
        this.shop_price = shop_price;
    }

    public LocalDate getShop_date() {
        return shop_date;
    }

    public void setShop_date(LocalDate shop_date) {
        this.shop_date = shop_date;
    }

    public ShopDto() {
    }

    public String getShop_type() {
        return shop_type;
    }
    public double getShop_price() {
        return shop_price;
    }

}
