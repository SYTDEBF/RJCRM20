package controller.cuscon;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dto.ShopDto;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import serverimp.ShopServerImp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CustomShopCon implements Initializable {
    @FXML
    WebView web;

    @Override
    public void initialize(URL url1, ResourceBundle resourceBundle) {

        URL url = null;
        try {
            url = new File("res/html/css/Shop.html").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        final WebEngine webEngine = web.getEngine();

        System.out.println(url.toString());
        URL finalUrl = url;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                webEngine.load(finalUrl.toString());
            }
        });
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {

            if (Worker.State.SUCCEEDED == newValue) {
                ShopServerImp shopServerImp=new ShopServerImp();
                List<ShopDto> shopDtos=shopServerImp.getAllShop();
                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < shopDtos.size(); i++) {
                    JSONObject jsonObject=new JSONObject();
                    jsonObject.put("id",shopDtos.get(i).getId());
                    jsonObject.put("shop_name",shopDtos.get(i).getShop_name());
                    jsonObject.put("shop_pri",shopDtos.get(i).getShop_price());
                    jsonObject.put("shop_date",shopDtos.get(i).getShop_date());
                    jsonObject.put("typename",shopDtos.get(i).getShop_type());
                    jsonArray.add(jsonObject);
                }

                System.out.println("debug"+jsonArray.toJSONString());
                webEngine.executeScript("showShop("+jsonArray.toJSONString()+");");
            }
        });
    }
}
