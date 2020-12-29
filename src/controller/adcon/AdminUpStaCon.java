package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Staff;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import serverimp.CustomServerImp;
import serverimp.StaffServerImp;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminUpStaCon implements Initializable {
    @FXML
    Label addLabel;
    @FXML
    TextField name;
    @FXML
    TextField password;
    @FXML
    TextField salary;
    @FXML
    TextField typename;
    @FXML
    TextField depart;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.EDIT,"70px");
        Staff staff =(Staff) Controller.primaryStage.getUserData();
        name.setText(staff.getStaff_name());
        password.setText(staff.getStaff_password());
        salary.setText(staff.getStaff_salary()+"");
        typename.setText(staff.getStaff_shop_type()+"");
        depart.setText(staff.getStaff_depart());
    }

    public void sendInfo() {
        if (name.getText().isEmpty() || password.getText().isEmpty() || salary.getText().isEmpty() || typename.getText().isEmpty() || depart.getText().isEmpty()) {
            InfoUtils.alertUtil("所有信息不能为空!", "警示", Alert.AlertType.WARNING);
        } else {
            if (InfoUtils.isInteger(typename.getText())) {

                StaffServerImp staffServerImp=new StaffServerImp();
                Staff oldSta=(Staff) Controller.primaryStage.getUserData();
                Staff staff =new Staff(oldSta.getId(),name.getText().trim(),
                        depart.getText().trim(),
                        Integer.valueOf(typename.getText().trim()),
                        Integer.valueOf(salary.getText().trim()),
                        password.getText().trim());
                int n=staffServerImp.upStaff(staff);
                if(n==1)
                {
                    InfoUtils.alertUtil("修改成功!","提示",Alert.AlertType.INFORMATION);
                }
                else
                {
                    InfoUtils.alertUtil("修改失败!","警示",Alert.AlertType.ERROR);
                }
            }else
            {
                InfoUtils.alertUtil("商品编号必须为数字!", "警示", Alert.AlertType.WARNING);
            }

        }
    }


}
