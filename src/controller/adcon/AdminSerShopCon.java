package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Shop;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminSerShopCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView<Shop> serre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH,"70px");
        TableColumn firstNameCol = new TableColumn("编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn lastNameCol = new TableColumn("商品名称");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_name"));

        TableColumn emailCol = new TableColumn("商品日期");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_date"));

        TableColumn adressCol = new TableColumn("商品地址");
        adressCol.setMinWidth(200);
        adressCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_type"));

        TableColumn creditCol = new TableColumn("价格");
        creditCol.setMinWidth(200);
        creditCol.setCellValueFactory(
                new PropertyValueFactory<>("shop_price"));

        serre.setItems((ObservableList<Shop>) Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol,creditCol);

    }
}
