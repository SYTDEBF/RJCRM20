package controller.adcon;



import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        Tab tab=new Tab("用户信息");
        Tab welTab=new Tab("首页");
        Tab orderTab=new Tab("订单信息");
        Tab shopTab=new Tab("商品信息");
        Tab shopTypeTab=new Tab("商品类型");
        Tab staffTab=new Tab("员工信息");
        Tab settingTab=new Tab();
        Label label1=new Label();
        GlyphsDude.setIcon(label1, FontAwesomeIcon.COG,"20px");
        settingTab.setGraphic(label1);
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
            VBox shopVBox= FXMLLoader.load(getClass().getResource("/fxml/AdminShop.fxml"));
            shopTab.setContent(shopVBox);
            BorderPane borderPane=FXMLLoader.load(getClass().getResource("/fxml/AdSetting.fxml"));
            settingTab.setContent(borderPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        wordText1.getTabs().addAll(tabZero,welTab,tab,staffTab,shopTab,shopTypeTab,orderTab,settingTab);
        wordText1.getSelectionModel().select(1);
    }

}
