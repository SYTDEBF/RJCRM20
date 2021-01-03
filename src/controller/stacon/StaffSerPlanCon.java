package controller.stacon;

import controller.adcon.Controller;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Order;
import domain.Plan;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffSerPlanCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView<Plan> serre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH, "70px");
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

        serre.setItems((ObservableList<Plan>) Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(idCol, custom_nameCol, shop_nameCol, typenameCol, shop_priceCol);
    }
    }
