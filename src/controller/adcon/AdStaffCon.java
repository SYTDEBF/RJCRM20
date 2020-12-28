package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Staff;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import server.StaffServer;
import serverimp.CustomServerImp;
import serverimp.StaffServerImp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdStaffCon implements Initializable {
    ObservableList<Staff> users = FXCollections.observableArrayList();

    @FXML
    TableView<Staff> test;

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

    Staff staff;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn firstNameCol = new TableColumn("员工编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn lastNameCol = new TableColumn("员工姓名");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_name"));

        TableColumn emailCol = new TableColumn("部门");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_depart"));

        TableColumn adressCol = new TableColumn("负责食品");
        adressCol.setMinWidth(200);
        adressCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_shop_type"));

        TableColumn creditCol = new TableColumn("薪水");
        creditCol.setMinWidth(200);
        creditCol.setCellValueFactory(
                new PropertyValueFactory<>("staff_salary"));


        StaffServerImp staffServerImp=new StaffServerImp();
        List<Staff> staffList=staffServerImp.getAllStaff();
        users.addAll(staffList);

        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol,creditCol);

        butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldItem, newItem) -> staff=newItem);
    }

    static void butIcon(Button addBut, Button edBut, Button delBut, Button reBut, Button serBut) {
        GlyphsDude.setIcon(addBut, FontAwesomeIcon.PLUS,"17px");
        GlyphsDude.setIcon(edBut, FontAwesomeIcon.EDIT,"17px");
        GlyphsDude.setIcon(delBut, FontAwesomeIcon.TRASH,"17px");
        GlyphsDude.setIcon(reBut,FontAwesomeIcon.REFRESH,"17px");
        GlyphsDude.setIcon(serBut,FontAwesomeIcon.SEARCH,"17px");
    }
    public void addCusUi(){

    }
    public void serCusUi()
    {

    }
    public void upCusUi()
    {

    }
}
