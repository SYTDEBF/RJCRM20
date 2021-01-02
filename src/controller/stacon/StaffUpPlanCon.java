package controller.stacon;

import controller.adcon.Controller;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Plan;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import serverimp.PlanServerImp;
import util.InfoUtils;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class StaffUpPlanCon implements Initializable {
   @FXML
   Label addLabel;
   @FXML
   TextField plan_profit;
   @FXML
   TextArea plan_stand;
   @FXML
   RadioButton yes_rad;
   @FXML
   RadioButton no_rad;
   ToggleGroup group = new ToggleGroup();
   String plan_markStr="";
   Plan plan=(Plan) Controller.primaryStage.getUserData();
   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      GlyphsDude.setIcon(addLabel, FontAwesomeIcon.EDIT, "70px");
      yes_rad.setToggleGroup(group);
      no_rad.setToggleGroup(group);
      no_rad.setUserData("no");
      yes_rad.setUserData("yes");
      group.selectedToggleProperty().addListener(
              (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
                 if (group.getSelectedToggle() != null) {
                    plan_markStr=group.getSelectedToggle().getUserData().toString();
                 }
              }
      );

      plan_profit.setText(plan.getPlan_profit()+"");
      plan_stand.setText(plan.getPlan_stand());
      if(plan.getPlan_mark()==0)
      {
         yes_rad.setSelected(false);
         no_rad.setSelected(true);
      }else
      {
         yes_rad.setSelected(true);
         no_rad.setSelected(false);
      }

   }
   public void sendInfo() {
      if (plan_profit.getText().isEmpty()  || plan_stand.getText().isEmpty() || plan_markStr == null) {
         InfoUtils.alertUtil("所有信息不能为空!", "警示", Alert.AlertType.WARNING);
      } else {
         if (InfoUtils.isInteger(plan_profit.getText())) {
            PlanServerImp planServerImp = new PlanServerImp();
            Plan insertPlan = new Plan();
            insertPlan.setPlan_profit(Integer.valueOf(plan_profit.getText().trim()));
            insertPlan.setPlan_time(LocalDateTime.now());
            insertPlan.setPlan_stand(plan_stand.getText().trim());
            insertPlan.setStaff_id((Integer) Controller.staRoot.getUserData());
            insertPlan.setId(plan.getId());
            if("no".equals(plan_markStr))
            {
               insertPlan.setPlan_mark(0);
            }else
            {
               insertPlan.setPlan_mark(1);
            }
            System.out.println("debug" + group.getSelectedToggle().getUserData());
            int n=planServerImp.upPlan(insertPlan);
            if(n==1){
               InfoUtils.alertUtil("修改成功!修改时间"+LocalDateTime.now(),"提示",Alert.AlertType.INFORMATION);
            }else {
               InfoUtils.alertUtil("添加失败!","提示",Alert.AlertType.ERROR);
            }
         }else {
            InfoUtils.alertUtil("必须为数字!","警示", Alert.AlertType.WARNING);
         }

      }
   }


}