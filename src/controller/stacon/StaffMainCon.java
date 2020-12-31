package controller.stacon;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StaffMainCon implements Initializable {
    @FXML
    TabPane wordText1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Text text=new Text("管理员");
        text.relocate(16,28);

        //add.setOnAction(action-> addUerPane.afterShow(new ADminUiTest()));

        wordText1.setSide(Side.LEFT);
        wordText1.setRotateGraphic(true);
        Tab tabZero=new Tab();
        ImageView imageView = new ImageView(new Image("/img/crm.png"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        Label label=new Label();
        label.setPadding(new Insets(48,0,0,0));
        label.setGraphic(imageView);
        tabZero.setGraphic(label);
        tabZero.setDisable(true);
        Tab infoTab=new Tab("个人信息");
        BorderPane borderPane=null;
        try {
            borderPane=FXMLLoader.load(getClass().getResource("/fxml/StaffInfo.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        infoTab.setContent(borderPane);


        Tab welTab=new Tab("业绩信息");
//        StackPane stackPane= null;
//        try {
//            stackPane = FXMLLoader.load(getClass().getResource("/fxml/CustomShop.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Tab orderTab=new Tab("订单信息");
        VBox orderVBox= null;
        try {
            orderVBox = FXMLLoader.load(getClass().getResource("/fxml/StaffOrder.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderTab.setContent(orderVBox);
        Tab planTab=new Tab("工作计划");


        wordText1.getTabs().addAll(tabZero,welTab,orderTab,infoTab,planTab);
        wordText1.getSelectionModel().select(1);
    }

}
