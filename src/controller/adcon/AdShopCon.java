package controller.adcon;

import domain.Shop;
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
import serverimp.ShopServerImp;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdShopCon implements Initializable {

    ObservableList<Shop> users = FXCollections.observableArrayList();

    @FXML
    TableView<Shop> test;

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

    Shop shop;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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


        ShopServerImp shopServerImp=new ShopServerImp();
        List<Shop> shops=shopServerImp.getAllShop();
        users.addAll(shops);


        test.setItems(users);
        test.setEditable(true);
        test.getColumns().addAll(firstNameCol, lastNameCol, emailCol,adressCol,creditCol);

        AdStaffCon.butIcon(addBut, edBut, delBut, reBut, serBut);
        test.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Shop>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends Shop> observableValue,
                            Shop oldShop, Shop newItem) {
                        shop=newItem;
                    }
                });

    }
    public void addShopUi(){}
    public void upShopUi(){}
    public void serShopUi(){}
}
