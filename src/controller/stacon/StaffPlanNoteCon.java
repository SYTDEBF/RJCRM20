package controller.stacon;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import controller.adcon.Controller;
import domain.Plan;
import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import server.StaffServer;
import serverimp.PlanServerImp;
import serverimp.StaffServerImp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StaffPlanNoteCon implements Initializable {
   @FXML
   WebView web;
   @Override
   public void initialize(URL url1, ResourceBundle resourceBundle) {
      URL url = null;
      try {
         url = new File("res/html/css/Plan.html").toURI().toURL();
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
            PlanServerImp planServerImp=new PlanServerImp();
            List<Plan> plans=planServerImp.getPlanByStaId((Integer) Controller.staRoot.getUserData());
            JSONArray jsonArray = new JSONArray();
            for (int i = 0; i < plans.size(); i++) {
               JSONObject jsonObject=new JSONObject();
               jsonObject.put("id",plans.get(i).getId());
               jsonObject.put("plan_profit",plans.get(i).getPlan_profit());
               jsonObject.put("plan_time",plans.get(i).getPlan_time());
               jsonObject.put("plan_stand",plans.get(i).getPlan_stand());
               jsonObject.put("plan_mark",plans.get(i).getPlan_mark());
               jsonArray.add(jsonObject);
            }
            webEngine.executeScript("showPlan("+jsonArray.toJSONString()+");");
         }
      });
   }
}
