package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

public class ShoopTypeUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SplitPane splitPane = FXMLLoader.load(getClass().getResource("/fxml/ShopType.fxml"));
        stage.setTitle("CRM");

        Scene scene = new Scene(splitPane, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

}
