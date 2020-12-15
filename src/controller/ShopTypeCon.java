package controller;

import com.alibaba.fastjson.JSONObject;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import domain.Custom;
import domain.ShopType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import serverimp.CustomServerImp;
import serverimp.ShopTypeServerImp;
import ui.adminuser.MyAdSerUserDia;
import ui.MyDialog;
import ui.shoptype.MyShopTypeAddDia;
import util.InfoUtils;
import util.TreeObjectUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShopTypeCon implements Initializable {
    ObservableList<ShopType> users = FXCollections.observableArrayList();

    @FXML
    TableView<ShopType> test;

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
    @FXML
    WebView we;

    Custom customSer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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



            ShopTypeServerImp customServerImp = new ShopTypeServerImp();
            List<ShopType> shopTypes = customServerImp.findAll();
            users.addAll(shopTypes);



        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(firstNameCol, lastNameCol, emailCol, adressCol);
        TreeObjectUtils<ShopType> shopTypeTreeObjectUtils=new TreeObjectUtils<>();
        List<ShopType> ass=shopTypeTreeObjectUtils.get1(shopTypes);
        URL url = null;
        try {
            url = new File("res/html/css/test.html").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        final WebEngine webEngine = we.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (Worker.State.SUCCEEDED == newValue) {
                webEngine.executeScript("shopTypeTree("+ JSONObject.parse(ass.toString()).toString()+");");
            }
        });
        System.out.println(url.toString());
        webEngine.load(url.toString());

        AdStaffCon.butIcon(addBut, edBut, delBut, reBut, serBut);
//        test.getSelectionModel().selectedItemProperty().addListener(
//                new ChangeListener<Custom>() {
//                    @Override
//                    public void changed(
//                            ObservableValue<? extends Custom> observableValue,
//                            Custom oldItem, Custom newItem) {
//                        customSer=newItem;
//                    }
//                });
//
//    }
    }

    public void addCusUi() {
        MyDialog addUserDia = new MyShopTypeAddDia();
        Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
        Controller.primaryStage.setUserData(we);
        dialog.showAndWait();
    }

    public void serCusUi() {

        try {
            if (serText.getText().trim() == null) {
                InfoUtils.alertUtil("请输入搜索内容", "警告", Alert.AlertType.WARNING);
            } else {
                CustomServerImp customServerImp = new CustomServerImp();
                List<Custom> customList = customServerImp.findCustomsByIdOrName(serText.getText().trim());
                if (customList.isEmpty()) {
                    InfoUtils.alertUtil("无搜索结果", "信息", Alert.AlertType.INFORMATION);
                } else {
                    MyDialog addUserDia = new MyAdSerUserDia();
                    ObservableList<Custom> serUsers = FXCollections.observableArrayList();
                    serUsers.addAll(customList);
                    Controller.primaryStage.setUserData(serUsers);
                    Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
                    dialog.showAndWait();


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upCusUi() {
//        if (customSer == null) {
//            InfoUtils.alertUtil("请选择一行数据", "提示", Alert.AlertType.INFORMATION);
//        } else {
//            Controller.primaryStage.setUserData(customSer);
//            MyDialog addUserDia = new MyAdUpUserDia();
//            Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
//            dialog.showAndWait();
//        }


    }


}
