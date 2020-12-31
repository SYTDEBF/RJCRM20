package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Shop;
import domain.ShopType;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdShopTypeSerCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView<ShopType> serre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH,"70px");
        TableColumn firstNameCol = new TableColumn("编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn lastNameCol = new TableColumn("类型名称");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("typename"));

        TableColumn emailCol = new TableColumn("父类型编号");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("parentid"));

        TableColumn adressCol = new TableColumn("类型层级");
        adressCol.setMinWidth(200);
        adressCol.setCellValueFactory(
                new PropertyValueFactory<>("stype"));

        serre.setItems((ObservableList<ShopType>) Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol);
    }
}
