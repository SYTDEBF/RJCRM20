package controller.adcon;

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

public class AdStaSerCon implements Initializable {
    @FXML
    Label serLabel;
    @FXML
    TableView<OrderDto> serre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GlyphsDude.setIcon(serLabel, FontAwesomeIcon.SEARCH,"70px");
        TableColumn firstNameCol = new TableColumn("员工编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn lastNameCol = new TableColumn("员工姓名");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_name"));

        TableColumn emailCol = new TableColumn("部门");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_depart"));

        TableColumn passwordCol=new TableColumn("密码");
        passwordCol.setMinWidth(100);
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("staff_password"));

        TableColumn adressCol = new TableColumn("负责商品");
        adressCol.setMinWidth(100);
        adressCol.setCellValueFactory(
                new PropertyValueFactory<>("typename"));

        TableColumn creditCol = new TableColumn("薪水");
        creditCol.setMinWidth(100);
        creditCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_salary"));



        serre.setItems((ObservableList<OrderDto>) Controller.primaryStage.getUserData());
        serre.setEditable(true);
        serre.getColumns().addAll(firstNameCol, lastNameCol, passwordCol,emailCol,adressCol,creditCol);
    }
}
