package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ADminUiTest extends Application {
    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminUI.fxml"));
        primaryStage.setTitle("CRM");
        primaryStage.initStyle(StageStyle.UNIFIED);
        Scene scene=new Scene(root);
        scene.getStylesheets().addAll(
                "org/kordamp/bootstrapfx/bootstrapfx.css");
        ADminUiTest.stage=primaryStage;
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
