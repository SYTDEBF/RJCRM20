package controller;

import domian.Admin;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sample.ADminUiTest;
import serverimp.AdminServerImp;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    static Stage primaryStage = new Stage();
    public void initialize() {
        Font font=new Font("STSong",24);
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("CRM");
            primaryStage.initStyle(StageStyle.UNIFIED);
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