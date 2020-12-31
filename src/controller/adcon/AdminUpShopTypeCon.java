package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.ShopType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import serverimp.ShopTypeServerImp;
import util.InfoUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminUpShopTypeCon implements Initializable {
    @FXML
    TextField typename;
    @FXML
    Label upLabel;
    ShopType shopType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(upLabel, FontAwesomeIcon.EDIT,"70px");
        shopType=(ShopType) Controller.primaryStage.getUserData();
        typename.setText(shopType.getTypename());
    }
    public void sendInfo()
    {
        if (typename.getText().isEmpty())
        {
            InfoUtils.alertUtil("不能为空","", Alert.AlertType.WARNING);
        }else
        {
            ShopTypeServerImp shopTypeServerImp=new ShopTypeServerImp();
            ShopType newShopType=new ShopType();
            newShopType.setId(shopType.getId());
            newShopType.setTypename(typename.getText().trim());
            int n=shopTypeServerImp.upShopTypeOnlyTypeName(newShopType);
            if (n==1)
            {
                InfoUtils.alertUtil("修改成功","", Alert.AlertType.INFORMATION);
            }else
            {
                InfoUtils.alertUtil("修改失败","", Alert.AlertType.INFORMATION);
            }
        }
    }
}
