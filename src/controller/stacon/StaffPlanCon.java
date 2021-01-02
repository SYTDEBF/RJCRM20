package controller.stacon;

import controller.adcon.AdStaffCon;
import controller.adcon.Controller;
import domain.Order;
import domain.Plan;
import dto.OrderDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import server.PlanServer;
import serverimp.OrderServerImp;
import serverimp.PlanServerImp;
import ui.MyDialog;
import ui.adminuser.*;
import util.InfoUtils;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StaffPlanCon implements Initializable {
    ObservableList<Plan> users = FXCollections.observableArrayList();

    @FXML
    TableView<Plan> test;

    @FXML
    Button addBut;

    @FXML
    Button edBut;

    @FXML
    Button delBut;

    @FXML
    Button reBut;

    @FXML
    Button serBut;

    @FXML
    TextField serText;

    Plan plan;
    PlanServerImp planServerImp=new PlanServerImp();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn idCol = new TableColumn("计划编号");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn custom_nameCol = new TableColumn("计划内容");
        custom_nameCol.setMinWidth(100);
        custom_nameCol.setCellValueFactory(
                new PropertyValueFactory<>("plan_stand"));

        TableColumn shop_nameCol = new TableColumn("计划销量");
        shop_nameCol.setMinWidth(200);
        shop_nameCol.setCellValueFactory(
                new PropertyValueFactory<>("plan_profit"));

        TableColumn typenameCol = new TableColumn("完成情况");
        typenameCol.setMinWidth(200);
        typenameCol.setCellValueFactory(
                new PropertyValueFactory<>("plan_mark"));

        TableColumn shop_priceCol = new TableColumn("创建时间");
        shop_priceCol.setMinWidth(200);
        shop_priceCol.setCellValueFactory(
                new PropertyValueFactory<>("plan_time"));

        List<Plan> planList = planServerImp.getPlanByStaId((Integer) Controller.staRoot.getUserData());
        users.addAll(planList);


        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(idCol, custom_nameCol, shop_nameCol, typenameCol,shop_priceCol);

        AdStaffCon.butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldItem, newItem) -> plan = newItem);
    }
    public void addOrderUi ()
    {
        MyDialog myDialog=new MyStaffAddPlanDia();
        Dialog dialog=myDialog.creMYDia(Controller.primaryStage);
        dialog.showAndWait();

    }
    public void editOrderUI ()
    {
        if (plan==null)
        {
            InfoUtils.alertUtil("请选择一行数据","提示", Alert.AlertType.INFORMATION);
        }else{
                Controller.primaryStage.setUserData(plan);
                MyDialog addPlanDia = new MyStaffUpPlanDia();
                Dialog dialog = addPlanDia.creMYDia(Controller.primaryStage);
                dialog.showAndWait();
        }
    }
    public void delOrder()
    {
        if (plan==null)
        {
            InfoUtils.alertUtil("请选择一行数据","", Alert.AlertType.WARNING);
        }else
        {
//
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("你确定要删除吗");
//
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.get() == ButtonType.OK){
//                // ... user chose OK
//                OrderServerImp orderServerImp=new OrderServerImp();
//                int n=orderServerImp.deleteOrder(orderDto.getId());
//                if (n==1)
//                {
//                    InfoUtils.alertUtil("删除成功","", Alert.AlertType.INFORMATION);
//                    refreshOrder();
//                }else
//                {
//                    InfoUtils.alertUtil("删除失败","", Alert.AlertType.WARNING);
//                }
//
//            }

        }
    }
    public void orderSerUi ()
    {
//        if(serText.getText().trim()==null)
//        {
//            InfoUtils.alertUtil("请输入搜索内容","警告", Alert.AlertType.WARNING);
//        }else {
//            OrderServerImp orderServerImp=new OrderServerImp();
//            List<OrderDto> orders = orderServerImp.getOrderDtoByIdOrNameCus((Integer)Controller.cusRoot.getUserData());
//            if (orders.isEmpty())
//            {
//                InfoUtils.alertUtil("无搜索结果","信息", Alert.AlertType.INFORMATION);
//            }else
//            {
//                MyDialog serOrderDia=new MyCustomOrderSerDia();
//                ObservableList<OrderDto> observableList = FXCollections.observableArrayList();
//                observableList.addAll(orders);
//                Controller.primaryStage.setUserData(observableList);
//                Dialog dialog=serOrderDia.creMYDia(Controller.primaryStage);
//                dialog.showAndWait();
//            }
//        }
    }
    public void refreshOrder()
    {
        List<Plan> planList = planServerImp.getPlanByStaId((Integer) Controller.staRoot.getUserData());
        users.clear();
        users.addAll(planList);
        test.setItems(users);
        test.refresh();
    }

}
