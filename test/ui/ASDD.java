package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ASDD extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        WebView webView=new WebView();
        final WebEngine webEngine=webView.getEngine();
        webEngine.load("https://www.bilibili.com/");
        Scene scene=new Scene(webView,1100,700);
        stage.setScene(scene);
        stage.show();
    }
}
