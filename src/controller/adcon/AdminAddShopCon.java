package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Shop;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import serverimp.ShopServerImp;
import util.InfoUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAddShopCon implements Initializable {
    @FXML
    Label addLabel;
    @FXML
    TextField name;
    @FXML
    DatePicker shop_date;
    @FXML
    TextField shop_type;
    @FXML
    TextField shop_pri;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.USER_PLUS,"70px");
    }

    public void sendInfo(){
        if (name.getText().isEmpty()|| shop_date.getValue()==null|| shop_type.getText().isEmpty()|| shop_pri.getText().isEmpty())
        {
            InfoUtils.alertUtil("所有信息不能为空!","警示", Alert.AlertType.WARNING);
        }else
        {
            if(InfoUtils.isInteger(shop_type.getText()))
            {
                ShopServerImp shopServerImp=new ShopServerImp();
                Shop shop=new Shop();
                shop.setShop_type(Integer.valueOf(shop_type.getText().trim()));
                shop.setShop_date(shop_date.getValue());
                shop.setShop_name(name.getText().trim());
                shop.setShop_price(Float.valueOf(shop_pri.getText().trim()));
                int n=shopServerImp.addShop(shop);
                if(n==1)
                {
                    InfoUtils.alertUtil("添加成功!","警示", Alert.AlertType.WARNING);
                }
                else
                {
                    InfoUtils.alertUtil("添加失败!","警示", Alert.AlertType.WARNING);
                }
            }
            else
            {
                InfoUtils.alertUtil("商品编号必须为数字!","警示", Alert.AlertType.WARNING);
            }
        }

    }
}
