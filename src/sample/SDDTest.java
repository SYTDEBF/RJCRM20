package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SDDTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminAddUser.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene=new Scene(root, 600, 400);
        primaryStage.initStyle(StageStyle.UNIFIED);
        scene.getStylesheets().addAll(
                "org/kordamp/bootstrapfx/bootstrapfx.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
