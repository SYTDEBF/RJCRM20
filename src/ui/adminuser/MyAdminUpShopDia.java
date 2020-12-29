package ui.adminuser;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.MyDialog;

import java.io.IOException;

public class MyAdminUpShopDia extends MyDialog {
    @Override
    public Dialog creMYDia(Stage stage) {
        Dialog dialog=new Dialog();
        dialog.setTitle("修改商品信息");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.getDialogPane().setStyle("-fx-background-color: white;");
        BorderPane borderPane = null;
        try {
            borderPane= FXMLLoader.load(getClass().getResource("/fxml/AdminUpShop.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().setContent(borderPane);
        dialog.initOwner(stage);
        return dialog;
    }
}
