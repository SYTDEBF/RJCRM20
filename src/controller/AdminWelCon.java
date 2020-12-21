package controller;

import com.alibaba.fastjson.JSONObject;
import dto.DataCouDto;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import server.AdminStaSer;
import serverimp.AdminStaSerImp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminWelCon implements Initializable {
    @FXML
    WebView web;

    @Override
    public void initialize(URL url1, ResourceBundle resourceBundle) {

        URL url = null;
        try {
            url = new File("res/html/css/adminwel.html").toURI().toURL();
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
                List<DataCouDto> dataCouDtos;
                DataCouDto cusDataCou = new DataCouDto();
                DataCouDto staffDataCou = new DataCouDto();
                DataCouDto orderDataCou = new DataCouDto();
                DataCouDto shopDataCou = new DataCouDto();
                DataCouDto shopTypeCou = new DataCouDto();
                try {
                    AdminStaSerImp adminStaSer=new AdminStaSerImp();
                    dataCouDtos =adminStaSer.getAllCou();
                    cusDataCou=dataCouDtos.get(0);
                    staffDataCou=dataCouDtos.get(1);
                    orderDataCou=dataCouDtos.get(2);
                    shopDataCou=dataCouDtos.get(3);
                    shopTypeCou=dataCouDtos.get(4);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                webEngine.executeScript("getCusCou("+cusDataCou.getCon() +");");
                webEngine.executeScript("getStaffCou("+ staffDataCou.getCon() +");");
                webEngine.executeScript("getOrderCou("+ orderDataCou.getCon() +");");
                webEngine.executeScript("getShopCou("+ shopDataCou.getCon() +");");
                webEngine.executeScript("getShopTypeCou("+ shopTypeCou.getCon() +");");
            }
        });
    }
}
