package controller.adcon;

import domain.Custom;
import dto.OrderDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import serverimp.CustomServerImp;
import serverimp.OrderServerImp;
import ui.adminuser.MyAdSerUserDia;
import ui.adminuser.MyAdUpUserDia;
import ui.adminuser.MyAdminAddDia;
import ui.MyDialog;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminUserInfoCon implements Initializable {
    ObservableList<Custom> users = FXCollections.observableArrayList();

    @FXML
    TableView<Custom> test;

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

    Custom customSer;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TableColumn firstNameCol = new TableColumn("编号");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("id"));

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



        try {
            CustomServerImp customServerImp=new CustomServerImp();
            List<Custom>customList=customServerImp.getAllCustoms();
            users.addAll(customList);
        } catch (IOException e) {
            e.printStackTrace();
        }


        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol,creditCol,passWordCol);

        AdStaffCon.butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Custom>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Custom> observableValue,
                            Custom oldItem, Custom newItem) {
                        customSer=newItem;
                    }
                });

    }
    public void addCusUi(){
        MyDialog addUserDia=new MyAdminAddDia();
        Dialog dialog=addUserDia.creMYDia(Controller.primaryStage);
        dialog.showAndWait();
    }
    public void serCusUi()
    {

        try {
            if(serText.getText().trim()==null)
            {
                InfoUtils.alertUtil("请输入搜索内容","警告", Alert.AlertType.WARNING);
            }else {
                CustomServerImp customServerImp = new CustomServerImp();
                List<Custom> customList = customServerImp.findCustomsByIdOrName(serText.getText().trim());
                if (customList.isEmpty())
                {
                    InfoUtils.alertUtil("无搜索结果","信息", Alert.AlertType.INFORMATION);
                }else
                {
                    MyDialog addUserDia=new MyAdSerUserDia();
                    ObservableList<Custom> serUsers = FXCollections.observableArrayList();
                    serUsers.addAll(customList);
                    Controller.primaryStage.setUserData(serUsers);
                    Dialog dialog=addUserDia.creMYDia(Controller.primaryStage);
                    dialog.showAndWait();


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void upCusUi()
    {
        if (customSer==null)
        {
            InfoUtils.alertUtil("请选择一行数据","提示", Alert.AlertType.INFORMATION);
        }else{
            Controller.primaryStage.setUserData(customSer);
            MyDialog addUserDia = new MyAdUpUserDia();
            Dialog dialog = addUserDia.creMYDia(Controller.primaryStage);
            dialog.showAndWait();
        }

    }
    public void delCus()
    {
        if (customSer==null)
        {
            InfoUtils.alertUtil("请选择一行数据","", Alert.AlertType.WARNING);
        }else
        {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("你确定要删除吗,删除用户将会删除用户的所有信息,包括订单信息");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

                OrderServerImp orderServerImp=new OrderServerImp();
                int n=orderServerImp.delOrderByCusId(customSer.getId());
                try {
                    CustomServerImp customServerImp=new CustomServerImp();
                    int n1=customServerImp.deleteCustom(customSer.getId());
                    if (n1==1)
                    {
                        InfoUtils.alertUtil("删除成功","", Alert.AlertType.INFORMATION);
                        refreshCus();
                    }else
                    {
                        InfoUtils.alertUtil("删除失败","", Alert.AlertType.WARNING);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }

        }
    }
    public void refreshCus()
    {
        CustomServerImp customServerImp= null;
        try {
            customServerImp = new CustomServerImp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Custom> customList = customServerImp.getAllCustoms();
        users.clear();
        users.addAll(customList);
        test.refresh();
    }



}
