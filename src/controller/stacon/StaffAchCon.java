package controller.stacon;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import controller.adcon.Controller;
import dto.DataCouDto;
import dto.StaffAchievementDto;
import dto.StaffAllAchDto;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import serverimp.AdminStaSerImp;
import serverimp.StaffServerImp;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StaffAchCon implements Initializable {
    @FXML
    WebView web;

    @Override
    public void initialize(URL url1, ResourceBundle resourceBundle) {
        URL url = null;
        try {
            url = new File("res/html/css/StaffAchievement.html").toURI().toURL();
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
                StaffServerImp staffServerImp=new StaffServerImp();
                StaffAchievementDto achievementDto=staffServerImp.getStaffAchievementById((Integer) Controller.staRoot.getUserData());
                if (achievementDto!=null)
                {
                    webEngine.executeScript("getAchData("+achievementDto.getStaffOrderCon()+","+achievementDto.getStaffSalesVolume()+");");

                }
                else
                {
                    webEngine.executeScript("getAchData("+0+","+0+");");
                }
                List<StaffAllAchDto> achCons=staffServerImp.getStaffAllAch();
                if(achCons.size()!=0)
                {

                    JSONArray jsonArray = new JSONArray();
                    for (int i = 0; i < achCons.size(); i++) {
                        JSONObject jsonObject=new JSONObject();
                        jsonObject.put("staff_id",achCons.get(i).getStaff_id());
                        jsonObject.put("staff_name",achCons.get(i).getStaff_name());
                        jsonObject.put("shop_price",achCons.get(i).getShop_price());

                        jsonArray.add(jsonObject);
                    }
                    webEngine.executeScript("getStaffAllAch("+jsonArray.toJSONString()+")");
                }
            }
        });
    }
}
