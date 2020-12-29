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

public class AdminAddStaCon implements Initializable {
    @FXML
    Label addLabel;
    @FXML
    TextField name;
    @FXML
    TextField depart;
    @FXML
    TextField typename;
    @FXML
    TextField salary;
    @FXML
    TextField password;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.USER_PLUS,"70px");
    }

    public void sendInfo(){
        if (name.getText().isEmpty()|| password.getText().isEmpty()|| depart.getText().isEmpty()|| salary.getText().isEmpty()|| typename.getText().isEmpty())
        {
            InfoUtils.alertUtil("所有信息不能为空!","警示", Alert.AlertType.WARNING);
        }
        else {
            if (InfoUtils.isInteger(typename.getText()))
            {
                StaffServerImp staffServerImp=new StaffServerImp();
                Staff staff=new Staff();
                staff.setStaff_password(password.getText().trim());
                staff.setStaff_shop_type(Integer.valueOf(typename.getText().trim()));
                staff.setStaff_depart(depart.getText().trim());
                staff.setStaff_salary(Integer.valueOf(salary.getText().trim()));
                staff.setStaff_name(name.getText().trim());
                int n=staffServerImp.addStaff(staff);
                if(n==1){
                    InfoUtils.alertUtil("添加成功!","提示",Alert.AlertType.INFORMATION);
                }else {
                    InfoUtils.alertUtil("添加失败!","提示",Alert.AlertType.ERROR);
                }
            }else {
                InfoUtils.alertUtil("商品编号必须为数字!","警示", Alert.AlertType.WARNING);
            }


        }


        }
    }



