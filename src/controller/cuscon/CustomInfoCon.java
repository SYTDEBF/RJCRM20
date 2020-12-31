package controller.cuscon;

import controller.adcon.Controller;
import domain.Custom;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import serverimp.CustomServerImp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomInfoCon implements Initializable {
    @FXML
    Label cus_id;
    @FXML
    Label cus_name;
    @FXML
    Label cus_phone;
    @FXML
    Label cus_address;
    @FXML
    Label cus_credit;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            CustomServerImp serverImp=new CustomServerImp();
            Custom custom=serverImp.getCustomById((Integer)Controller.cusRoot.getUserData());
            if (custom==null)
            {
                cus_id.setText("无信息");
            }else {
                cus_id.setText("编号:"+custom.getId()+"");
                cus_name.setText("姓名:"+custom.getCustom_name());
                cus_phone.setText("联系方式:"+custom.getCustom_phone());
                cus_address.setText("地址:"+custom.getCustom_address());
                cus_credit.setText("信用值:"+custom.getCustom_credit()+"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
