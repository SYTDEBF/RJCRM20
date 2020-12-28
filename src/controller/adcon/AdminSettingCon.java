package controller.adcon;

import de.jensd.fx.glyphs.GlyphIcons;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.InfoUtils;
import util.MyConfigUpUtil;
import util.MySqlConUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminSettingCon implements Initializable {
    @FXML
    Label settingIcon;
    @FXML
    Label dataBaseIcon;
    @FXML
    TextField dbName;
    @FXML
    TextField dbUserName;
    @FXML
    TextField dbPassword;
    @FXML
    TextField dbUrl;
    @FXML
    Button testBut;
    @FXML
    Button saveBut;
    @FXML
    Label conRe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(settingIcon, FontAwesomeIcon.COG, "30px");
        GlyphsDude.setIcon(dataBaseIcon, FontAwesomeIcon.DATABASE, "17px");
    }

    public void mySqlTestCon() {
        if (dbName.getText().isEmpty() || dbPassword.getText().isEmpty() || dbUserName.getText().isEmpty()) {
            InfoUtils.alertUtil("不能为空", "", Alert.AlertType.WARNING);
        } else {
            MySqlConUtil.mySqlCon(dbUserName.getText().trim(), dbPassword.getText().trim(), dbName.getText().trim());
            if (MySqlConUtil.re.equals("1")) {
                conRe.setStyle("-fx-text-fill:#42de16");
                conRe.setText("连接成功 " + "数据库:" + MySqlConUtil.message);
            }else
            {
                conRe.setStyle("-fx-text-fill:#ec270c");
                conRe.setText("连接失败 " + "原因:" + MySqlConUtil.message);
            }
        }
    }
    public void saveMysqlSet()
    {
        if (dbName.getText().isEmpty() || dbPassword.getText().isEmpty() || dbUserName.getText().isEmpty()) {
            InfoUtils.alertUtil("不能为空", "", Alert.AlertType.WARNING);
        }else
        {
            String url="jdbc:mysql://localhost:3306/"+dbName.getText().trim()+"?characterEncoding=utf8&allowMultiQueries=true&serverTimezone=CST";
            MyConfigUpUtil.upMyConfig(dbUserName.getText().trim(),dbPassword.getText().trim(),url);
            if (MyConfigUpUtil.re.equals("1")) {
                conRe.setStyle("-fx-text-fill:#42de16");
                conRe.setText(MyConfigUpUtil.message);
            }else
            {
                conRe.setStyle("-fx-text-fill:#ec270c");
                conRe.setText(MyConfigUpUtil.message);
            }
        }

    }
}
