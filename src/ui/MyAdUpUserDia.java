package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MyAdUpUserDia extends MyDialog{
    @Override
    public Dialog creMYDia(Stage stage) {
        Dialog dialog=new Dialog();
        dialog.setTitle("修改用户");

        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        dialog.getDialogPane().setStyle("-fx-background-color: white;");
        Pane borderPane = null;
        try {
           borderPane= FXMLLoader.load(getClass().getResource("/fxml/AdminUpUser.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().setContent(borderPane);
        dialog.initOwner(stage);
        dialog.initStyle(StageStyle.UNIFIED);
        return dialog;
    }
}
