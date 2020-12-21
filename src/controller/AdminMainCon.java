package controller;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminMainCon implements Initializable {
    @FXML
    Pane leftPane;

    @FXML
    TabPane wordText1;





    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Text text=new Text("管理员");
        text.relocate(16,28);

        //add.setOnAction(action-> addUerPane.afterShow(new ADminUiTest()));
        leftPane.getChildren().addAll(text);
        Tab tab=new Tab("用户信息");
        Tab welTab=new Tab("首页");
        Tab orderTab=new Tab("订单信息");
        Tab shopTypeTab=new Tab("商品类型");
        Tab staffTab=new Tab("员工信息");
        try {
            StackPane stackPane=FXMLLoader.load(getClass().getResource("/fxml/AdminWel.fxml"));
            welTab.setContent(stackPane);
            VBox vBox= FXMLLoader.load(getClass().getResource("/fxml/AdminUserInfo.fxml"));
            tab.setContent(vBox);
            VBox staffVBox= FXMLLoader.load(getClass().getResource("/fxml/AdminStaff.fxml"));
            staffTab.setContent(staffVBox);

            SplitPane splitPane = FXMLLoader.load(getClass().getResource("/fxml/ShopType.fxml"));
            shopTypeTab.setContent(splitPane);
            VBox orderVBox= FXMLLoader.load(getClass().getResource("/fxml/AdminOrder.fxml"));
            orderTab.setContent(orderVBox);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordText1.getTabs().addAll(welTab,tab,staffTab,shopTypeTab,orderTab);
    }

}
