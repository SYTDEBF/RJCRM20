package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Order;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminOrderSerCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView<Order> serre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH,"70px");
        TableColumn firstNameCol =
                new TableColumn("编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn lastNameCol = new TableColumn("客户编号");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_id"));

        TableColumn emailCol = new TableColumn("商品编号");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_id"));

        TableColumn adressCol = new TableColumn("员工编号");
        adressCol.setMinWidth(200);
        adressCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_id"));
        serre.setItems((ObservableList<Order>) Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol);
    }
}
