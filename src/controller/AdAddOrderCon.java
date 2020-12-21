package controller;

import domain.Order;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import serverimp.OrderServerImp;
import util.InfoUtils;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AdAddOrderCon implements Initializable {
    @FXML
    TextField custom_id;
    @FXML
    TextField shop_id;
    @FXML
    TextField staff_id;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void sendInfo()
    {

          if(custom_id.getText().isEmpty()||shop_id.getText().isEmpty()||staff_id.getText().isEmpty())
          {
              InfoUtils.alertUtil("不能为空","", Alert.AlertType.WARNING);
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
          System.out.println(LocalDate.now());
    }
}
