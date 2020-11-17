package controller;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domian.Custom;
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

public class AdminAddUserCon implements Initializable {
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
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.USER_PLUS,"70px");
    }

    public void sendInfo(){
        AdminUpUserCon.ya(name, password, phone, address, credit);

    }
}
