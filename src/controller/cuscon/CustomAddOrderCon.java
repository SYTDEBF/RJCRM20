package controller.cuscon;

import controller.adcon.Controller;
import domain.Custom;
import domain.Order;
import domain.Shop;
import dto.StaffDto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import serverimp.CustomServerImp;
import serverimp.OrderServerImp;
import serverimp.ShopServerImp;
import serverimp.StaffServerImp;
import util.InfoUtils;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class CustomAddOrderCon implements Initializable {
    @FXML
    TextField custom_id;
    @FXML
    TextField shop_id;
    @FXML
    TextField staff_id;
    @FXML
    TextField cusser;
    @FXML
    TextField shopser;
    @FXML
    TextField staffser;
    @FXML
    ListView serre;
    @FXML
    Button clearbut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          custom_id.setText(String.valueOf(Controller.cusRoot.getUserData()));
    }
    public void sendInfo()
    {

          if(custom_id.getText().isEmpty()||shop_id.getText().isEmpty()||staff_id.getText().isEmpty())
          {
              InfoUtils.alertUtil("不能为空","", Alert.AlertType.ERROR);
          }else if(InfoUtils.isInteger(custom_id.getText())&&InfoUtils.isInteger(shop_id.getText())&&InfoUtils.isInteger(staff_id.getText()))
          {
              LocalDateTime localDateTime=LocalDateTime.now();
              Order order=new Order(Integer.valueOf(custom_id.getText().trim()),
                      Integer.valueOf(shop_id.getText().trim()),
                      Integer.valueOf(staff_id.getText().trim()),
                      localDateTime);
              OrderServerImp serverImp=new OrderServerImp();
              int n=serverImp.addOrder(order);
              if (n==1)
              {
                  InfoUtils.alertUtil("成功，订单创建时间:"+localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),"", Alert.AlertType.CONFIRMATION);
              }else
              {
                  InfoUtils.alertUtil("失败","", Alert.AlertType.ERROR);
              }
          }
          else
          {
             InfoUtils.alertUtil("必须为数字","",Alert.AlertType.WARNING);
          }
    }
    public synchronized void cusHandle(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            serre.getItems().clear();
            CustomServerImp customServerImp = null;
            try {
                customServerImp = new CustomServerImp();
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<Custom> customList = customServerImp.findCustomsByIdOrName(cusser.getText().trim());
            if (customList.size()!=0){
                for (Custom c :customList
                ) {
                    serre.getItems().add(c);

                }
            }else
            {
                serre.getItems().add("无搜索结果");
            }

        }

    }
    public void shopHandle(KeyEvent event)
    {
        if (event.getCode() == KeyCode.ENTER) {
            serre.getItems().clear();
            ShopServerImp shopServerImp = null;
            shopServerImp = new ShopServerImp();
            List<Shop> shopList = shopServerImp.getShopByIdOrName(shopser.getText().trim());
            if (shopList.size()!=0){
                for (Shop c :shopList
                ) {
                    serre.getItems().add(c);
                }
            }else
            {
                serre.getItems().add("无搜索结果");
            }

        }
    }
    public void staffHandle(KeyEvent event)
    {
        if (event.getCode() == KeyCode.ENTER) {
            serre.getItems().clear();
            StaffServerImp staffServerImp = null;
            staffServerImp = new StaffServerImp();
            List<StaffDto> staffList = staffServerImp.getStaffByIdOrName(staffser.getText().trim());
            if (staffList.size()!=0){
                for ( StaffDto c:staffList
                ) {
                    serre.getItems().add(c);
                }
            }else
            {
                serre.getItems().add("无搜索结果");
            }

        }
    }

}
