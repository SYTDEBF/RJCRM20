import com.alibaba.fastjson.JSONObject;
import domain.ShopType;
import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import serverimp.ShopTypeServerImp;
import util.TreeObjectUtils;

import java.io.File;
import java.net.URL;
import java.util.List;

public class Sdd extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ShopTypeServerImp customServerImp=new ShopTypeServerImp();
        List<ShopType> shopTypes=customServerImp.findAll();
        TreeObjectUtils<ShopType> shopTypeTreeObjectUtils=new TreeObjectUtils<>();
        List<ShopType> ass=shopTypeTreeObjectUtils.get1(shopTypes);
        URL url = new File("res/html/css/test.html").toURI().toURL();
        WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED == newValue) {
                webEngine.executeScript("shopTypeTree("+ JSONObject.parse(ass.toString()).toString()+");");
            }
        });
        System.out.println(url.toString());
        webEngine.load(url.toString());
        Scene scene = new Scene(webView, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }
}
