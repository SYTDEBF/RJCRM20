package controller;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminSerUserCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView serre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH,"70px");
        TableColumn firstNameCol =
                new TableColumn("编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn lastNameCol = new TableColumn("姓名");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_name"));

        TableColumn emailCol = new TableColumn("联系方式");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_phone"));

        TableColumn adressCol = new TableColumn("联系地址");
        adressCol.setMinWidth(200);
        adressCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_address"));

        TableColumn creditCol = new TableColumn("信用度");
        creditCol.setMinWidth(200);
        creditCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_credit"));
        TableColumn passWordCol = new TableColumn("密码");
        passWordCol.setMinWidth(200);
        passWordCol.setCellValueFactory(
                new PropertyValueFactory<>("custom_password"));

        serre.setItems((ObservableList<Custom>)Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol,creditCol,passWordCol);

    }
}
