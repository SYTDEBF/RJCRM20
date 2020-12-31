package controller.adcon;

import domain.Admin;
import domain.Custom;
import domain.Order;
import dto.OrderDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import serverimp.CustomServerImp;
import serverimp.OrderServerImp;
import ui.MyDialog;
import ui.adminuser.MyAdOrderUpDia;
import ui.adminuser.MyAdSerUserDia;
import ui.adminuser.MyAdUpUserDia;
import ui.adminuser.MyAdminOrderSerDia;
import ui.adorder.MyAdOrderDia;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminOrderCon implements Initializable {
    ObservableList<OrderDto> users = FXCollections.observableArrayList();

    @FXML
    TableView<OrderDto> test;

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

    OrderDto orderDto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn idCol = new TableColumn("订单编号");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn custom_nameCol = new TableColumn("客户姓名");
        custom_nameCol.setMinWidth(100);
        custom_nameCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_name"));

        TableColumn shop_nameCol = new TableColumn("商品名称");
        shop_nameCol.setMinWidth(200);
        shop_nameCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_name"));

        TableColumn typenameCol = new TableColumn("商品类型");
        typenameCol.setMinWidth(200);
        typenameCol.setCellValueFactory(
                new PropertyValueFactory<>("typename"));

        TableColumn shop_priceCol = new TableColumn("商品价格");
        shop_priceCol.setMinWidth(200);
        shop_priceCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_price"));

        TableColumn staff_nameCol = new TableColumn("员工姓名");
        staff_nameCol.setMinWidth(200);
        staff_nameCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_name"));

        TableColumn staff_departCol = new TableColumn("员工部门");
        staff_departCol.setMinWidth(200);
        staff_departCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_depart"));

        OrderServerImp orderServerImp=new OrderServerImp();
        List<OrderDto> customList = orderServerImp.getAllOrder();
        users.addAll(customList);


        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(idCol, custom_nameCol, shop_nameCol, typenameCol, staff_nameCol,shop_priceCol, staff_departCol);

        AdStaffCon.butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<OrderDto>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends OrderDto> observableValue,
                            OrderDto oldItem, OrderDto newItem) {
                        orderDto = newItem;
                    }
                });
    }
    public void addOrderUi ()
    {
        MyDialog myDialog=new MyAdOrderDia();
        Dialog dialog=myDialog.creMYDia(Controller.primaryStage);
        dialog.showAndWait();

    }
    public void editOrderUI ()
    {
        if (orderDto==null)
        {
            InfoUtils.alertUtil("请选择一行数据","提示", Alert.AlertType.INFORMATION);
        }else{
            OrderServerImp orderServerImp=new OrderServerImp();
            List<Order> orders=orderServerImp.getOrderById(orderDto.getId());
            if(orders.get(0)!=null)
            {
                Controller.primaryStage.setUserData(orders.get(0));
                MyDialog addUserDia = new MyAdOrderUpDia();
                Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
                dialog.showAndWait();
            }

        }
    }
    public void delOrder()
    {
        if (orderDto==null)
        {
            InfoUtils.alertUtil("请选择一行数据","", Alert.AlertType.WARNING);
        }else
        {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("你确定要删除吗");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                OrderServerImp orderServerImp=new OrderServerImp();
                int n=orderServerImp.deleteOrder(orderDto.getId());
                if (n==1)
                {
                    InfoUtils.alertUtil("删除成功","", Alert.AlertType.INFORMATION);
                    refreshOrder();
                }else
                {
                    InfoUtils.alertUtil("删除失败","", Alert.AlertType.WARNING);
                }

            }

        }
    }
    public void orderSerUi ()
    {
        if(serText.getText().trim()==null)
        {
            InfoUtils.alertUtil("请输入搜索内容","警告", Alert.AlertType.WARNING);
        }else {
            OrderServerImp orderServerImp=new OrderServerImp();
            List<Order> orders = orderServerImp.getOrderById(Integer.valueOf(serText.getText().trim()));
            if (orders.isEmpty())
            {
                InfoUtils.alertUtil("无搜索结果","信息", Alert.AlertType.INFORMATION);
            }else
            {
                MyDialog serOrderDia=new MyAdminOrderSerDia();
                ObservableList<Order> observableList = FXCollections.observableArrayList();
                observableList.addAll(orders);
                Controller.primaryStage.setUserData(observableList);
                Dialog dialog=serOrderDia.creMYDia(Controller.primaryStage);
                dialog.showAndWait();
            }
        }
    }
    public void refreshOrder()
    {
        OrderServerImp orderServerImp=new OrderServerImp();
        List<OrderDto> customList = orderServerImp.getAllOrder();
        users.clear();
        users.addAll(customList);
        test.refresh();
    }

}
