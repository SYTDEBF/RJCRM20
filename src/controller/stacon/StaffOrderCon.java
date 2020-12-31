package controller.stacon;


import controller.adcon.Controller;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import dto.OrderDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import serverimp.OrderServerImp;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StaffOrderCon implements Initializable {
    ObservableList<OrderDto> users = FXCollections.observableArrayList();

    @FXML
    TableView<OrderDto> test;
    @FXML
    Button reBut;

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
        GlyphsDude.setIcon(reBut, FontAwesomeIcon.REFRESH,"17px");
       // System.out.println("asd"+CrmCookies.getCookies("cus_id"));
        List<OrderDto> customList = orderServerImp.getOrderByStaffId((Integer) Controller.staRoot.getUserData());
        users.addAll(customList);

        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(idCol, custom_nameCol, shop_nameCol, typenameCol,staff_nameCol, shop_priceCol, staff_departCol);


    }
    public void refreshOrder()
    {
        OrderServerImp orderServerImp=new OrderServerImp();
        List<OrderDto> customList = orderServerImp.getOrderByStaffId((Integer) Controller.cusRoot.getUserData());
        users.clear();
        users.addAll(customList);
        test.refresh();
    }

}
