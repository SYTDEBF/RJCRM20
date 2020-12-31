package controller.stacon;

import controller.adcon.Controller;

import domain.Staff;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import serverimp.StaffServerImp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StaffInfoCon implements Initializable {
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
        StaffServerImp staffServerImp=new StaffServerImp();
        List<Staff> staff=staffServerImp.getStaffById((Integer)Controller.staRoot.getUserData());
        if (staff==null)
        {
            cus_id.setText("无信息");
        }else {
            cus_id.setText("编号:"+staff.get(0).getId()+"");
            cus_name.setText("姓名:"+staff.get(0).getStaff_name());
            cus_phone.setText("部门:"+staff.get(0).getStaff_depart());
            cus_address.setText("薪水:"+staff.get(0).getStaff_salary());
            cus_credit.setText("负责商品:"+staff.get(0).getStaff_shop_type()+"");
        }
    }
}
