package ui.adminuser;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ui.MyDialog;

import java.io.IOException;

public class MyAdminAddShopCia extends MyDialog {
    @Override
    public Dialog creMYDia(Stage stage) {
        Dialog dialog=new Dialog();
        dialog.setTitle("添加商品");

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.getDialogPane().setStyle("-fx-background-color: white;");
        Pane borderPane = null;
        try {
            borderPane= FXMLLoader.load(getClass().getResource("/fxml/AdminAddShop.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().setContent(borderPane);
        dialog.initOwner(stage);

        return dialog;
    }
}
