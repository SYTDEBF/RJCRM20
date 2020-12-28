package controller.adcon;

import dto.OrderDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import serverimp.OrderServerImp;
import ui.MyDialog;
import ui.adorder.MyAdOrderDia;

import java.net.URL;
import java.util.List;
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

    OrderDto customSer;

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
        test.getColumns().addAll(idCol, custom_nameCol, shop_nameCol, typenameCol, shop_priceCol, staff_departCol);

        AdStaffCon.butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<OrderDto>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends OrderDto> observableValue,
                            OrderDto oldItem, OrderDto newItem) {
                        customSer = newItem;
                    }
                });
    }
    public void addOrderUi ()
    {
        MyDialog myDialog=new MyAdOrderDia();
        Dialog dialog=myDialog.creMYDia(Controller.primaryStage);
        dialog.showAndWait();
    }
    public void upCusUi ()
    {

    }
    public void serCusUi ()
    {

    }
}
