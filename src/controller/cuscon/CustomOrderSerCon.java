package controller.cuscon;

import controller.adcon.Controller;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Order;
import dto.OrderDto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomOrderSerCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView<OrderDto> serre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH,"70px");
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



        serre.setItems((ObservableList<OrderDto>) Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(idCol, custom_nameCol, shop_nameCol, typenameCol, shop_priceCol, staff_departCol);
    }
}
