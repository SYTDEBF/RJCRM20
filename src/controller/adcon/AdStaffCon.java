package controller.adcon;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.Order;
import domain.Shop;
import domain.Staff;
import dto.OrderDto;
import dto.StaffDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import server.StaffServer;
import serverimp.CustomServerImp;
import serverimp.OrderServerImp;
import serverimp.ShopServerImp;
import serverimp.StaffServerImp;
import ui.MyDialog;
import ui.adminuser.*;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdStaffCon implements Initializable {
    ObservableList<StaffDto> users = FXCollections.observableArrayList();

    @FXML
    TableView<StaffDto> test;

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

    StaffDto staffDto;

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


        StaffServerImp staffServerImp=new StaffServerImp();
        List<StaffDto> staffList=staffServerImp.getAllStaff();
        users.addAll(staffList);

        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(firstNameCol, lastNameCol, passwordCol,emailCol,adressCol,creditCol);

        butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldItem, newItem) -> staffDto=newItem);
    }

    static void butIcon(Button addBut, Button edBut, Button delBut, Button reBut, Button serBut) {
        GlyphsDude.setIcon(addBut, FontAwesomeIcon.PLUS,"17px");
        GlyphsDude.setIcon(edBut, FontAwesomeIcon.EDIT,"17px");
        GlyphsDude.setIcon(delBut, FontAwesomeIcon.TRASH,"17px");
        GlyphsDude.setIcon(reBut,FontAwesomeIcon.REFRESH,"17px");
        GlyphsDude.setIcon(serBut,FontAwesomeIcon.SEARCH,"17px");
    }
    public void addStaffUi(){
        MyDialog addStaffDia=new MyAddStaffDia();
        Dialog dialog=addStaffDia.creMYDia(Controller.primaryStage);
        dialog.showAndWait();
    }
    public void serStaUi()
    {
        if(serText.getText().trim()==null)
        {
            InfoUtils.alertUtil("请输入搜索内容","警告", Alert.AlertType.WARNING);
        }else {
            StaffServerImp staffServerImp=new StaffServerImp();
            List<StaffDto> staffDtos = staffServerImp.getStaffByIdOrName(serText.getText().trim());
            if (staffDtos.isEmpty())
            {
                InfoUtils.alertUtil("无搜索结果","信息", Alert.AlertType.INFORMATION);
            }else
            {
                MyDialog serOrderDia=new MyAdSatSerCon();
                ObservableList<StaffDto> observableList = FXCollections.observableArrayList();
                observableList.addAll(staffDtos);
                Controller.primaryStage.setUserData(observableList);
                Dialog dialog=serOrderDia.creMYDia(Controller.primaryStage);
                dialog.showAndWait();
            }
        }
    }
    public void upStaUi()
    {
        if (staffDto==null)
        {
            InfoUtils.alertUtil("请选择一行数据","提示", Alert.AlertType.INFORMATION);
        }else{
            StaffServerImp staffServerImp=new StaffServerImp();
            List<Staff>staffs=staffServerImp.getStaffById(staffDto.getId());
            if(staffs.get(0)!=null)
            {
                Controller.primaryStage.setUserData(staffs.get(0));
                MyDialog upStaDia = new MyAdUpStaCia();
                Dialog dialog = upStaDia.creMYDia(Controller.primaryStage);
                dialog.showAndWait();
            }
        }
    }
    public void refreshStaff()
    {
        StaffServerImp staffServerImp=new StaffServerImp();
        List<StaffDto> staffDtos = staffServerImp.getAllStaff();
        users.clear();
        users.addAll(staffDtos);
        test.refresh();
    }
}
