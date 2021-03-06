package ui.adorder;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.MyDialog;

import java.io.IOException;

public class MyAdOrderDia extends MyDialog {
    @Override
    public Dialog creMYDia(Stage stage) {
        Dialog dialog=new Dialog();
        dialog.setTitle("添加订单");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.getDialogPane().setStyle("-fx-background-color: white;");
        BorderPane borderPane = null;
        try {
            borderPane= FXMLLoader.load(getClass().getResource("/fxml/AdAddOrder.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().setContent(borderPane);
        dialog.initOwner(stage);
        dialog.initStyle(StageStyle.UNIFIED);
        return dialog;
    }
}
