package controller.adcon;

import com.alibaba.fastjson.JSONObject;
import domain.Custom;
import domain.Shop;
import domain.ShopType;
import dto.ShopDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import serverimp.ShopServerImp;
import serverimp.ShopTypeServerImp;
import ui.adminuser.MyAdSerUserDia;
import ui.MyDialog;
import ui.adminuser.MyAdminSerShopTypeDia;
import ui.adminuser.MyAdminUpShopTypeDia;
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

    ShopType shopType;

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
        test.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<ShopType>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends ShopType> observableValue,
                            ShopType oldItem, ShopType newItem) {
                        shopType=newItem;
                    }
                });

    }


    public void addCusUi() {
        MyDialog addUserDia = new MyShopTypeAddDia();
        Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
        Controller.primaryStage.setUserData(we);
        dialog.showAndWait();
    }
    public void delShopType()
    {
        if(shopType==null)
        {
            InfoUtils.alertUtil("请选择一行数据", "提示", Alert.AlertType.INFORMATION);
        }else
        {
            //非叶子结点不能删除
            if (shopType.getChildren().size()==0&&Integer.valueOf(shopType.getStype())==3)
            {

                ShopTypeServerImp shopTypeServerImp=new ShopTypeServerImp();
                int n=shopTypeServerImp.deleteShopType(shopType.getId());
                if (n==1)
                {
                    InfoUtils.alertUtil("删除成功", "提示", Alert.AlertType.INFORMATION);
                    refreshCus();
                }else
                {
                    InfoUtils.alertUtil("删除失败","", Alert.AlertType.WARNING);
                }
            }else
            {
                InfoUtils.alertUtil("只能删除第三层级的商品类型", "提示", Alert.AlertType.INFORMATION);
            }
        }
    }
    public void serCusUi() {

        if (serText.getText().trim() == null) {
            InfoUtils.alertUtil("请输入搜索内容", "警告", Alert.AlertType.WARNING);
        } else {
            ShopTypeServerImp shopTypeServerImp=new ShopTypeServerImp();
            List<ShopType> shopTypes = shopTypeServerImp.getShopTypeByIdOrName(serText.getText().trim());
            if (shopTypes.isEmpty()) {
                InfoUtils.alertUtil("无搜索结果", "信息", Alert.AlertType.INFORMATION);
            } else {
                MyDialog addUserDia = new MyAdminSerShopTypeDia();
                ObservableList<ShopType> serUsers = FXCollections.observableArrayList();
                serUsers.addAll(shopTypes);
                Controller.primaryStage.setUserData(serUsers);
                Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
                dialog.showAndWait();


            }
        }
    }

    public void upCusUi() {
        if (shopType == null) {
            InfoUtils.alertUtil("请选择一行数据", "提示", Alert.AlertType.INFORMATION);
        } else {
            Controller.primaryStage.setUserData(shopType);
            MyDialog addUserDia = new MyAdminUpShopTypeDia();
            Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
            dialog.showAndWait();
       }


    }
    public void refreshCus()
    {
        ShopTypeServerImp shopTypeServerImp=new ShopTypeServerImp();
        List<ShopType> shopTypes= shopTypeServerImp.findAll();
        users.clear();
        users.addAll(shopTypes);
        test.refresh();
    }


}
