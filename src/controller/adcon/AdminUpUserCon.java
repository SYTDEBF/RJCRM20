package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import serverimp.CustomServerImp;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminUpUserCon implements Initializable {
    @FXML
    Label addLabel;
    @FXML
    TextField name;
    @FXML
    PasswordField password;
    @FXML
    TextField phone;
    @FXML
    TextField address;
    @FXML
    TextField credit;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.EDIT,"70px");
        Custom custom=(Custom) Controller.primaryStage.getUserData();
        name.setText(custom.getCustom_name());
        password.setText(custom.getCustom_password());
        phone.setText(custom.getCustom_phone());
        address.setText(custom.getCustom_address());
        credit.setText(String.valueOf(custom.getCustom_credit()));
    }

    public void sendInfo() {
        if (name.getText().isEmpty() || password.getText().isEmpty() || phone.getText().isEmpty() || address.getText().isEmpty() || credit.getText().isEmpty()) {
            InfoUtils.alertUtil("所有信息不能为空!", "警示", Alert.AlertType.WARNING);
        } else {
            if (!(InfoUtils.isInteger(credit.getText())) || credit.getText().length() > 4) {
                InfoUtils.alertUtil("信用值必须为数字!", "警示", Alert.AlertType.WARNING);
            } else if (!(InfoUtils.isPhone(phone.getText()))) {
                InfoUtils.alertUtil("电话号码格式不正确!", "提示", Alert.AlertType.INFORMATION);
            } else {
                try {
                    CustomServerImp customServerImp=new CustomServerImp();
                    Custom oldCus=(Custom) Controller.primaryStage.getUserData();
                    Custom custom =new Custom(oldCus.getId(),name.getText().trim(),
                            phone.getText().trim(),
                            address.getText().trim(),
                            Integer.valueOf(credit.getText().trim()),
                            password.getText().trim());
                    int n=customServerImp.updateCustom(custom);
                    if(n==1){
                        InfoUtils.alertUtil("更新成功!","提示",Alert.AlertType.INFORMATION);
                    }else
                    {
                        InfoUtils.alertUtil("更新失败!","警示",Alert.AlertType.ERROR);
                    }
                } catch (IOException e) {

                }
            }

        }
    }

    static void ya(TextField name, PasswordField password, TextField phone, TextField address, TextField credit) {
        if (name.getText().isEmpty()|| password.getText().isEmpty()|| phone.getText().isEmpty()|| address.getText().isEmpty()|| credit.getText().isEmpty())
        {
            InfoUtils.alertUtil("所有信息不能为空!","警示", Alert.AlertType.WARNING);
        }
        else {
            if(!(InfoUtils.isInteger(credit.getText()))|| credit.getText().length()>4)
            {
                InfoUtils.alertUtil("信用值必须为数字!","警示",Alert.AlertType.WARNING);
            }else if (!(InfoUtils.isPhone(phone.getText())))
            {
                InfoUtils.alertUtil("电话号码格式不正确!","提示",Alert.AlertType.INFORMATION);
            }else {
                try {
                    CustomServerImp customServerImp=new CustomServerImp();
                    Custom custom =new Custom(name.getText(), password.getText(), phone.getText(), address.getText(),Integer.valueOf(credit.getText()));
                    int n=customServerImp.insertCustom(custom);
                    if(n==1){
                        InfoUtils.alertUtil("添加成功!","提示",Alert.AlertType.INFORMATION);
                    }
                } catch (IOException e) {
                    InfoUtils.alertUtil("添加失败!","警示",Alert.AlertType.ERROR);
                }

            }


        }
    }

}
