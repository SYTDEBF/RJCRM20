package controller.adcon;

import domain.Admin;
import domain.Custom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;
import serverimp.AdminServerImp;
import serverimp.CustomServerImp;
import controller.cuscon.CrmCookies;
import util.InfoUtils;

import java.io.IOException;

public class Controller  {
    @FXML
    SplitMenuButton sf;
    @FXML
    Label sfLabel;
    @FXML
    Label cLabel;

    @FXML
    TextField name;

    @FXML
    TextField password;

    public static Stage primaryStage = new Stage();
    public static Parent cusRoot=new Panel();
    public void initialize() {
        Font font=Font.font("MicrosoftYaHei", FontWeight.BOLD, FontPosture.REGULAR,24);
        cLabel.setFont(font);


    }
    public void  adSF(){
        sfLabel.setText("您即将以管理员身份登陆");
        sf.setText("管理员");
    }
    public void  userSF(){
        sfLabel.setText("您即将以用户身份登陆");
        sf.setText("用户");
    }
    public void  satffSF(){
        sfLabel.setText("您即将以员工身份登陆");
        sf.setText("员工");
    }
    public void login()
    {
        if(sf.getText().equals("管理员"))
        {
            AdminServerImp adminServerImp= null;
            try {
                adminServerImp = new AdminServerImp();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Admin admin;
            admin=adminServerImp.findByNameAndPass(name.getText().trim(),password.getText().trim());

            if (admin!=null) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/fxml/AdminUI.fxml"));
                    root.setStyle("-fx-font-family:'微软雅黑';");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("CRM");

                Scene scene = new Scene(root);
                scene.getStylesheets().addAll(
                        "org/kordamp/bootstrapfx/bootstrapfx.css");

                primaryStage.setScene(scene);
                primaryStage.show();
            }else
            {
                InfoUtils.alertUtil("用户名和密码错误","提示", Alert.AlertType.WARNING);
            }
        }
        if(sf.getText().equals("用户"))
        {
            CustomServerImp customServerImp = null;
            try {
                customServerImp = new CustomServerImp();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Custom custom;
            custom=customServerImp.getCustomByIdAndPassword(Integer.valueOf(name.getText().trim()),password.getText().trim());
            Parent root = null;
            if (custom!=null) {
                try {
                    cusRoot.setUserData(custom.getId());
                    root = FXMLLoader.load(getClass().getResource("/fxml/CustomUI.fxml"));
                    root.setStyle("-fx-font-family:'微软雅黑';");

                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("CRM");

                Scene scene = new Scene(root);
                scene.getStylesheets().addAll(
                        "org/kordamp/bootstrapfx/bootstrapfx.css");

                primaryStage.setScene(scene);
                primaryStage.show();
            }else
            {
                InfoUtils.alertUtil("用户名和密码错误","提示", Alert.AlertType.WARNING);
            }
        }

    }

}