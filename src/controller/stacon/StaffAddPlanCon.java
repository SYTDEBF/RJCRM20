package controller.stacon;

import controller.adcon.Controller;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Plan;
import domain.Staff;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import serverimp.PlanServerImp;
import serverimp.StaffServerImp;
import util.InfoUtils;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class StaffAddPlanCon implements Initializable {

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(addLabel, FontAwesomeIcon.USER_PLUS, "70px");
        yes_rad.setToggleGroup(group);
        no_rad.setToggleGroup(group);
        no_rad.setSelected(true);
        yes_rad.setUserData("yes");
        no_rad.setUserData("no");
        yes_rad.setDisable(true);
        group.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
                    if (group.getSelectedToggle() != null) {
                          plan_markStr=group.getSelectedToggle().getUserData().toString();
                    }
                }
    );
}


    public void sendInfo() {
        if (plan_profit.getText().isEmpty()  || plan_stand.getText().isEmpty() || plan_markStr == null) {
            InfoUtils.alertUtil("所有信息不能为空!", "警示", Alert.AlertType.WARNING);
        } else {
            if (InfoUtils.isInteger(plan_profit.getText())) {
                PlanServerImp planServerImp = new PlanServerImp();
                Plan plan = new Plan();
                plan.setPlan_profit(Integer.valueOf(plan_profit.getText().trim()));
                plan.setPlan_time(LocalDateTime.now());
                plan.setPlan_stand(plan_stand.getText().trim());
                plan.setStaff_id((Integer)Controller.staRoot.getUserData());
                if("no".equals(plan_markStr))
                {
                    plan.setPlan_mark(0);
                }
                System.out.println("debug" + group.getSelectedToggle().getUserData());
                int n=planServerImp.addPlan(plan);
                if(n==1){
                    InfoUtils.alertUtil("添加成功!创建时间"+LocalDateTime.now(),"提示",Alert.AlertType.INFORMATION);
                }else {
                    InfoUtils.alertUtil("添加失败!","提示",Alert.AlertType.ERROR);
                }
            }else {
                InfoUtils.alertUtil("必须为数字!","警示", Alert.AlertType.WARNING);
            }

        }
    }
}
