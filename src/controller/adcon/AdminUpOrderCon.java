package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Order;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import serverimp.OrderServerImp;
import util.InfoUtils;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AdminUpOrderCon implements Initializable {
    @FXML
    TextField cus_id;
    @FXML
    TextField shop_id;
    @FXML
    TextField staff_id;
    @FXML
    Label upLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(upLabel, FontAwesomeIcon.EDIT,"70px");
        Order order=(Order) Controller.primaryStage.getUserData();
        cus_id.setText(order.getCustom_id()+"");
        shop_id.setText(order.getShop_id()+"");
        staff_id.setText(order.getStaff_id()+"");
    }
    public void upOrder()
    {
        if (cus_id.getText().isEmpty()||shop_id.getText().isEmpty()||staff_id.getText().isEmpty())
        {
            InfoUtils.alertUtil("不能为空","", Alert.AlertType.WARNING);
        }else
        {
            Order oldOrder=(Order) Controller.primaryStage.getUserData();
            OrderServerImp orderServerImp=new OrderServerImp();
            Order order=new Order();
            order.setCustom_id(Integer.valueOf(cus_id.getText().trim()));
            order.setShop_id(Integer.valueOf(shop_id.getText().trim()));
            order.setStaff_id(Integer.valueOf(staff_id.getText().trim()));
            order.setCreate_time(LocalDateTime.now());
            order.setId(oldOrder.getId());
            int n=orderServerImp.updateOrder(order);
            if (n==1)
            {
                InfoUtils.alertUtil("修改成功","", Alert.AlertType.WARNING);

            }
            else
            {
                InfoUtils.alertUtil("修改失败","", Alert.AlertType.WARNING);
            }
        }


    }
}
