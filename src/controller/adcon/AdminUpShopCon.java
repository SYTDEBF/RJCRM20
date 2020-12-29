package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Shop;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import serverimp.CustomServerImp;
import serverimp.ShopServerImp;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminUpShopCon implements Initializable {
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
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.EDIT,"70px");
        Shop shop=(Shop) Controller.primaryStage.getUserData();
        name.setText(shop.getShop_name());
        shop_date.setValue(shop.getShop_date());
        shop_type.setText(shop.getShop_type()+"");
        shop_pri.setText(shop.getShop_price()+"");

    }

    public void sendInfo() {
        if (name.getText().isEmpty() || shop_date.getValue()==null || shop_type.getText().isEmpty() || shop_pri.getText().isEmpty() ) {
            InfoUtils.alertUtil("所有信息不能为空!", "警示", Alert.AlertType.WARNING);
        } else {
            if (!(InfoUtils.isInteger(shop_type.getText()))) {
                InfoUtils.alertUtil("商品编号必须为数字!", "警示", Alert.AlertType.WARNING);
            } else {
                ShopServerImp shopServerImp=new ShopServerImp();
                Shop oldShop=(Shop) Controller.primaryStage.getUserData();
                Shop shop =new Shop(oldShop.getId(),name.getText().trim(),
                        shop_date.getValue(),Integer.valueOf(shop_type.getText().trim()),
                        Float.valueOf(shop_pri.getText().trim()));
                int n=shopServerImp.upShop(shop);
                if(n==1){
                    InfoUtils.alertUtil("更新成功!","提示",Alert.AlertType.INFORMATION);
                }else
                {
                    InfoUtils.alertUtil("更新失败!","警示",Alert.AlertType.ERROR);
                }
            }

        }
    }

}
